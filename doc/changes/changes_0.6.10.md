# Udf Debugging Java 0.6.10, released 2023-07-05

Code name: Reduce dependencies

## Summary

This release uses readable and sortable names for UDF debug log files written to `target/udf-logs/`. The release also replaces code that causes an unnecessary dependency on `slf4j-api`.

## Features

* #56: Used readable and sortable names for UDF debug log files.

## Refactoring

* #55: Replaced code using `slf4j-api`
