package biz.swagyolo.mail.resources;

import biz.swagyolo.mail.db.CrewDAO;
import biz.swagyolo.mail.views.LoginView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginResource {

    private CrewDAO crewDAO;

    public LoginResource(CrewDAO crewDAO) {
        this.crewDAO = crewDAO;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public LoginView loginView() {
        return new LoginView();
    }

}
