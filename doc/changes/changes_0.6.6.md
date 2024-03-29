# Udf Debugging Java 0.6.6, released 2022-12-22

Code name: Dependency Upgrade

## Summary

Updated dependencies after breaking changes in interface of bucketfs-java to re-enable compatibility with newer versions of bucketfs-java used by other libraries, e.g. exasol-testcontainers.

## Changes

* #46: Updated dependencies
* #42: Documented known issue of JaCoCo failing on Windows.

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:2.4.1` to `2.6.0`
* Updated `org.slf4j:slf4j-api:2.0.4` to `2.0.6`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.3.1` to `6.4.1`
* Updated `org.mockito:mockito-junit-jupiter:4.9.0` to `4.10.0`
