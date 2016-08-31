package biz.swagyolo.mail.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {

    public LoginResource() {
    }

    @GET
    public Response sayHello(@QueryParam("name") Optional<String> name) {
        return Response.accepted().build();
    }
}
