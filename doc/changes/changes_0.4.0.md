# udf-debugging-java 0.4.0, released 2021-XX-XX

Code name:

## Features / Enhancements

* #15: Add API for host port proxy
* #26: Added support for exasol-test-setup-abstraction
* #20: Added module for JProfiler

## Refactoring:

* #11: Removed exasol-testconatiner compile dependency

## Bug Fixes:

* #18: Fixed Broken URL link in the pom.xml

## Dependency Updates

### Compile Dependency Updates

* Added `com.exasol:bucketfs-java:1.0.0`
* Updated `com.exasol:error-reporting-java:0.2.0` to `0.4.0`
* Added `com.exasol:exasol-test-setup-abstraction-java:0.1.0`
* Removed `com.exasol:exasol-testcontainers:3.3.1`
* Updated `com.exasol:test-db-builder-java:2.0.0` to `3.1.1`

### Test Dependency Updates

* Added `com.exasol:exasol-testcontainers:3.5.2`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.6.2` to `5.7.1`
* Updated `org.junit.jupiter:junit-jupiter-params:5.6.2` to `5.7.1`
* Removed `org.junit.platform:junit-platform-runner:1.6.2`
* Updated `org.mockito:mockito-core:3.6.0` to `3.8.0`
* Updated `org.testcontainers:junit-jupiter:1.14.3` to `1.15.2`

### Plugin Dependency Updates

* Added `com.exasol:error-code-crawler-maven-plugin:0.5.0`
* Updated `com.exasol:project-keeper-maven-plugin:0.3.0` to `0.9.0`
* Added `io.github.zlika:reproducible-build-maven-plugin:0.13`
