package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.model.Course;

import java.util.List;

@Service
public interface CourseService {

    Course save(Long companyId, Course course);

    void removeById(Long id);

    Course findById(Long id);

    List<Course> findAllByCompanyId(Long id);

    void update(Long id, Course course);
}
