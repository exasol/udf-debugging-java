# Udf Debugging Java 0.6.19, released 2026-??-??

Code name: Fixed vulnerabilities CVE-2017-7503, CVE-2017-10355, CVE-2026-9563

## Summary

This release fixes the following 3 vulnerabilities:

### CVE-2017-7503 (CWE-611) in dependency `xerces:xercesImpl:jar:2.12.2:provided`
It was found that the Red Hat JBoss EAP 7.0.5 implementation of javax.xml.transform.TransformerFactory is vulnerable to XXE. An attacker could use this flaw to launch DoS or SSRF attacks, or read files from the server where EAP is deployed.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2017-7503?component-type=maven&component-name=xerces%2FxercesImpl&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2017-7503
* https://bugzilla.redhat.com/show_bug.cgi?id=CVE-2017-7503

### CVE-2017-10355 (CWE-833) in dependency `xerces:xercesImpl:jar:2.12.2:provided`
sonatype-2017-0348 - xerces:xercesImpl - Denial of Service (DoS)
#### References
* https://guide.sonatype.com/vulnerability/CVE-2017-10355?component-type=maven&component-name=xerces%2FxercesImpl&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2017-10355
* https://blogs.securiteam.com/index.php/archives/3271

### CVE-2026-9563 (CWE-400) in dependency `org.eclipse.parsson:parsson:jar:1.1.7:runtime`
In Eclipse Parsson published Maven Central artifacts before version 1.1.8, the JSON parser did not enforce a default maximum on the number of characters consumed while parsing a single JSON document. Applications that parse attacker- controlled JSON can be forced to consume excessive CPU and memory by processing very large documents, including large arrays, objects, strings, numbers, whitespace, or nested structures, resulting in a denial of service. Eclipse Parsson 1.1.8 introduces a configurable maximum parsing limit with a default limit of 15 million parser-consumed characters.
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-9563?component-type=maven&component-name=org.eclipse.parsson%2Fparsson&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-9563
* https://github.com/eclipse-ee4j/parsson/pull/169
* https://gitlab.eclipse.org/security/vulnerability-reports/-/work_items/444

## Security

* #81: Fixed vulnerability CVE-2017-7503 in dependency `xerces:xercesImpl:jar:2.12.2:provided`
* #82: Fixed vulnerability CVE-2017-10355 in dependency `xerces:xercesImpl:jar:2.12.2:provided`
* #83: Fixed vulnerability CVE-2026-9563 in dependency `org.eclipse.parsson:parsson:jar:1.1.7:runtime`

## Dependency Updates

### Compile Dependency Updates

* Updated `org.jacoco:org.jacoco.core:0.8.14` to `0.8.15`
* Updated `org.slf4j:slf4j-jdk14:2.0.17` to `2.0.18`

### Runtime Dependency Updates

* Updated `org.eclipse.parsson:parsson:1.1.7` to `1.1.9`

### Test Dependency Updates

* Updated `com.exasol:exasol-testcontainers:7.2.0` to `7.3.0`
* Updated `com.exasol:test-db-builder-java:3.6.4` to `4.0.1`
* Updated `org.itsallcode:junit5-system-extensions:1.2.2` to `1.2.3`
* Updated `org.jacoco:org.jacoco.agent:0.8.14` to `0.8.15`
* Updated `org.junit.jupiter:junit-jupiter-params:5.13.4` to `6.1.1`
* Updated `org.mockito:mockito-junit-jupiter:5.20.0` to `5.23.0`
* Updated `org.testcontainers:testcontainers-junit-jupiter:2.0.1` to `2.0.5`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:5.4.3` to `5.7.2`
