package hu.tigra.itday.workshop.greeting;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("greeting")
public class GreetingResource {
  private GreetingBean greetingBean;

  @Inject
  @PostConstruct
  public void init(final GreetingBean greetingBean) {
    this.greetingBean = greetingBean;
  }

  @GET
  @Path("{name}")
  public Response getGreeting(
      @PathParam("name") @Pattern(regexp = "\\p{IsAlphabetic}+") final String name) {
    return Response.ok(greetingBean.getGreeting(name)).build();
  }
}
