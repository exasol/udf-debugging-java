# Udf Debugging Java 0.6.14, released 2024-11-19

Code name: Fix CVE-2024-47535: io.netty:netty-common:jar:4.1.108.Final:provided

## Summary

This release fixes CVE-2024-47535 in transitive production dependency `io.netty:netty-common:jar:4.1.108.Final:provided` added by `com.exasol:exasol-test-setup-abstraction-java`.

## Security

* #67: Fixed CVE-2024-47535 in `io.netty:netty-common:jar:4.1.108.Final:provided`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:bucketfs-java:3.1.2` to `3.2.0`
* Updated `org.apache.commons:commons-compress:1.26.1` to `1.27.1`
* Updated `org.slf4j:slf4j-jdk14:2.0.12` to `2.0.16`

### Runtime Dependency Updates

* Updated `org.eclipse.parsson:parsson:1.1.6` to `1.1.7`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:7.0.1` to `7.1.1`
* Updated `com.exasol:test-db-builder-java:3.5.4` to `3.6.0`
* Updated `org.itsallcode:junit5-system-extensions:1.2.0` to `1.2.2`
* Updated `org.junit.jupiter:junit-jupiter-engine:5.10.2` to `5.11.3`
* Updated `org.junit.jupiter:junit-jupiter-params:5.10.2` to `5.11.3`
* Updated `org.mockito:mockito-junit-jupiter:5.11.0` to `5.14.2`
* Updated `org.testcontainers:junit-jupiter:1.19.7` to `1.20.3`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:2.0.2` to `2.0.3`
* Updated `com.exasol:project-keeper-maven-plugin:4.3.0` to `4.4.0`
* Added `com.exasol:quality-summarizer-maven-plugin:0.2.0`
* Updated `io.github.zlika:reproducible-build-maven-plugin:0.16` to `0.17`
* Updated `org.apache.maven.plugins:maven-clean-plugin:2.5` to `3.4.0`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:3.1.1` to `3.1.2`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.4.1` to `3.5.0`
* Updated `org.apache.maven.plugins:maven-failsafe-plugin:3.2.5` to `3.5.1`
* Updated `org.apache.maven.plugins:maven-gpg-plugin:3.2.2` to `3.2.7`
* Updated `org.apache.maven.plugins:maven-install-plugin:2.4` to `3.1.3`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.6.3` to `3.10.1`
* Updated `org.apache.maven.plugins:maven-resources-plugin:2.6` to `3.3.1`
* Updated `org.apache.maven.plugins:maven-site-plugin:3.3` to `3.9.1`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.2.5` to `3.5.1`
* Updated `org.apache.maven.plugins:maven-toolchains-plugin:3.1.0` to `3.2.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.16.2` to `2.17.1`
* Updated `org.sonarsource.scanner.maven:sonar-maven-plugin:3.11.0.3922` to `4.0.0.4121`
* Updated `org.sonatype.plugins:nexus-staging-maven-plugin:1.6.13` to `1.7.0`
