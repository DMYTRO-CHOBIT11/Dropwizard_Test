package resource;

import model.Student;
import org.eclipse.jetty.http.HttpStatus;
import repo.StudentRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1")
public class StudentResource {

    private StudentRepository repository;

    public StudentResource(StudentRepository repository) {
        this.repository = repository;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("age") int age){
        return Response.ok(new Student("Dmytro",22)).build() ;
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getAllStudent(){
        return Response.ok(repository.findAll()).build();
    }
}
