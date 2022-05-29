package peaksoft.repository.repositoryInterface;

import org.springframework.stereotype.Repository;
import peaksoft.model.Group;

import java.util.List;

@Repository
public interface GroupRepository {
    void save(Group group);

    void removeById(Long id);

    Group getById(Long id);

    List<Group> getAll();

    void update(Group group);
}
