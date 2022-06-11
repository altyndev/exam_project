package peaksoft.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.model.Course;
import peaksoft.model.Teacher;
import peaksoft.repository.repositoryInterface.CourseRepository;
import peaksoft.repository.repositoryInterface.TeacherRepository;
import peaksoft.service.TeacherService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final CourseRepository courseRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(Teacher teacher, Long courseId) {

        Course course = courseRepository.findById(courseId);

        if (course.getTeacher() != null) {

            update(teacher, course.getTeacher().getId());
        }

        teacher.setCourse(course);

        teacherRepository.save(teacher);
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void removeById(Long id) {

        teacherRepository.removeById(id);
    }

    @Override
    public List<Teacher> findAll(Long id) {
        return teacherRepository.findAll(id);
    }

    @Override
    public void update(Teacher teacher, Long teacherId) {

        Teacher teacher1 = teacherRepository.findById(teacherId);

        teacher1.setFirstName(teacher.getFirstName());

        teacher1.setLastName(teacher.getLastName());

        teacher1.setEmail(teacher.getEmail());

        teacherRepository.update(teacher1);
    }
}
