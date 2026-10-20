# Udf Debugging Java 0.6.22, released 2026-10-20

Code name: Fixed CVE-2026-112046

## Summary

This release fixes the following vulnerabilities by pinning the version of transitive dependencies `org.ow2.asm:*:9.11.1`.

This is necessary because there is no update for `org.jacoco.agent` available yet that includes these updates.

First pin was in version 0.6.21.

* In `org.ow2.asm:asm:jar:9.10.1`:
   * CVE-2026-110257: Uncontrolled Memory Allocation (6.8)
   * CVE-2026-110258: Uncontrolled Memory Allocation (6.8)
   * CVE-2026-110259: Uncontrolled Recursion (5.5)
   * CVE-2026-110260: Algorithmic Complexity (5.5)
   * CVE-2026-110261: Algorithmic Complexity (6.8)
   * CVE-2026-110263: Uncontrolled Recursion (6.8)
* In `org.ow2.asm:asm:jar:9.11`:
  *  CVE-2026-112046: Loop with Unreachable Exit Condition ('Infinite Loop') (5.5)
* In `org.ow2.asm:asm-commons:jar:9.10.1`
   * CVE-2026-110262: Allocation of Resources Without Limits or Throttling (4.8)
   * CVE-2026-110270: Algorithmic Complexity (5.5)

## Features

* Fixed CVEs in transitive dependency `org.ow2.asm:*` (PR# 91)

## Dependency Updates

### Compile Dependency Updates

* Updated `org.ow2.asm:asm-commons:9.11` to `9.11.1`
* Updated `org.ow2.asm:asm-tree:9.11` to `9.11.1`
* Updated `org.ow2.asm:asm:9.11` to `9.11.1`
