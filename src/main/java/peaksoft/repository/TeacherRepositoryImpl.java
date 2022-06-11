package peaksoft.repository;

import org.springframework.stereotype.Repository;
import peaksoft.model.Teacher;
import peaksoft.repository.repositoryInterface.TeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeacherRepositoryImpl implements TeacherRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public TeacherRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Teacher teacher) {

        entityManager.persist(teacher);
    }

    @Override
    public Teacher findById(Long id) {

        return entityManager.find(Teacher.class, id);
    }

    @Override
    public void removeById(Long id) {

        entityManager.remove(findById(id));
    }

    @Override
    public List<Teacher> findAll(Long id) {
        return entityManager.createQuery("select c from Company c join Course co on c.id = co.company.id join Teacher t on co.id = t.course.id where c.id = :id", Teacher.class)
                .setParameter("id", id)
                .getResultList();
    }

    /**
     * select *
     * from companies c
     *          join courses co
     *              on c.id = co.company_id
     *          join teachers t
     *              on co.id = t.course_id
     * where c.id = 2;
     *
     * "select c " +
     *                         "from Company c " +
     *                         "join Course co " +
     *                         "on c.id = co.company.id " +
     *                         "join Teacher t " +
     *                         "on co.id = t.course.id where c.id = :id", Teacher.class
     */

    @Override
    public void update(Teacher teacher) {

        entityManager.merge(teacher);
    }
}
