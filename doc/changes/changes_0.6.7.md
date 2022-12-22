# Udf Debugging Java 0.6.7, released 2022-??-??

Code name: Dependency Upgrade

## Summary

Updated dependencies to use artifacts from Maven Central as repository maven.exasol.com has been discontinued.

Replaced transitive dependency com.fasterxml.jackson.core:jackson-core via parquet-io-java / hadoop with an newer version. Additionally excluded vulnerabilities to sonatype-2022-6438 and CVE-2021-37533. The latter only affects the FTP client which is not used by VSDF or parquet.

## Changes

* #46: Updated dependencies

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:2.4.1` to `2.6.0`
* Updated `org.slf4j:slf4j-api:2.0.4` to `2.0.6`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.3.1` to `6.4.1`
* Updated `org.mockito:mockito-junit-jupiter:4.9.0` to `4.10.0`
