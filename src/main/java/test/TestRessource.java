package test;

import com.codahale.metrics.annotation.Timed;
import java.util.Optional;
import types.StringJSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/Test")
@Produces(MediaType.APPLICATION_JSON)
public class TestRessource {

    private final String template;
    private final String defaultName;
    private final long counter;

    public TestRessource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = 0;
    }

    @GET
    @Timed
    public StringJSON sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new StringJSON(1, value);
    }
}
