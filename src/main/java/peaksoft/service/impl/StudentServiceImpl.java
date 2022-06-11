package peaksoft.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.model.Group;
import peaksoft.model.Student;
import peaksoft.repository.repositoryInterface.GroupRepository;
import peaksoft.repository.repositoryInterface.StudentRepository;
import peaksoft.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;

    public StudentServiceImpl(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }


    @Override
    public Student save(Long groupId, Student student) {

        Group group = groupRepository.findById(groupId);

        student.setGroup(group);

        studentRepository.save(student);

        return student;
    }

    @Override
    public void removeById(Long id) {

        Student student = findById(id);

        studentRepository.remove(student);
    }

    @Override
    public Student findById(Long id) {

        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll(Long id) {

        return studentRepository.findAll(id);
    }

    @Override
    public void update(Long id, Student student) {

        Student student1 = findById(id);

        student1.setFirstName(student.getFirstName());

        student1.setLastName(student.getLastName());

        student1.setEmail(student.getEmail());

        student1.setStudyFormat(student.getStudyFormat());

        studentRepository.update(student1);
    }
}
