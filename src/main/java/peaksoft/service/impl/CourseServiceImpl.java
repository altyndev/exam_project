package peaksoft.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.model.Course;
import peaksoft.repository.repositoryInterface.CourseRepository;
import peaksoft.service.CourseService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course save(Course course) {
        courseRepository.save(course);
        return course;
    }

    @Override
    public void removeById(Long id) {
        courseRepository.removeById(id);
    }

    @Override
    public Course getById(Long id) {
        return courseRepository.getById(id);
    }

    @Override
    public List<Course> getAll(Long id) {
        return courseRepository.getAll(id);
    }

    @Override
    public void update(Long id, Course course) {
        courseRepository.update(id, course);
    }
}
