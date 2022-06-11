package peaksoft.repository.repositoryInterface;

import org.springframework.stereotype.Repository;
import peaksoft.model.Group;

import java.util.List;

@Repository
public interface GroupRepository {
    Group save(Group group);

    void removeByGroup(Long id);

    Group findById(Long id);

    List<Group> findAllCourseById(Long courseId);

    void update(Group group);
}
