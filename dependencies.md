<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                              | License                                                                                                      |
| --------------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| [Jakarta JSON Processing API][0]        | [Eclipse Public License 2.0][1]; [GNU General Public License, version 2 with the GNU Classpath Exception][2] |
| [error-reporting-java][3]               | [MIT][4]                                                                                                     |
| [JaCoCo :: Core][5]                     | [Eclipse Public License 2.0][6]                                                                              |
| [BucketFS Java][7]                      | [MIT][4]                                                                                                     |
| [exasol-test-setup-abstraction-java][9] | [MIT][4]                                                                                                     |
| [Apache Commons Compress][11]           | [Apache License, Version 2.0][12]                                                                            |
| [Test Database Builder for Java][13]    | [MIT][4]                                                                                                     |
| [SLF4J API Module][15]                  | [MIT License][16]                                                                                            |
| [JUnit5 System Extensions][17]          | [Eclipse Public License v2.0][18]                                                                            |

## Test Dependencies

| Dependency                                      | License                           |
| ----------------------------------------------- | --------------------------------- |
| [JaCoCo :: Agent][5]                            | [Eclipse Public License 2.0][6]   |
| [JUnit Jupiter Engine][21]                      | [Eclipse Public License v2.0][22] |
| [JUnit Jupiter Params][21]                      | [Eclipse Public License v2.0][22] |
| [mockito-core][25]                              | [The MIT License][26]             |
| [mockito-junit-jupiter][25]                     | [The MIT License][26]             |
| [Hamcrest All][29]                              | [New BSD License][30]             |
| [Test containers for Exasol on Docker][31]      | [MIT][4]                          |
| [Testcontainers :: JUnit Jupiter Extension][33] | [MIT][34]                         |

## Runtime Dependencies

| Dependency                   | License                                                                                                      |
| ---------------------------- | ------------------------------------------------------------------------------------------------------------ |
| [JSON-P Default Provider][0] | [Eclipse Public License 2.0][1]; [GNU General Public License, version 2 with the GNU Classpath Exception][2] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [Maven Surefire Plugin][38]                             | [Apache License, Version 2.0][12]              |
| [Maven Failsafe Plugin][40]                             | [Apache License, Version 2.0][12]              |
| [JaCoCo :: Maven Plugin][42]                            | [Eclipse Public License 2.0][6]                |
| [Apache Maven Compiler Plugin][44]                      | [Apache License, Version 2.0][12]              |
| [Maven Dependency Plugin][46]                           | [The Apache Software License, Version 2.0][47] |
| [Versions Maven Plugin][48]                             | [Apache License, Version 2.0][12]              |
| [Apache Maven Source Plugin][50]                        | [Apache License, Version 2.0][12]              |
| [Apache Maven Javadoc Plugin][52]                       | [Apache License, Version 2.0][12]              |
| [Apache Maven GPG Plugin][54]                           | [Apache License, Version 2.0][47]              |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][56] | [ASL2][47]                                     |
| [Apache Maven Enforcer Plugin][58]                      | [Apache License, Version 2.0][12]              |
| [Project keeper maven plugin][60]                       | [MIT][4]                                       |
| [Maven Deploy Plugin][62]                               | [The Apache Software License, Version 2.0][47] |
| [Nexus Staging Maven Plugin][64]                        | [Eclipse Public License][65]                   |
| [error-code-crawler-maven-plugin][66]                   | [MIT][4]                                       |
| [Reproducible Build Maven Plugin][68]                   | [Apache 2.0][47]                               |
| [Maven Clean Plugin][70]                                | [The Apache Software License, Version 2.0][47] |
| [Maven Resources Plugin][72]                            | [The Apache Software License, Version 2.0][47] |
| [Maven JAR Plugin][74]                                  | [The Apache Software License, Version 2.0][47] |
| [Maven Install Plugin][76]                              | [The Apache Software License, Version 2.0][47] |
| [Maven Site Plugin 3][78]                               | [The Apache Software License, Version 2.0][47] |

[5]: https://www.eclemma.org/jacoco/index.html
[60]: https://github.com/exasol/project-keeper-maven-plugin
[7]: https://github.com/exasol/bucketfs-java
[3]: https://github.com/exasol/error-reporting-java
[18]: http://www.eclipse.org/legal/epl-v20.html
[47]: http://www.apache.org/licenses/LICENSE-2.0.txt
[38]: https://maven.apache.org/surefire/maven-surefire-plugin/
[64]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[70]: http://maven.apache.org/plugins/maven-clean-plugin/
[4]: https://opensource.org/licenses/MIT
[25]: https://github.com/mockito/mockito
[40]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[13]: https://github.com/exasol/test-db-builder-java
[11]: https://commons.apache.org/proper/commons-compress/
[46]: http://maven.apache.org/plugins/maven-dependency-plugin/
[48]: http://www.mojohaus.org/versions-maven-plugin/
[44]: https://maven.apache.org/plugins/maven-compiler-plugin/
[34]: http://opensource.org/licenses/MIT
[54]: http://maven.apache.org/plugins/maven-gpg-plugin/
[6]: https://www.eclipse.org/legal/epl-2.0/
[65]: http://www.eclipse.org/legal/epl-v10.html
[31]: https://github.com/exasol/exasol-testcontainers
[42]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[26]: https://github.com/mockito/mockito/blob/main/LICENSE
[68]: http://zlika.github.io/reproducible-build-maven-plugin
[74]: http://maven.apache.org/plugins/maven-jar-plugin/
[1]: https://projects.eclipse.org/license/epl-2.0
[16]: http://www.opensource.org/licenses/mit-license.php
[12]: https://www.apache.org/licenses/LICENSE-2.0.txt
[58]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[22]: https://www.eclipse.org/legal/epl-v20.html
[30]: http://www.opensource.org/licenses/bsd-license.php
[76]: http://maven.apache.org/plugins/maven-install-plugin/
[21]: https://junit.org/junit5/
[56]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[29]: https://github.com/hamcrest/JavaHamcrest/
[33]: https://testcontainers.org
[0]: https://github.com/eclipse-ee4j/jsonp
[17]: https://github.com/itsallcode/junit5-system-extensions
[50]: https://maven.apache.org/plugins/maven-source-plugin/
[2]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[15]: http://www.slf4j.org
[62]: http://maven.apache.org/plugins/maven-deploy-plugin/
[78]: http://maven.apache.org/plugins/maven-site-plugin/
[72]: http://maven.apache.org/plugins/maven-resources-plugin/
[52]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[66]: https://github.com/exasol/error-code-crawler-maven-plugin
[9]: https://github.com/exasol/exasol-test-setup-abstraction-java
