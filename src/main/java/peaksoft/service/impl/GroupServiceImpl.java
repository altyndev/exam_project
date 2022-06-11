package peaksoft.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.model.Course;
import peaksoft.model.Group;
import peaksoft.model.Student;
import peaksoft.repository.repositoryInterface.CourseRepository;
import peaksoft.repository.repositoryInterface.GroupRepository;
import peaksoft.repository.repositoryInterface.StudentRepository;
import peaksoft.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    public GroupServiceImpl(GroupRepository groupRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Group save(Group group, Long courseId) {

        Course course = courseRepository.findById(courseId);

        group.setCourse1(course);

        groupRepository.save(group);

        return group;
    }

    @Override
    public void removeById(Long id) {

        List<Student> students = studentRepository.findAll(id);

        for (Student student : students) {
            studentRepository.remove(student);
        }

        groupRepository.removeByGroup(id);
    }

    @Override
    public Group findById(Long id) {

        return groupRepository.findById(id);
    }

    @Override
    public List<Group> findAllCourseById(Long courseId) {

        return groupRepository.findAllCourseById(courseId);
    }

    @Override
    public void update(Group group, Long id) {

        Group group1 = groupRepository.findById(id);

        group1.setName(group.getName());

        group1.setDateOfStart(group.getDateOfStart());

        group1.setDateOfFinish(group.getDateOfFinish());

        groupRepository.update(group1);
    }
}
