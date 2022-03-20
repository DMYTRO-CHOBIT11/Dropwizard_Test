package mapper;

import model.Student;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student map(ResultSet rs, StatementContext ctx) throws SQLException {
        Student student = new Student();
        student.setName(rs.getString("student_name"));
        student.setAge(rs.getInt("age"));
        return student;
    }
}
