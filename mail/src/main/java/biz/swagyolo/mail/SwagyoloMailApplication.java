package biz.swagyolo.mail;

import biz.swagyolo.mail.resources.LoginResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        // TODO: application initialization
    }

    @Override
    public void run(final SwagyoloMailConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new LoginResource());
    }

}
