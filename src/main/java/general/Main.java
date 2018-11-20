package general;

import conf.ServiceConfiguration;
import database.DB;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import test.TestRessource;


public class Main extends Application<ServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public String getName() {
        return "MusicDBService";
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
        System.out.println("Connecting to Database...");
        DB.getInstance().connectToDB("localhost",3306,"musicDB","root","");
        System.out.println("Connected.");
    }

    public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
        final TestRessource resource = new TestRessource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
    }
}
