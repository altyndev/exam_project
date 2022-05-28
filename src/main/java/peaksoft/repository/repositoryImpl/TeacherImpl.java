package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Teacher;
import peaksoft.repository.repositoryInterface.TeacherRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeacherImpl implements TeacherRepository {
    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return null;
    }


    @Override
    public void removeTeacherById(Long id) {

    }

    @Override
    public Teacher getById(Long id) {
        return null;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return null;
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher) {

    }
}
