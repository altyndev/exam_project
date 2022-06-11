package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.model.Course;
import peaksoft.model.Group;

import java.util.List;

@Service
public interface GroupService {
    Group save(Group group, Long courseId);

    void removeById(Long id);

    Group findById(Long id);

    List<Group> findAllCourseById(Long courseId);

    void update(Group group, Long id);

//    void saveCourse(List<Course> courses, Group group);
}
