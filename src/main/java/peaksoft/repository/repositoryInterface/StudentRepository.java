package peaksoft.repository.repositoryInterface;

import org.springframework.stereotype.Repository;
import peaksoft.model.Student;

import java.util.List;

@Repository
public interface StudentRepository {
    void save(Student student);

    void removeById(Long id);

    Student getById(Long id);

    List<Student> getAll();

    void update(Student student);
}
