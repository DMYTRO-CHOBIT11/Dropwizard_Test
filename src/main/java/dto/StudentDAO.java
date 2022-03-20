package dto;

import mapper.StudentMapper;
import model.Student;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface StudentDAO {
    @SqlQuery("select * from student")
    @RegisterRowMapper(StudentMapper.class)
    List<Student>students();
}
