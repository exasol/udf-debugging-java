# Udf Debugging Java 0.6.9, released 2023-07-03

Code name: Upgrade dependencies on top of 0.6.8

## Summary

This release fixes the following vulnerability in `provided` dependency `io.netty:netty-handler`:
* CVE-2023-34462, severity CWE-770: Allocation of Resources Without Limits or Throttling (6.5)

## Security

* #57: Upgraded dependencies

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:3.0.0` to `3.1.0`
* Updated `com.exasol:error-reporting-java:1.0.0` to `1.0.1`
* Updated `jakarta.json:jakarta.json-api:2.1.1` to `2.1.2`
* Updated `org.apache.commons:commons-compress:1.22` to `1.23.0`
* Updated `org.jacoco:org.jacoco.core:0.8.8` to `0.8.10`
* Removed `org.slf4j:slf4j-api:2.0.6`
* Added `org.slf4j:slf4j-jdk14:2.0.7`

### Runtime Dependency Updates

* Added `org.eclipse.parsson:parsson:1.1.2`
* Removed `org.glassfish:jakarta.json:2.0.1`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.5.1` to `6.6.0`
* Updated `org.jacoco:org.jacoco.agent:0.8.8` to `0.8.10`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.9.2` to `5.9.3`
* Updated `org.junit.jupiter:junit-jupiter-params:5.9.2` to `5.9.3`
* Updated `org.mockito:mockito-junit-jupiter:5.1.1` to `5.4.0`
* Updated `org.testcontainers:junit-jupiter:1.17.6` to `1.18.3`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.2.2` to `1.2.3`
* Updated `com.exasol:project-keeper-maven-plugin:2.9.3` to `2.9.7`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.10.1` to `3.11.0`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.0.0` to `3.1.1`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.1.0` to `3.3.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M8` to `3.0.0`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.4.1` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M8` to `3.0.0`
* Added `org.basepom.maven:duplicate-finder-maven-plugin:1.5.1`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.3.0` to `1.4.1`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.14.2` to `2.15.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.8` to `0.8.9`
