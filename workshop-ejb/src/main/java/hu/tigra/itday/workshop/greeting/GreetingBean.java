package hu.tigra.itday.workshop.greeting;

import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Stateless
public class GreetingBean {
  protected static final Logger LOGGER = LogManager.getLogger(GreetingBean.class);
  protected static final String TEMPLATE = "Hello, %s!";

  public String getGreeting(@NotNull @Pattern(regexp = "\\p{IsAlphabetic}+") final String name) {
    LOGGER.info("Greeting request from: {}", name);
    return String.format(TEMPLATE, name);
  }
}
