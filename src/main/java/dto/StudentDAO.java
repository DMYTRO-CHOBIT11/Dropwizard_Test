package dto;

import mapper.StudentMapper;
import model.Student;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
@RegisterRowMapper(StudentMapper.class)
public interface StudentDAO {

    String INSERT = "insert into student(student_name, age) values(:student.name, :student.age)";

    String UPDATE = "update student set student_name=:student.name, age=:student.age where id=:id";

    String FIND_ALL ="select * from student where id=:id";

    String FIND_BY_ID = "select * from student where id=:id";

    @SqlQuery(FIND_ALL)
    List<Student>students();

    @SqlUpdate(INSERT)
    Integer insertStudent(@BindBean("student") Student student);

    @SqlQuery(FIND_BY_ID)
    Student findById(@Bind("id") int id);

    @SqlUpdate(UPDATE)
    Integer updateStudent(@BindBean("student")Student student, @Bind("id") int id);
}
