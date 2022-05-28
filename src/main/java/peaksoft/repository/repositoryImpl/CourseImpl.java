package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.repository.repositoryInterface.CourseRepository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CourseImpl implements CourseRepository {
    @Override
    public Course saveCourse(Course course) {
        return null;
    }

    @Override
    public void removeCourseById(Long id) {

    }

    @Override
    public Course getById(Long id) {
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        return null;
    }

    @Override
    public void update(Long id, Course course) {

    }
}
