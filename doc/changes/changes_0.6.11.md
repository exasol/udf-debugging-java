# Udf Debugging Java 0.6.11, released 2023-??-??

Code name: Fix CVE-2023-42503

## Summary

This release fixes CVE-2023-42503 in `org.apache.commons:commons-compress` by upgrading dependencies.

## Security

* #61: Fixed CVE-2023-42503 in `org.apache.commons:commons-compress`

## Dependency Updates

### Compile Dependency Updates

* Updated `org.apache.commons:commons-compress:1.23.0` to `1.24.0`
* Updated `org.slf4j:slf4j-jdk14:2.0.7` to `2.0.9`

### Runtime Dependency Updates

* Updated `org.eclipse.parsson:parsson:1.1.2` to `1.1.4`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.6.0` to `6.6.2`
* Updated `com.exasol:test-db-builder-java:3.4.2` to `3.5.0`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.9.3` to `5.10.0`
* Updated `org.junit.jupiter:junit-jupiter-params:5.9.3` to `5.10.0`
* Updated `org.mockito:mockito-junit-jupiter:5.4.0` to `5.5.0`
* Updated `org.testcontainers:junit-jupiter:1.18.3` to `1.19.0`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.2.3` to `1.3.0`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.7` to `2.9.12`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.3.0` to `3.4.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0` to `3.1.2`
* Updated `org.apache.maven.plugins:maven-gpg-plugin:3.0.1` to `3.1.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0` to `3.1.2`
* Updated `org.basepom.maven:duplicate-finder-maven-plugin:1.5.1` to `2.0.1`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.4.1` to `1.5.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.15.0` to `2.16.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.9` to `0.8.10`
