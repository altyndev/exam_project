package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Group;
import peaksoft.repository.repositoryInterface.GroupRepository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class GroupImpl implements GroupRepository {
    @Override
    public Group saveGroup(Group group) {
        return null;
    }

    @Override
    public void removeGroupById(Long id) {

    }

    @Override
    public Group getById(Long id) {
        return null;
    }

    @Override
    public List<Group> getAllGroup() {
        return null;
    }

    @Override
    public void updateGroup(Long id, Group group) {

    }
}
