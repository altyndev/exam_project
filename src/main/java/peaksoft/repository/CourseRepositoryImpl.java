package peaksoft.repository;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.repository.repositoryInterface.CourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Course course) {
        entityManager.merge(course);
    }

    @Override
    public void removeById(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public Course getById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> getAll(Long id) {
        return entityManager.createQuery(
                "select c from Course c where c.company.id =:id",Course.class)
                .setParameter("id",id).getResultList();
    }

    @Override
    public void update(Long id, Course course) {
        Course course1 = getById(id);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        entityManager.merge(course);
    }
}
