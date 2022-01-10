# UDF Debugging Tools for Java

[![Build Status](https://github.com/exasol/udf-debugging-java/actions/workflows/ci-build.yml/badge.svg)](https://github.com/exasol/udf-debugging-java/actions/workflows/ci-build.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.exasol/udf-debugging-java)](https://search.maven.org/artifact/com.exasol/udf-debugging-java)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Audf-debugging-java&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.exasol%3Audf-debugging-java)

[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Audf-debugging-java&metric=security_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Audf-debugging-java)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Audf-debugging-java&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Audf-debugging-java)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Audf-debugging-java&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=com.exasol%3Audf-debugging-java)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Audf-debugging-java&metric=sqale_index)](https://sonarcloud.io/dashboard?id=com.exasol%3Audf-debugging-java)

[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Audf-debugging-java&metric=code_smells)](https://sonarcloud.io/dashboard?id=com.exasol%3Audf-debugging-java)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Audf-debugging-java&metric=coverage)](https://sonarcloud.io/dashboard?id=com.exasol%3Audf-debugging-java)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Audf-debugging-java&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=com.exasol%3Audf-debugging-java)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=com.exasol%3Audf-debugging-java&metric=ncloc)](https://sonarcloud.io/dashboard?id=com.exasol%3Audf-debugging-java)

This repository contains tools for debugging UDFs.

## Installation

Install as maven dependency. You can get the dependency declaration by clicking the maven badge above.

## Typical Usage

Typically, you use this package together with [test-db-builder-java](https://github.com/exasol/test-db-builder-java) and [exasol-testcontainers](https://github.com/exasol/exasol-testcontainers) as follows:

```java

private static final ExasolContainer<?extends ExasolContainer<?>> EXASOL=new ExasolContainer<>();
final UdfTestSetup udfTestSetup=new UdfTestSetup(getTestHostIp(),EXASOL.getDefaultBucket());
final ExasolObjectFactory testDbBuilder=new ExasolObjectFactory(EXASOL.createConnection(),
        ExasolObjectConfiguration.builder().withJvmOptions(udfTestSetup.getJvmOptions()).build());
```

## Modules

This package contains multiple modules that you can enable on runtime by setting the corresponding system property to `true`. Typically, you do so by appending `-D<PROPERTY_NAME>="true"` to your JVM call.

### Debugging

System property: `test.debug`

This module instructs the UDF JVMs to connect to a Java debugger listening on the default port 8000 on you machine, running the tests.

### Code Coverage

System property: `test.coverage`

This module installs a jacoco agent to the UDF JVM and receives the execution data using a TCP socket.

This module requires additional maven configuration. Use the [project-keeper's](https://github.com/exasol/project-keeper-maven-plugin) `udf_coverage` module to verify it.

### JProfiler

System property: `test.jprofiler`

This module allows you to profile UDF runs using [JProfiler](https://www.ej-technologies.com/products/jprofiler/overview.html). For that it uploads the JProfiler archive to BucketFs and adds the agent to the UDF command.

Since JProfiler uses a forward TCP connection you can only profile one UDF instance at once. Make sure that you don't start multiple parallel instances.

#### Usage

* Install JProfiler on your system
* Download JProfiler for Linux without JRE as `.tar.gz` (Also choose the Linux version if you're on a different operating system!)
* Now you've two options:
    * Store it as `jprofiler.tar.gz` in your home directory
    * Store it somewhere and pass `-DjProfilerAgent=<path to the archive.tar.gz>` to each test run
* Run your tests with `-Dtest.jprofiler=true`
* Find out the IPv4 address of your Exasol DB (for docker use `docker inspect`)
* Start JProfiler GUI
* Connect to `<EXASOL_IP>:11002`
    * The UDF execution will wait until you connect the profiler
    * Ensure that the port is reachable from your system (for AWS instances you can use an SSH tunnel from inside JProfiler)

### UDF Logs

System property: `test.udf-logs`

This module redirects the STDOUT from UDFs to files on the test host.

You can find the logs in `target/udf-logs/`. For each incoming stream (UDF instance) this module creates one file and logs its name:

```
Created log file for UDF output: target/udf-logs/udf-log-16150321841745991713.txt
```

## Additional Information

* [Changelog](doc/changes/changelog.md)
* [Dependencies](dependencies.md)
