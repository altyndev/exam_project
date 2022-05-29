package peaksoft.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.model.Group;
import peaksoft.repository.repositoryInterface.CompanyRepository;
import peaksoft.repository.repositoryInterface.GroupRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class GroupImpl implements GroupRepository {

    private final EntityManager entityManager;

    @Autowired
    public GroupImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public void save(Group group) {
        entityManager.persist(group);
    }

    @Override
    public void removeById(Long id) {
        entityManager.remove(entityManager.find(Group.class, id));
    }

    @Override
    public Group getById(Long id) {
        return entityManager.find(Group.class, id);
    }

    @Override
    public List<Group> getAll() {
        return null;
    }

    @Override
    public void update(Group group) {

    }

//    private Course
}
