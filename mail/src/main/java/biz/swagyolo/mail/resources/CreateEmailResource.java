package biz.swagyolo.mail.resources;

import biz.swagyolo.mail.json.CreateEmailRequest;
import biz.swagyolo.mail.views.FormView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/create")
@Produces(MediaType.APPLICATION_JSON)
public class CreateEmailResource {


    public CreateEmailResource() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public FormView showForm() {
        return new FormView();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmail(CreateEmailRequest createEmailRequest) {
        System.out.println(createEmailRequest.getSwagMail());
        System.out.println(createEmailRequest.getNormieMail());
        return Response.accepted(
                "Successfully set up address "
                + createEmailRequest.getSwagMail()
                + "@swagyolo.biz. (except not, this is dev)"
        ).build();
    }

}
