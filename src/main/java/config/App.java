package config;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resource.StudentResource;

public class App extends Application<Config> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
    @Override
    public void run(Config config, Environment environment) {
        environment.jersey().register(new StudentResource());
    }
}
