package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Course;
import peaksoft.model.Group;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    private final CourseService courseService;

    private final CompanyService companyService;

    @Autowired
    public GroupController(GroupService groupService, CourseService courseService, CompanyService companyService) {
        this.groupService = groupService;
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @GetMapping("/findAll/{courseId}")
    public String findAllGroupsCourseId(@PathVariable Long courseId, Model model) {

        List<Group> allGroups = groupService.findAllCourseById(courseId);

        Course course = courseService.findById(courseId);

        model.addAttribute("companyId", course.getCompany().getId());

        model.addAttribute("courseId", courseId);

        model.addAttribute("allGroups", allGroups);

        return "group/findAllGroup";
    }

    @GetMapping("/save/{courseId}")
    public String showSaveGroup(@PathVariable Long courseId, Model model) {

        model.addAttribute("courseId", courseId);

        model.addAttribute("emtyGroup", new Group());

        return "group/saveGroupPage";
    }

    @PostMapping("/save/{courseId}")
    public String saveGroup(@PathVariable Long courseId, Group group) {

        groupService.save(group, courseId);

        return "redirect:/api/groups/findAll/{courseId}";
    }

    @GetMapping("/update/{groupId}")
    public String showUpdatePage(@PathVariable Long groupId, Model model) {

        Group group = groupService.findById(groupId);

        model.addAttribute("emtyGroup", group);

        return "group/showUpdatePage";
    }

    @PostMapping("/update/{groupId}")
    public String updateGroup(@PathVariable Long groupId, Group group) {

        groupService.update(group, groupId);

        return "redirect:/api/companies";
    }

    @GetMapping("/delete/{groupId}")
    public String deleteGroup(@PathVariable Long groupId) {

        groupService.removeById(groupId);

        return "redirect:/api/companies";
    }

//    @GetMapping("/saveGroup/{courseId}")
//    public String showGroupCourse(@PathVariable Long courseId, Model model) {
//
//        Course course = courseService.findById(courseId);
//
//        List<Course> courseList = courseService.findAllByCompanyId(course.getCompany().getId());
//
//        model.addAttribute("courseId", courseId);
//
//        model.addAttribute("courseList", courseList);
//
//        model.addAttribute("entityGroup", new Group());
//
//        return "group/saveGroupCourseId";
//    }
//
//    @PostMapping("/saveGroup/{courseId}")
//    public String saveGroup(@PathVariable Long courseId, @ModelAttribute("entityGroup") Group group,
//                            List<Course> courseList){
//        List<Course> courses = new ArrayList<>();
//
//        Course course1 = courseService.findById(courseId);
//
//        Long id1 = course1.getCompany().getId();
//
//        group.setCompany(companyService.findById(id1));
//
//        try{
//            for (Course course : courseList) {
//                courses.add(courseService.findById(course.getId()));
//            }
//        }
//        catch(NullPointerException e){
//            System.out.println("It is null!");
//        }
//
//        groupService.saveCourse(courses, group);
//
//        return "redirect:/api/companies";
//    }
}