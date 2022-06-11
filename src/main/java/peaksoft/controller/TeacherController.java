package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.exception.TeacherNotFoundException;
import peaksoft.model.Course;
import peaksoft.model.Teacher;
import peaksoft.service.CourseService;
import peaksoft.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    private final CourseService courseService;

    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    @GetMapping("/find/{courseId}")
    public String findTeacher(@PathVariable Long courseId, Model model) {

        Course course = courseService.findById(courseId);

        Teacher teacher = course.getTeacher();

        if (teacher == null) {
            try {
                throw new TeacherNotFoundException(
                        "Teacher with course id = " + courseId + " not found");
            } catch (TeacherNotFoundException e) {

                model.addAttribute("companyId", course.getCompany().getId());

                model.addAttribute("courseId", courseId);

                model.addAttribute("message", e.getMessage());

                return "exception/exceptionHandler";
            }
        }

        model.addAttribute("companyId", course.getCompany().getId());

        model.addAttribute("teacher", teacher);

        return "teacher/findTeacher";
    }

    @GetMapping("/save/{courseId}")
    public String showSaveTeacherCourse(@PathVariable Long courseId, Model model) {

        model.addAttribute("courseId", courseId);

        model.addAttribute("emtyTeacher", new Teacher());

        return "teacher/saveTeacherPage";
    }

    @PostMapping("/save/{courseId}")
    public String saveTeacherCourse(@PathVariable Long courseId, Teacher teacher) {

        teacherService.save(teacher, courseId);

        return "redirect:/api/teachers/find/{courseId}";
    }

    @GetMapping("/save/teacher/{courseId}")
    public String showSaveTeacher(@PathVariable Long courseId, Model model) {

        Course course = courseService.findById(courseId);

        model.addAttribute("companyId", course.getCompany().getId());

        model.addAttribute("courseId", courseId);

        model.addAttribute("emtyTeacher", new Teacher());

        return "teacher/saveTeacherCourseId";
    }

    @PostMapping("/save/teacher")
    public String saveTeacher(Teacher teacher) {

        teacherService.save(teacher, teacher.getCourseId());

        return "redirect:/api/teachers/find/" + teacher.getCourseId();
    }

    @GetMapping("/update/{teacherId}")
    public String showUpdateTeacher(@PathVariable Long teacherId, Model model) {

        Teacher teacher = teacherService.findById(teacherId);

        model.addAttribute("entityTeacher", teacher);

        model.addAttribute("courseId", teacher.getCourse().getId());

        return "teacher/showUpdateTeacher";
    }

    @PostMapping("/update/{teacherId}")
    public String updateTeacher(@PathVariable Long teacherId, Teacher teacher) {

        teacherService.update(teacher, teacherId);

        Teacher teacher1 = teacherService.findById(teacherId);

        return "redirect:/api/teachers/find/" + teacher1.getCourse().getId();
    }

    @GetMapping("/delete/{teacherId}")
    public String deleteTeacher(@PathVariable Long teacherId) {

        Teacher teacher = teacherService.findById(teacherId);

        teacherService.removeById(teacherId);

        return "redirect:/api/teachers/find/" + teacher.getCourse().getId();
    }
}
