package peaksoft.repository.repositoryInterface;

import org.springframework.stereotype.Repository;
import peaksoft.model.Teacher;

import java.util.List;

@Repository
public interface TeacherRepository {

    void save(Teacher teacher);

    void removeById(Long id);

    Teacher getById(Long id);

    List<Teacher> getAll();

    void update(Teacher teacher);
}
