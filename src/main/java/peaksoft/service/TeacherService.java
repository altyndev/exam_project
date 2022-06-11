package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.model.Teacher;

import java.util.List;

@Service
public interface TeacherService {

    void save(Teacher teacher, Long courseId);

    Teacher findById(Long id);

    void removeById(Long id);

    List<Teacher> findAll(Long id);

    void update(Teacher teacher, Long teacherId);
}
