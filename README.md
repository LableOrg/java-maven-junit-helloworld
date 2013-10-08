java-maven-junit-helloworld
===========================

A „Hello World!” sample written in Java that showcases very simple unit and integration tests.

* To run the unit tests, call `mvn test`
* To run the integration tests as well, call `mvn verify`

This example follows the following basic conventions:

 | unit tests | integration tests
--- | --- | ---
__resides in:__ | `src/test/java/*Test.java` | `src/test/java/*IT.java`
__executes in Maven phase:__ | test | verify
__handled by Maven plugin:__ | [surefire](http://maven.apache.org/surefire/maven-surefire-plugin/) | [failsafe](http://maven.apache.org/surefire/maven-failsafe-plugin/)
