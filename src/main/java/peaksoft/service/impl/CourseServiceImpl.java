package peaksoft.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.repository.repositoryInterface.CourseRepository;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CompanyService companyService;

    public CourseServiceImpl(CourseRepository courseRepository, CompanyService companyService) {
        this.courseRepository = courseRepository;
        this.companyService = companyService;
    }

    @Override
    public Course save(Long companyId, Course course) {

        Company company = companyService.findById(companyId);

        course.setCompany(company);

        courseRepository.save(course);

        return course;
    }

    @Override
    public void removeById(Long id) {

        Course course = findById(id);

        courseRepository.removeByCourse(course);
    }

    @Override
    public Course findById(Long id) {

        return courseRepository.findById(id);
    }

    @Override
    public List<Course> findAllByCompanyId(Long id) {

        return courseRepository.findAllByCompanyId(id);
    }

    @Override
    public void update(Long id, Course course) {
        Course course1 = findById(id);

        course1.setName(course.getName());

        course1.setDuration(course.getDuration());

        courseRepository.update(course1);
    }
}
