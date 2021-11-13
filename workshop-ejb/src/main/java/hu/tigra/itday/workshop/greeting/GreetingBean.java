package hu.tigra.itday.workshop.greeting;

import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Stateless
public class GreetingBean {
  protected static final String TEMPLATE = "Hello, %s!";

  public String getGreeting(@NotNull @Pattern(regexp = "\\p{IsAlphabetic}+") final String name) {
    return String.format(TEMPLATE, name);
  }
}
