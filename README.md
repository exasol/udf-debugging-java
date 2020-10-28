# UDF Debugging Tools for Java

[![Build Status](https://travis-ci.com/exasol/udf-debugging-java.svg?branch=master)](https://travis-ci.com/exasol/udf-debugging-java)
[![Maven Central](https://img.shields.io/maven-central/v/com.exasol/udf-debugging-java)](https://search.maven.org/artifact/com.exasol/udf-debugging-java) 

This repository contains tools for debugging UDFs.

## Installation

Install as maven dependency.
You can get the dependency declaration by clicking the maven badge above.

## Typical Usage

Typically, you use this package together with [test-db-builder-java](https://github.com/exasol/test-db-builder-java) and [exasol-testcontainers](https://github.com/exasol/exasol-testcontainers) as follows:

```java
final UdfTestSetup udfTestSetup = new UdfTestSetup(getTestHostIp());
final ExasolObjectFactory testDbBuilder = new ExasolObjectFactory(EXASOL.createConnection(), 
    ExasolObjectConfiguration.builder().withJvmOptions(udfTestSetup.getJvmOptions()).build());
```

## Modules

This package contains multiple modules that you can enable on runtime by setting the corresponding system property to `true`.
Typically, you do so by appending `-D<PROPERTY_NAME>="true"` to your JVM call.


### Debugging

System property: `test.debug`

This module instructs the UDF JVMs to connect to a Java debugger listening on the default port 8000 on you machine, running the tests.


## Additional Information

* [Changelog](doc/changes/changelog.md)
* [Dependencies](NOTICE)
