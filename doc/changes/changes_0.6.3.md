# udf-debugging-java 0.6.3, released 2022-??-??

Code name:

## Summary

In this release we removed the exasol-test-setup-abstraction from the compile dependencies. Now it's declared as `provided`. By that, it's no longer pulled as transitive dependency into other projects.

## Bug Fixes

* #38: Removed exasol-test-setup-abstraction as compile dependency

## Dependency Updates

### Compile Dependency Updates

* Removed `com.exasol:exasol-test-setup-abstraction-java:0.3.2`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.1.1` to `6.1.2`
* Updated `com.exasol:test-db-builder-java:3.3.2` to `3.3.3`
* Updated `org.mockito:mockito-junit-jupiter:4.5.1` to `4.6.1`
* Updated `org.testcontainers:junit-jupiter:1.17.1` to `1.17.2`
