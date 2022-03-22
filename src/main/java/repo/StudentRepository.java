package repo;

import dto.StudentDAO;
import model.Student;
import org.jdbi.v3.sqlobject.CreateSqlObject;

import java.util.List;

public interface StudentRepository {

    @CreateSqlObject
    StudentDAO studentDAO();


    default List<Student>findAll(){
        return studentDAO().students();
    }

    default Integer createStudent(Student student){
        return studentDAO().insertStudent(student);
    }

    default Integer updateStudent(Student student, int id){
        return studentDAO().updateStudent(student, id);
    }

    default Student findById(int id){
        return  studentDAO().findById(id);
    }
}
