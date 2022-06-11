package peaksoft.repository.repositoryInterface;

import org.springframework.stereotype.Repository;
import peaksoft.model.Teacher;

import java.util.List;

@Repository
public interface TeacherRepository {

    void save(Teacher teacher);

    Teacher findById(Long id);

    void removeById(Long id);

    List<Teacher> findAll(Long id);

    void update(Teacher teacher);
}
