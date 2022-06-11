package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Course;
import peaksoft.service.CourseService;

import java.util.List;


@Controller
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // find all by company id http://localhost:8080/api/courses/findAll/{companyId} GET
    @GetMapping("/findAll/{companyId}")
    public String findAllByCompanyId(@PathVariable Long companyId, Model model) {

        List<Course> courseList = courseService.findAllByCompanyId(companyId);

        model.addAttribute("courseList", courseList);

        return "course/findAllCourse";
    }
    // save
    // 1. showSavePage url(http://localhost:8080/api/courses/save) GET
    @GetMapping("/save/{companyId}")
    public String showSavePage(@PathVariable Long companyId, Model model) {

        model.addAttribute("companyId", companyId);

        model.addAttribute("emtyCourse", new Course());

        return "course/saveCoursePage";
    }

    // 2. saveCourse url(http://loclahost:8080/api/courses/save/{companyId}) POST
    @PostMapping("/save/{companyId}")
    public String saveCourse(@PathVariable Long companyId, Course course) {

        courseService.save(companyId, course);

        return "redirect:/api/courses/findAll/{companyId}";
    }
    // update
    // 1. show update page url(http://localhost:8080/api/courses/update/{courseId}) GET
    @GetMapping("/update/{courseId}")
    public String showUpdatePage(Model model, @PathVariable Long courseId) {

        Course course = courseService.findById(courseId);

        model.addAttribute("companyId", course.getCompany().getId());

        model.addAttribute( "emtyCourse", course);

        return "course/showUpdatePage";
    }

    // 2. update course url(http://localhost:8080/api/courses/update/{courseId}) POST
    @PostMapping("/update/{courseId}")
    public String updateCourse(@PathVariable Long courseId, Course course) {

        courseService.update(courseId, course);

        Course course1 = courseService.findById(courseId);

        return "redirect:/api/courses/findAll/" + course1.getCompany().getId();
    }
    // delete
    // delete course url(http://localhost:8080/api/courses/delete/{courseId}) GET
    @GetMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable Long courseId) {

        Course course = courseService.findById(courseId);

        courseService.removeById(courseId);

        return "redirect:/api/courses/findAll/" + course.getCompany().getId();
    }
}
// find all by company id http://localhost:8080/api/courses/findAll/{companyId} GET
// save
// 1. showSavePage url(http://localhost:8080/api/courses/save) GET
// 2. saveCourse url(http://loclahost:8080/api/courses/save/{companyId}) POST
// update
// 1. show update page url(http://localhost:8080/api/courses/update/{courseId}) GET
// 2. update course url(http://localhost:8080/api/courses/update/{courseId}) POST
// delete
// delete course url(http://localhost:8080/api/courses/delete/{courseId}) GET
