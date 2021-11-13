package hu.tigra.itday.workshop.greeting

import javax.validation.Validation
import javax.validation.executable.ExecutableValidator
import org.hibernate.validator.internal.engine.ConstraintViolationImpl
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator
import spock.lang.Shared
import spock.lang.Specification

class GreetingBeanSpec extends Specification {
  @Shared ExecutableValidator validator = Validation.byDefaultProvider().configure()
      .messageInterpolator(new ParameterMessageInterpolator()).buildValidatorFactory().getValidator().forExecutables()
  @Shared GreetingBean greetingBean = new GreetingBean()

  def 'valid name greeted'() {
    when:
    final def violations = validator.
        validateParameters(greetingBean, GreetingBean.class.getMethod('getGreeting', String.class), [name] as Object[]).
        collect {(it as ConstraintViolationImpl).message }
    then:
    violations == []
    expect:
    greetingBean.getGreeting(name) == greeting
    where:
    name     || greeting
    'Alice'  || 'Hello, Alice!'
    'Bob'    || 'Hello, Bob!'
  }

  def 'invalid name fails validation'() {
    expect:
    validator.
        validateParameters(greetingBean, GreetingBean.class.getMethod('getGreeting', String.class), [name] as Object[]).
        collect {(it as ConstraintViolationImpl).message } == violations
    where:
    name       || violations
    null       || ['must not be null']
    'Mr. Bond' || ['must match "\\p{IsAlphabetic}+"']
  }
}
