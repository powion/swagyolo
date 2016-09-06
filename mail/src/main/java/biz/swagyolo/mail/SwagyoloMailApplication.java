package biz.swagyolo.mail;

import biz.swagyolo.mail.db.CrewDAO;
import biz.swagyolo.mail.resources.CreateEmailResource;
import biz.swagyolo.mail.resources.LoginResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.skife.jdbi.v2.DBI;

public class SwagyoloMailApplication extends Application<SwagyoloMailConfiguration> {

    public static void main(final String[] args) throws Exception {
        new SwagyoloMailApplication().run(args);
    }

    @Override
    public String getName() {
        return "SwagyoloMail";
    }

    @Override
    public void initialize(final Bootstrap<SwagyoloMailConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor()
                )
        );
        bootstrap.addBundle(new MigrationsBundle<SwagyoloMailConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(SwagyoloMailConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(final SwagyoloMailConfiguration configuration,
                    final Environment environment) {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final CrewDAO crewDAO = jdbi.onDemand(CrewDAO.class);

        environment.jersey().register(new LoginResource(crewDAO));
        environment.jersey().register(new CreateEmailResource());
    }

}
