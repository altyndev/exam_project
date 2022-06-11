package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.model.Student;
import peaksoft.repository.repositoryInterface.StudentRepository;
import peaksoft.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    private final StudentRepository studentRepository;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/findAll/{groupId}")
    public String findAll(@PathVariable Long groupId, Model model) {

        List<Student> studentList = studentService.findAll(groupId);

        model.addAttribute("studentList", studentList);

        return "student/findAllStudents";
    }

    @GetMapping("/save/{groupId}")
    public String showSavePage(@PathVariable Long groupId, Model model) {

        model.addAttribute("groupId", groupId);

        model.addAttribute("emtityStudent", new Student());

        return "student/saveStudentPage";
    }

    @PostMapping("/save/{groupId}")
    public String saveStudent(@PathVariable Long groupId, Student student) {

        studentService.save(groupId, student);

        return "redirect:/api/students/findAll/{groupId}";
    }

    @GetMapping("/update/{studentId}")
    public String showUpdatePage(@PathVariable Long studentId, Model model) {

        Student student = studentService.findById(studentId);

        model.addAttribute("entityStudent", student);

        model.addAttribute("groupId", student.getGroup().getId());

        return "student/showUpdatePage";
    }

    @PostMapping("/update/{studentId}")
    public String updateStudent(@PathVariable Long studentId, Student student) {

        studentService.update(studentId, student);

        Student student1 = studentService.findById(studentId);

        return "redirect:/api/students/findAll/" + student1.getGroup().getId();
    }

    @GetMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {

        Student student = studentService.findById(studentId);

        studentService.removeById(studentId);

        return "redirect:/api/students/findAll/" + student.getGroup().getId();
    }
}
