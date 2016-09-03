package biz.swagyolo.mail;

import biz.swagyolo.mail.resources.CreateEmailResource;
import biz.swagyolo.mail.resources.LoginResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

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
    }

    @Override
    public void run(final SwagyoloMailConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new LoginResource());
        environment.jersey().register(new CreateEmailResource());
    }

}
