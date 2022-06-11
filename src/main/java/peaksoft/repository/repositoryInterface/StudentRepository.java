package peaksoft.repository.repositoryInterface;

import org.springframework.stereotype.Repository;
import peaksoft.model.Student;

import java.util.List;

@Repository
public interface StudentRepository {
    void save(Student student);

    Student findById(Long id);

    void remove(Student student);

    List<Student> findAll(Long id);

    void update(Student student);
}
