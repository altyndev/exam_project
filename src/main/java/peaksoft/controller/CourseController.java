package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
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

    @GetMapping("/getCourse/{id}")
    public String showCourse(@PathVariable("id") Long id, Model model ){
        model.addAttribute("showCourse",courseService.getById(id));
        return "course/show_course";
    }

    @GetMapping("/{id}")
    public String getAll(@PathVariable("id") Long id, Model model){
        model.addAttribute("comcourse",courseService.getAll(id));
        model.addAttribute("companyId",id);
        return "course/allCourses";
    }

    @GetMapping("/save")
    public String saveCoursePage(@ModelAttribute("course") Course course) {
        return "/course/saveCoursePage";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:/api/courses";
    }
}
