package peaksoft.repository;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.repository.repositoryInterface.CourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseImpl implements CourseRepository {

    private final EntityManager entityManager;

    public CourseImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public void removeById(Long id) {
        entityManager.remove(entityManager.find(Course.class, id));
    }

    @Override
    public Course getById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> getAll() {
        return entityManager.createQuery(
                "select c from Course c where c.company.id = c.id"
        ).getResultList();
    }

    @Override
    public void update(Course course) {
        entityManager.merge(course);
    }
}
