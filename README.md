java-maven-junit-helloworld
===========================

A „Hello World!” sample written in Java using Maven for the build, that showcases a few very simple tests.

This example demonstrates:

* Unit tests written with [JUnit 4](http://junit.org/)
* Integration tests written with [JUnit 4](http://junit.org/)
* Using [system-rules](http://www.stefan-birkner.de/system-rules/) to test `System.out` and `System.exit()`
* Code coverage reports via [Cobertura](http://cobertura.github.io/cobertura/)
* A Maven build that puts it all together

Running the tests
-----------------

* To run the unit tests, call `mvn test`
* To run the integration tests as well, call `mvn verify`

Conventions
-----------

This example follows the following basic conventions:

 | unit test | integration test
--- | --- | ---
__resides in:__ | `src/test/java/*Test.java` | `src/test/java/*IT.java`
__executes in Maven phase:__ | test | verify
__handled by Maven plugin:__ | [surefire](http://maven.apache.org/surefire/maven-surefire-plugin/) | [failsafe](http://maven.apache.org/surefire/maven-failsafe-plugin/)
