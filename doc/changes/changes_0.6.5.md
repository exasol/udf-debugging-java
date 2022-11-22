# udf-debugging-java 0.6.5, released 2022-11-22

Code name: Updated dependencies on top of 0.6.4

## Summary

In this release we fixed a version collision between the BucketFS library used in this project and `exasol-test-setup-abstraction-java` that lead to a class-not-found error in certain combinations.

## Known Issues

This project depends on an Amazon AWS SDK which in turn depends on the Netty HTTP server version 4.1.77. This versions has a vulnerability in certificate validation that can lead to man-in-the-middle attacks. Unfortunately, no update of the AWS SDK is available at the time of this release.

## Bugfixes

* #43: Fixed BucketFS library version collisions.
* #42: Documented known issue of jacoco failing on windows.

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:2.3.0` to `2.4.1`
* Updated `com.exasol:error-reporting-java:0.4.1` to `1.0.0`
* Updated `jakarta.json:jakarta.json-api:2.1.0` to `2.1.1`
* Updated `org.apache.commons:commons-compress:1.21` to `1.22`
* Updated `org.slf4j:slf4j-api:1.7.36` to `2.0.4`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.1.2` to `6.3.1`
* Updated `com.exasol:test-db-builder-java:3.3.3` to `3.4.1`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.8.2` to `5.9.1`
* Updated `org.junit.jupiter:junit-jupiter-params:5.8.2` to `5.9.1`
* Updated `org.mockito:mockito-junit-jupiter:4.6.1` to `4.9.0`
* Updated `org.testcontainers:junit-jupiter:1.17.2` to `1.17.6`
