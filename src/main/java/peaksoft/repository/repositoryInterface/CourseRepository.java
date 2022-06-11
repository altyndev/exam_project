package peaksoft.repository.repositoryInterface;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.model.Group;

import java.util.List;

@Repository
public interface CourseRepository {

    void save(Course course);

    void removeByCourse(Course course);

    Course findById(Long id);

    List<Course> findAllByCompanyId(Long id);

    void update(Course course);
}
