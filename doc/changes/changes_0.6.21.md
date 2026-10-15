# Udf Debugging Java 0.6.21, released 2026-??-??

Code name:

## Summary

This release fixes the following vulnerabilities by pinning the version of transitive dependencies `org.ow2.asm:*:9.11`.

* In `org.ow2.asm:asm:jar:9.10.1`:
   * CVE-2026-110257: Uncontrolled Memory Allocation (6.8)
   * CVE-2026-110258: Uncontrolled Memory Allocation (6.8
   * CVE-2026-110259: Uncontrolled Recursion (5.5)
   * CVE-2026-110260: Algorithmic Complexity (5.5)
   * CVE-2026-110261: Algorithmic Complexity (6.8)
   * CVE-2026-110263: Uncontrolled Recursion (6.8)
* In `org.ow2.asm:asm-commons:jar:9.10.1`
   * CVE-2026-110262: Allocation of Resources Without Limits or Throttling (4.8)
   * CVE-2026-110270: Algorithmic Complexity (5.5)

## Features

* ISSUE_NUMBER: description

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:4.0.0` to `5.0.0`
* Updated `org.slf4j:slf4j-jdk14:2.0.18` to `2.0.19`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:7.3.0` to `8.0.2`
* Updated `com.exasol:test-db-builder-java:4.0.1` to `4.0.2`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:2.1.0` to `2.1.1`
* Updated `com.exasol:project-keeper-maven-plugin:5.7.3` to `5.7.6`
* Updated `io.github.git-commit-id:git-commit-id-maven-plugin:10.0.0` to `10.0.1`
* Updated `org.apache.maven.plugins:maven-toolchains-plugin:3.2.0` to `3.3.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.7.3` to `1.8.0`
