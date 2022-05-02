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
| [Test Database Builder for Java][13]    | [MIT License][14]                                                                                            |
| [SLF4J API Module][15]                  | [MIT License][16]                                                                                            |
| [JUnit5 System Extensions][17]          | [Eclipse Public License v2.0][18]                                                                            |

## Test Dependencies

| Dependency                                      | License                           |
| ----------------------------------------------- | --------------------------------- |
| [JaCoCo :: Agent][5]                            | [Eclipse Public License 2.0][6]   |
| [JUnit Jupiter Engine][21]                      | [Eclipse Public License v2.0][22] |
| [JUnit Jupiter Params][21]                      | [Eclipse Public License v2.0][22] |
| [mockito-junit-jupiter][25]                     | [The MIT License][26]             |
| [Hamcrest All][27]                              | [New BSD License][28]             |
| [Test containers for Exasol on Docker][29]      | [MIT][4]                          |
| [Testcontainers :: JUnit Jupiter Extension][31] | [MIT][32]                         |

## Runtime Dependencies

| Dependency                   | License                                                                                                      |
| ---------------------------- | ------------------------------------------------------------------------------------------------------------ |
| [JSON-P Default Provider][0] | [Eclipse Public License 2.0][1]; [GNU General Public License, version 2 with the GNU Classpath Exception][2] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [Maven Surefire Plugin][36]                             | [Apache License, Version 2.0][12]              |
| [Maven Failsafe Plugin][38]                             | [Apache License, Version 2.0][12]              |
| [JaCoCo :: Maven Plugin][40]                            | [Eclipse Public License 2.0][6]                |
| [Apache Maven Compiler Plugin][42]                      | [Apache License, Version 2.0][12]              |
| [Maven Dependency Plugin][44]                           | [The Apache Software License, Version 2.0][45] |
| [Versions Maven Plugin][46]                             | [Apache License, Version 2.0][12]              |
| [Apache Maven Source Plugin][48]                        | [Apache License, Version 2.0][12]              |
| [Apache Maven Javadoc Plugin][50]                       | [Apache License, Version 2.0][12]              |
| [Apache Maven GPG Plugin][52]                           | [Apache License, Version 2.0][12]              |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][54] | [ASL2][45]                                     |
| [Apache Maven Enforcer Plugin][56]                      | [Apache License, Version 2.0][12]              |
| [Project keeper maven plugin][58]                       | [MIT][4]                                       |
| [Apache Maven Deploy Plugin][60]                        | [Apache License, Version 2.0][12]              |
| [Nexus Staging Maven Plugin][62]                        | [Eclipse Public License][63]                   |
| [error-code-crawler-maven-plugin][64]                   | [MIT][4]                                       |
| [Reproducible Build Maven Plugin][66]                   | [Apache 2.0][45]                               |
| [Maven Clean Plugin][68]                                | [The Apache Software License, Version 2.0][45] |
| [Maven Resources Plugin][70]                            | [The Apache Software License, Version 2.0][45] |
| [Maven JAR Plugin][72]                                  | [The Apache Software License, Version 2.0][45] |
| [Maven Install Plugin][74]                              | [The Apache Software License, Version 2.0][45] |
| [Maven Site Plugin 3][76]                               | [The Apache Software License, Version 2.0][45] |

[5]: https://www.eclemma.org/jacoco/index.html
[58]: https://github.com/exasol/project-keeper-maven-plugin
[7]: https://github.com/exasol/bucketfs-java
[3]: https://github.com/exasol/error-reporting-java
[18]: http://www.eclipse.org/legal/epl-v20.html
[45]: http://www.apache.org/licenses/LICENSE-2.0.txt
[36]: https://maven.apache.org/surefire/maven-surefire-plugin/
[68]: http://maven.apache.org/plugins/maven-clean-plugin/
[4]: https://opensource.org/licenses/MIT
[25]: https://github.com/mockito/mockito
[11]: https://commons.apache.org/proper/commons-compress/
[46]: http://www.mojohaus.org/versions-maven-plugin/
[42]: https://maven.apache.org/plugins/maven-compiler-plugin/
[14]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[6]: https://www.eclipse.org/legal/epl-2.0/
[60]: https://maven.apache.org/plugins/maven-deploy-plugin/
[40]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[26]: https://github.com/mockito/mockito/blob/main/LICENSE
[66]: http://zlika.github.io/reproducible-build-maven-plugin
[16]: http://www.opensource.org/licenses/mit-license.php
[21]: https://junit.org/junit5/
[0]: https://github.com/eclipse-ee4j/jsonp
[48]: https://maven.apache.org/plugins/maven-source-plugin/
[2]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[15]: http://www.slf4j.org
[70]: http://maven.apache.org/plugins/maven-resources-plugin/
[9]: https://github.com/exasol/exasol-test-setup-abstraction-java
[13]: https://github.com/exasol/test-db-builder-java/
[62]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[38]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[44]: http://maven.apache.org/plugins/maven-dependency-plugin/
[32]: http://opensource.org/licenses/MIT
[63]: http://www.eclipse.org/legal/epl-v10.html
[29]: https://github.com/exasol/exasol-testcontainers
[72]: http://maven.apache.org/plugins/maven-jar-plugin/
[1]: https://projects.eclipse.org/license/epl-2.0
[12]: https://www.apache.org/licenses/LICENSE-2.0.txt
[56]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[22]: https://www.eclipse.org/legal/epl-v20.html
[28]: http://www.opensource.org/licenses/bsd-license.php
[74]: http://maven.apache.org/plugins/maven-install-plugin/
[54]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[52]: https://maven.apache.org/plugins/maven-gpg-plugin/
[27]: https://github.com/hamcrest/JavaHamcrest/
[31]: https://testcontainers.org
[17]: https://github.com/itsallcode/junit5-system-extensions
[76]: http://maven.apache.org/plugins/maven-site-plugin/
[50]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[64]: https://github.com/exasol/error-code-crawler-maven-plugin
