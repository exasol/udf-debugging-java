<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                              | License                                                                                                      |
| --------------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| [Jakarta JSON Processing API][0]        | [Eclipse Public License 2.0][1]; [GNU General Public License, version 2 with the GNU Classpath Exception][2] |
| [error-reporting-java][3]               | [MIT License][4]                                                                                             |
| [JaCoCo :: Core][5]                     | [Eclipse Public License 2.0][6]                                                                              |
| [BucketFS Java][7]                      | [MIT License][8]                                                                                             |
| [exasol-test-setup-abstraction-java][9] | [MIT License][10]                                                                                            |
| [Apache Commons Compress][11]           | [Apache License, Version 2.0][12]                                                                            |
| [SLF4J API Module][13]                  | [MIT License][14]                                                                                            |

## Test Dependencies

| Dependency                                      | License                           |
| ----------------------------------------------- | --------------------------------- |
| [JaCoCo :: Agent][5]                            | [Eclipse Public License 2.0][6]   |
| [JUnit Jupiter Engine][15]                      | [Eclipse Public License v2.0][16] |
| [JUnit Jupiter Params][15]                      | [Eclipse Public License v2.0][16] |
| [mockito-junit-jupiter][17]                     | [The MIT License][18]             |
| [Hamcrest All][19]                              | [New BSD License][20]             |
| [Test containers for Exasol on Docker][21]      | [MIT License][22]                 |
| [Testcontainers :: JUnit Jupiter Extension][23] | [MIT][24]                         |
| [Test Database Builder for Java][25]            | [MIT License][26]                 |
| [JUnit5 System Extensions][27]                  | [Eclipse Public License v2.0][28] |

## Runtime Dependencies

| Dependency                   | License                                                                                                      |
| ---------------------------- | ------------------------------------------------------------------------------------------------------------ |
| [JSON-P Default Provider][0] | [Eclipse Public License 2.0][1]; [GNU General Public License, version 2 with the GNU Classpath Exception][2] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][29]                       | [GNU LGPL 3][30]                               |
| [Apache Maven Compiler Plugin][31]                      | [Apache License, Version 2.0][12]              |
| [Apache Maven Enforcer Plugin][32]                      | [Apache License, Version 2.0][12]              |
| [Maven Flatten Plugin][33]                              | [Apache Software Licenese][12]                 |
| [Maven Dependency Plugin][34]                           | [The Apache Software License, Version 2.0][35] |
| [Project keeper maven plugin][36]                       | [The MIT License][37]                          |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][38] | [ASL2][35]                                     |
| [Maven Surefire Plugin][39]                             | [Apache License, Version 2.0][12]              |
| [Versions Maven Plugin][40]                             | [Apache License, Version 2.0][12]              |
| [Apache Maven Deploy Plugin][41]                        | [Apache License, Version 2.0][12]              |
| [Apache Maven GPG Plugin][42]                           | [Apache License, Version 2.0][12]              |
| [Apache Maven Source Plugin][43]                        | [Apache License, Version 2.0][12]              |
| [Apache Maven Javadoc Plugin][44]                       | [Apache License, Version 2.0][12]              |
| [Nexus Staging Maven Plugin][45]                        | [Eclipse Public License][46]                   |
| [Maven Failsafe Plugin][47]                             | [Apache License, Version 2.0][12]              |
| [JaCoCo :: Maven Plugin][48]                            | [Eclipse Public License 2.0][6]                |
| [error-code-crawler-maven-plugin][49]                   | [MIT License][50]                              |
| [Reproducible Build Maven Plugin][51]                   | [Apache 2.0][35]                               |
| [Maven Clean Plugin][52]                                | [The Apache Software License, Version 2.0][35] |
| [Maven Resources Plugin][53]                            | [The Apache Software License, Version 2.0][35] |
| [Maven JAR Plugin][54]                                  | [The Apache Software License, Version 2.0][35] |
| [Maven Install Plugin][55]                              | [The Apache Software License, Version 2.0][35] |
| [Maven Site Plugin 3][56]                               | [The Apache Software License, Version 2.0][35] |

[0]: https://github.com/eclipse-ee4j/jsonp
[1]: https://projects.eclipse.org/license/epl-2.0
[2]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[3]: https://github.com/exasol/error-reporting-java/
[4]: https://github.com/exasol/error-reporting-java/blob/main/LICENSE
[5]: https://www.eclemma.org/jacoco/index.html
[6]: https://www.eclipse.org/legal/epl-2.0/
[7]: https://github.com/exasol/bucketfs-java/
[8]: https://github.com/exasol/bucketfs-java/blob/main/LICENSE
[9]: https://github.com/exasol/exasol-test-setup-abstraction-java/
[10]: https://github.com/exasol/exasol-test-setup-abstraction-java/blob/main/LICENSE
[11]: https://commons.apache.org/proper/commons-compress/
[12]: https://www.apache.org/licenses/LICENSE-2.0.txt
[13]: http://www.slf4j.org
[14]: http://www.opensource.org/licenses/mit-license.php
[15]: https://junit.org/junit5/
[16]: https://www.eclipse.org/legal/epl-v20.html
[17]: https://github.com/mockito/mockito
[18]: https://github.com/mockito/mockito/blob/main/LICENSE
[19]: https://github.com/hamcrest/JavaHamcrest
[20]: http://www.opensource.org/licenses/bsd-license.php
[21]: https://github.com/exasol/exasol-testcontainers/
[22]: https://github.com/exasol/exasol-testcontainers/blob/main/LICENSE
[23]: https://testcontainers.org
[24]: http://opensource.org/licenses/MIT
[25]: https://github.com/exasol/test-db-builder-java/
[26]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[27]: https://github.com/itsallcode/junit5-system-extensions
[28]: http://www.eclipse.org/legal/epl-v20.html
[29]: http://sonarsource.github.io/sonar-scanner-maven/
[30]: http://www.gnu.org/licenses/lgpl.txt
[31]: https://maven.apache.org/plugins/maven-compiler-plugin/
[32]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[33]: https://www.mojohaus.org/flatten-maven-plugin/
[34]: http://maven.apache.org/plugins/maven-dependency-plugin/
[35]: http://www.apache.org/licenses/LICENSE-2.0.txt
[36]: https://github.com/exasol/project-keeper/
[37]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[38]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[39]: https://maven.apache.org/surefire/maven-surefire-plugin/
[40]: https://www.mojohaus.org/versions-maven-plugin/
[41]: https://maven.apache.org/plugins/maven-deploy-plugin/
[42]: https://maven.apache.org/plugins/maven-gpg-plugin/
[43]: https://maven.apache.org/plugins/maven-source-plugin/
[44]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[45]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[46]: http://www.eclipse.org/legal/epl-v10.html
[47]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[48]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[49]: https://github.com/exasol/error-code-crawler-maven-plugin/
[50]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[51]: http://zlika.github.io/reproducible-build-maven-plugin
[52]: http://maven.apache.org/plugins/maven-clean-plugin/
[53]: http://maven.apache.org/plugins/maven-resources-plugin/
[54]: http://maven.apache.org/plugins/maven-jar-plugin/
[55]: http://maven.apache.org/plugins/maven-install-plugin/
[56]: http://maven.apache.org/plugins/maven-site-plugin/
