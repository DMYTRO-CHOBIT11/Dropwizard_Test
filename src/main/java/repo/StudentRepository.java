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
}
