package resource;

import model.Student;
import org.eclipse.jetty.http.HttpStatus;
import repo.StudentRepository;

import javax.ws.rs.*;
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
    public Response getStudent(){
        return Response.ok(new Student("Dmytro",22)).build() ;
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getAllStudent(){
        return Response.ok(repository.findAll()).build();
    }

    @POST
    @Path("/createStudent")
    public Response addStudent(Student student){
        return Response.status(Response.Status.CREATED).entity(repository.createStudent(student)).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getAllStudent(@PathParam("id")int id){
        return Response.ok(repository.findById(id)).build();
    }

    @PUT
    @Path("/updateStudent/{id}")
    public Response updateStudent(Student student,@PathParam("id") int id){
        return Response.status(Response.Status.CREATED).entity(repository.updateStudent(student,id)).build();
    }
}
