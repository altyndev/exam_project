package peaksoft.repository;

import org.springframework.stereotype.Repository;
import peaksoft.model.Group;
import peaksoft.model.Student;
import peaksoft.repository.repositoryInterface.GroupRepository;
import peaksoft.repository.repositoryInterface.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupRepositoryImpl implements GroupRepository {

    private final EntityManager entityManager;

    public GroupRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public Group save(Group group) {
        entityManager.getTransaction().begin();
        entityManager.merge(group);
        entityManager.getTransaction().commit();
        return group;
    }

    @Override
    public void removeByGroup(Long id) {

        entityManager.getTransaction().begin();

        entityManager.createQuery("delete from Group where id =: id ")
                .setParameter("id",id).executeUpdate();

        entityManager.getTransaction().commit();
    }

    @Override
    public Group findById(Long id) {
        return entityManager.find(Group.class, id);
    }

    @Override
    public List<Group> findAllCourseById(Long courseId) {

        List<Group> groups = entityManager.createQuery(
                "select g from Group g where " +
                        "(select c from Course c where c.id=?1) member of g.courses",
                Group.class).setParameter(1, courseId).getResultList();

        return groups;
    }

    @Override
    public void update(Group group) {

        entityManager.getTransaction().begin();

        entityManager.merge(group);

        entityManager.getTransaction().commit();
    }
}
