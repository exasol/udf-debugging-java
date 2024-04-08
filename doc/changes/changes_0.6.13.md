# Udf Debugging Java 0.6.13, released 2024-04-08

Code name: Fixes CVE-2024-29025 in io.netty:netty-codec-http:jar:4.1.100.Final:provided

## Summary

This release fixes vulnerability CVE-2024-29025 in `io.netty:netty-codec-http:jar:4.1.100.Final:provided`.

**Excluded vulnerability** This release contains vulnerability CVE-2017-10355 in `fr.turri:aXMLRPC` for connecting to ExaOperation during tests. We accept this vulnerability (CWE-833: Deadlock) as we assume that we only connect to the known endpoint ExaOperations.

## Security

* #65: Fixed CVE-2024-29025 in `io.netty:netty-codec-http:jar:4.1.100.Final:provided`

## Dependency Updates

### Compile Dependency Updates

* Updated `org.apache.commons:commons-compress:1.26.0` to `1.26.1`
* Updated `org.jacoco:org.jacoco.core:0.8.11` to `0.8.12`

### Runtime Dependency Updates

* Updated `org.eclipse.parsson:parsson:1.1.5` to `1.1.6`

### Test Dependency Updates

* Updated `com.exasol:test-db-builder-java:3.5.3` to `3.5.4`
* Updated `org.jacoco:org.jacoco.agent:0.8.11` to `0.8.12`
* Updated `org.mockito:mockito-junit-jupiter:5.10.0` to `5.11.0`
* Updated `org.testcontainers:junit-jupiter:1.19.6` to `1.19.7`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:2.0.0` to `2.0.2`
* Updated `com.exasol:project-keeper-maven-plugin:4.1.0` to `4.3.0`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.12.1` to `3.13.0`
* Updated `org.apache.maven.plugins:maven-gpg-plugin:3.1.0` to `3.2.2`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.11` to `0.8.12`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:3.10.0.2594` to `3.11.0.3922`
