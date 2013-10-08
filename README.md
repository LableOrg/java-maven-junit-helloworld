java-maven-junit-helloworld
===========================

A „Hello World!” sample written in Java using Maven for the build, that showcases a few very simple tests.

This example demonstrates:

* Unit tests written with [JUnit 4](http://junit.org/)
* Unit test using [PowerMockito](https://code.google.com/p/powermock/) to mock classes and test `System.exit()`
* Integration tests written with [JUnit 4](http://junit.org/)
* Integration test using [system-rules](http://www.stefan-birkner.de/system-rules/) to test `System.out`
* Code coverage reports via [Cobertura](http://cobertura.github.io/cobertura/)
* A Maven build that puts it all together

Running the tests
-----------------

* To run the unit tests, call `mvn test`
* To run the integration tests as well, call `mvn verify`
* To generate (unit test) code coverage reports, call `mvn cobertura:cobertura`, and point a browser at the output in `target/site/cobertura/`

Conventions
-----------

This example follows the following basic conventions:

 | unit test | integration test
--- | --- | ---
__resides in:__ | `src/test/java/*Test.java` | `src/test/java/*IT.java`
__executes in Maven phase:__ | test | verify
__handled by Maven plugin:__ | [surefire](http://maven.apache.org/surefire/maven-surefire-plugin/) | [failsafe](http://maven.apache.org/surefire/maven-failsafe-plugin/)
