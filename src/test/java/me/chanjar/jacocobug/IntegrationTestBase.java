package me.chanjar.jacocobug;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;

@TestPropertySource(properties= "spring.jpa.show-sql=true")
public class IntegrationTestBase extends AbstractTestNGSpringContextTests {

  @Autowired
  private Flyway flyway;

  @AfterTest
  public void cleanDb() {
    flyway.clean();
  }
}
