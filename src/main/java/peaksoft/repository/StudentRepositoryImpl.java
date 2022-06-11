package peaksoft.repository;

import org.springframework.stereotype.Repository;
import peaksoft.model.Student;
import peaksoft.repository.repositoryInterface.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {

    private final EntityManager entityManager;

    public StudentRepositoryImpl(EntityManagerFactory entityManager) {
        this.entityManager = entityManager.createEntityManager();
    }

    @Override
    public void save(Student student) {

        entityManager.getTransaction().begin();

        entityManager.merge(student);

        entityManager.getTransaction().commit();
    }

    @Override
    public Student findById(Long id) {

        return entityManager.find(Student.class, id);
    }

    @Override
    public void remove(Student student) {

        entityManager.getTransaction().begin();

        entityManager.createQuery("delete from Student where id =: id ")
                .setParameter("id", student.getId()).executeUpdate();

        entityManager.getTransaction().commit();
    }

    @Override
    public List<Student> findAll(Long id) {

        return entityManager.createQuery(
                "select s from Student s where s.group.id = :id", Student.class)
                .setParameter("id", id).getResultList();
    }

    @Override
    public void update(Student student) {

        entityManager.getTransaction().begin();

        entityManager.merge(student);

        entityManager.getTransaction().commit();
    }
}
