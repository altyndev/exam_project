package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.service.CompanyService;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/api/companies")
@Controller
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @ModelAttribute("companies")
    public List<Company> findAllCourses() {
        return companyService.getAll();
    }

    @GetMapping
    public String findAllCourse() {
        return "/company/getAllCompany";
    }

    @GetMapping("/save")
    public String saveCoursePage(@ModelAttribute("company") Company company) {
        return "/company/saveCompanyPage";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.save(company);
        return "redirect:/api/companies";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Long id) {
        model.addAttribute( "company", companyService.getById(id));
        return "company/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("company") @Valid Company company, @PathVariable("id") Long id) {
        companyService.update(id, company);
        return "redirect:/api/companies";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        companyService.removeById(id);
        return "redirect:/api/companies";
    }
}
