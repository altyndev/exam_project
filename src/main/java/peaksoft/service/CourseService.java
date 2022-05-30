package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import peaksoft.model.Course;

import java.util.List;

@Service
public interface CourseService {

    Course save(Course course);

    void removeById(Long id);

    Course getById(Long id);

    List<Course> getAll(Long id);

    void update(Long id, Course course);
}
