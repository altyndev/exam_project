package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Student;
import peaksoft.repository.repositoryInterface.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class StudentImpl implements StudentRepository {
    @Override
    public Student saveStudent(Student student) {
        return null;
    }

    @Override
    public void removeStudentById(Long id) {

    }

    @Override
    public Student getById(Long id) {
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        return null;
    }

    @Override
    public void updateStudent(Long id, Student student) {

    }
}
