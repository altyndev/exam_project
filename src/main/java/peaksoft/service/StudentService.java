package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.model.Course;
import peaksoft.model.Student;

import java.util.List;

@Service
public interface StudentService {

    Student save(Long groupId, Student student);

    void removeById(Long id);

    Student findById(Long id);

    List<Student> findAll(Long id);

    void update(Long id, Student student);
}
