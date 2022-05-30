package peaksoft.repository.repositoryInterface;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;

import java.util.List;

@Repository
public interface CourseRepository {

    void save(Course course);

    void removeById(Long id);

    Course getById(Long id);

    List<Course> getAll(Long id);

    void update(Long id, Course course);
}
