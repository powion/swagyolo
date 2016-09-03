package biz.swagyolo.mail.views;

import io.dropwizard.views.View;

public class LoginView extends View {

    private String name;

    public LoginView() {
        super("login.mustache");
        name = "login";
    }

    public String getName() {
        return name;
    }
}
