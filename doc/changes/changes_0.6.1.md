# udf-debugging-java 0.6.1, released 2022-??-??

Code name: 0.6.1: Upgrade dependencies

This release upgrades dependencies and reduces the number of runtime dependencies, fixing [CVE-2022-21724](https://ossindex.sonatype.org/vulnerability/0f319d1b-e964-4471-bded-db3aeb3c3a29?component-type=maven&component-name=org.postgresql.postgresql&utm_source=ossindex-client&utm_medium=integration&utm_content=1.1.1) in the PostgreSQL JDBC driver.

## Features

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:test-db-builder-java:3.2.2` to `3.3.2`
* Updated `jakarta.json:jakarta.json-api:2.0.1` to `2.1.0`
* Updated `org.jacoco:org.jacoco.core:0.8.7` to `0.8.8`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:6.0.0` to `6.1.1`
* Updated `org.jacoco:org.jacoco.agent:0.8.7` to `0.8.8`
* Removed `org.mockito:mockito-core:4.3.1`
* Updated `org.mockito:mockito-junit-jupiter:4.3.1` to `4.5.1`
* Updated `org.testcontainers:junit-jupiter:1.16.3` to `1.17.1`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:0.7.1` to `1.1.1`
* Updated `io.github.zlika:reproducible-build-maven-plugin:0.13` to `0.15`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.8.1` to `3.10.1`
* Updated `org.apache.maven.plugins:maven-deploy-plugin:2.7` to `3.0.0-M2`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.0.0-M3` to `3.0.0`
* Updated `org.apache.maven.plugins:maven-gpg-plugin:1.6` to `3.0.1`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.3.1` to `3.4.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.7` to `2.10.0`
* Updated `org.jacoco:jacoco-maven-plugin:0.8.7` to `0.8.8`
* Updated `org.sonatype.ossindex.maven:ossindex-maven-plugin:3.1.0` to `3.2.0`
* Updated `org.sonatype.plugins:nexus-staging-maven-plugin:1.6.8` to `1.6.13`
