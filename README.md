# A Java/Maven/JUnit HelloWorld example

**This branch targeting Java 11 is work-in-progressm,mkk

A „Hello World!” sample written in Java using Maven for the build, that showcases a few very simple tests.

This example demonstrates:

mmm
* A simple Java 8 application wixxth testserre
* Unit tests written with [JUnit 5](https://junit.org/junit5/)
* Integration tests written with [JUnit 5](https://junit.org/junit5/)
* Code coverage reports via [JaCoCo](https://www.jacoco.org/jacoco/)
* A Maven build that puts it all together

## Running the tests;lk;l

* To run the unit tests, call `mvn test`
* To run the integration tests as well, call `mvn verify`
* Code coverage reports are generated when `mvn verify` (or a full `mvn clean install`) is called.
  Point a browser at the output in `target/site/jacoco-both/index.html` to see the report.

## Conventions

This example follows the following basic conventions:

| | unit test | integration test |
| --- | --- | --- |
| **resides in:** | `src/test/java/*Test.java` | `src/test/java/*IT.java` |
| **executes in Maven phase:** | test | verify |
| **handled by Maven plugin:** | [surefire](http://maven.apache.org/surefire/maven-surefire-plugin/) | [failsafe](http://maven.apache.org/surefire/maven-failsafe-plugin/) |
