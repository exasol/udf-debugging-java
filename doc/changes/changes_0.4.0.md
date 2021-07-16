# udf-debugging-java 0.4.0, released 2021-07-16

Code name: Added JProfiler Module

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

* Added `com.exasol:bucketfs-java:2.0.1`
* Updated `com.exasol:error-reporting-java:0.2.0` to `0.4.0`
* Added `com.exasol:exasol-test-setup-abstraction-java:0.1.1`
* Removed `com.exasol:exasol-testcontainers:3.3.1`
* Updated `com.exasol:test-db-builder-java:2.0.0` to `3.2.0`
* Added `org.apache.commons:commons-compress:1.21`
* Updated `org.jacoco:org.jacoco.core:0.8.6` to `0.8.7`
* Updated `org.slf4j:slf4j-api:1.7.30` to `1.7.31`

### Test Dependency Updates

* Added `com.exasol:exasol-testcontainers:3.5.3`
* Updated `org.jacoco:org.jacoco.agent:0.8.6` to `0.8.7`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.6.2` to `5.7.2`
* Updated `org.junit.jupiter:junit-jupiter-params:5.6.2` to `5.7.2`
* Removed `org.junit.platform:junit-platform-runner:1.6.2`
* Updated `org.mockito:mockito-core:3.6.0` to `3.11.2`
* Updated `org.testcontainers:junit-jupiter:1.14.3` to `1.15.3`

### Plugin Dependency Updates

* Added `com.exasol:error-code-crawler-maven-plugin:0.5.0`
* Updated `com.exasol:project-keeper-maven-plugin:0.3.0` to `0.10.0`
* Added `io.github.zlika:reproducible-build-maven-plugin:0.13`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.6` to `0.8.7`
