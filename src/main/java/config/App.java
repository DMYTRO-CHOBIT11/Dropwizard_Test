package config;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import io.dropwizard.jdbi3.JdbiFactory;
import org.jdbi.v3.core.Jdbi;
import repo.StudentRepository;
import resource.StudentResource;

public class App extends Application<Config> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
    @Override
    public void run(Config config, Environment environment) {
        final JdbiFactory jdbiFactory = new JdbiFactory();

        final Jdbi jdbi = jdbiFactory.build(environment, config.getDatabase(), "mysql");
        final StudentRepository studentRepository = jdbi.onDemand(StudentRepository.class);
        environment.jersey().register(new StudentResource(studentRepository));
    }
}
