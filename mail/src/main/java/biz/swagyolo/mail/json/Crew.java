package biz.swagyolo.mail.json;

import java.time.Instant;

public class Crew {

    private String id;
    private String swagMail;
    private String normieMail;
    private String routeID;
    private Instant timestamp;


    public String getId() {
        return id;
    }

    public String getSwagMail() {
        return swagMail;
    }

    public String getNormieMail() {
        return normieMail;
    }

    public String getRouteID() {
        return routeID;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
