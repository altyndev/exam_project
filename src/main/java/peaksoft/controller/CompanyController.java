package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.service.CompanyService;

import java.util.List;


@RequestMapping("/api/companies")
@Controller
public class CompanyController {

    private final CompanyService companyRepository;

    @Autowired
    public CompanyController(CompanyService companyRepository) {
        this.companyRepository = companyRepository;
    }
    @ModelAttribute("companies")
    public List<Company> findAllCourses() {
        return companyRepository.getAll();
    }
    @GetMapping
    public String findAllCourse(){
        return "/company/getAllCompany";
    }

    @GetMapping("/save")
    public String saveCoursePage(@ModelAttribute("company") Company company) {
        return "/company/saveCompanyPage";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyRepository.save(company);
        return "redirect:/api/companies";
    }

    @GetMapping("{id}/update")
    public String ubdate(@PathVariable("id") Long id,Model model) {
        model.addAttribute("getCompany",companyRepository.getById(id));
        return "/company/ubdate";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("getCompany") Company company,@PathVariable("id") Long id){
        companyRepository.update(id,company);
        return "redirect:/api/companies";
    }
}
