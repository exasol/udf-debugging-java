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
| [Apache Commons Compress][11]           | [Apache-2.0][12]                                                                                             |
| [SLF4J JDK14 Provider][13]              | [MIT License][14]                                                                                            |

## Test Dependencies

| Dependency                                      | License                           |
| ----------------------------------------------- | --------------------------------- |
| [JaCoCo :: Agent][5]                            | [Eclipse Public License 2.0][6]   |
| [JUnit Jupiter Engine][15]                      | [Eclipse Public License v2.0][16] |
| [JUnit Jupiter Params][15]                      | [Eclipse Public License v2.0][16] |
| [mockito-junit-jupiter][17]                     | [MIT][18]                         |
| [Hamcrest All][19]                              | [New BSD License][20]             |
| [Test containers for Exasol on Docker][21]      | [MIT License][22]                 |
| [Testcontainers :: JUnit Jupiter Extension][23] | [MIT][24]                         |
| [Test Database Builder for Java][25]            | [MIT License][26]                 |
| [JUnit5 System Extensions][27]                  | [Eclipse Public License v2.0][28] |

## Runtime Dependencies

| Dependency            | License                                                                                                      |
| --------------------- | ------------------------------------------------------------------------------------------------------------ |
| [Eclipse Parsson][29] | [Eclipse Public License 2.0][1]; [GNU General Public License, version 2 with the GNU Classpath Exception][2] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][30]                       | [GNU LGPL 3][31]                               |
| [Apache Maven Toolchains Plugin][32]                    | [Apache License, Version 2.0][12]              |
| [Maven Dependency Plugin][33]                           | [The Apache Software License, Version 2.0][34] |
| [Project Keeper Maven plugin][35]                       | [The MIT License][36]                          |
| [Apache Maven Compiler Plugin][37]                      | [Apache-2.0][12]                               |
| [Apache Maven Enforcer Plugin][38]                      | [Apache-2.0][12]                               |
| [Maven Flatten Plugin][39]                              | [Apache Software Licenese][12]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][40] | [ASL2][34]                                     |
| [Maven Surefire Plugin][41]                             | [Apache-2.0][12]                               |
| [Versions Maven Plugin][42]                             | [Apache License, Version 2.0][12]              |
| [duplicate-finder-maven-plugin Maven Mojo][43]          | [Apache License 2.0][44]                       |
| [Apache Maven Deploy Plugin][45]                        | [Apache-2.0][12]                               |
| [Apache Maven GPG Plugin][46]                           | [Apache-2.0][12]                               |
| [Apache Maven Source Plugin][47]                        | [Apache License, Version 2.0][12]              |
| [Apache Maven Javadoc Plugin][48]                       | [Apache-2.0][12]                               |
| [Nexus Staging Maven Plugin][49]                        | [Eclipse Public License][50]                   |
| [Maven Failsafe Plugin][51]                             | [Apache-2.0][12]                               |
| [JaCoCo :: Maven Plugin][52]                            | [Eclipse Public License 2.0][6]                |
| [error-code-crawler-maven-plugin][53]                   | [MIT License][54]                              |
| [Reproducible Build Maven Plugin][55]                   | [Apache 2.0][34]                               |

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
[18]: https://opensource.org/licenses/MIT
[19]: https://github.com/hamcrest/JavaHamcrest
[20]: http://www.opensource.org/licenses/bsd-license.php
[21]: https://github.com/exasol/exasol-testcontainers/
[22]: https://github.com/exasol/exasol-testcontainers/blob/main/LICENSE
[23]: https://java.testcontainers.org
[24]: http://opensource.org/licenses/MIT
[25]: https://github.com/exasol/test-db-builder-java/
[26]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[27]: https://github.com/itsallcode/junit5-system-extensions
[28]: http://www.eclipse.org/legal/epl-v20.html
[29]: https://github.com/eclipse-ee4j/parsson
[30]: http://sonarsource.github.io/sonar-scanner-maven/
[31]: http://www.gnu.org/licenses/lgpl.txt
[32]: https://maven.apache.org/plugins/maven-toolchains-plugin/
[33]: http://maven.apache.org/plugins/maven-dependency-plugin/
[34]: http://www.apache.org/licenses/LICENSE-2.0.txt
[35]: https://github.com/exasol/project-keeper/
[36]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[37]: https://maven.apache.org/plugins/maven-compiler-plugin/
[38]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[39]: https://www.mojohaus.org/flatten-maven-plugin/
[40]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[41]: https://maven.apache.org/surefire/maven-surefire-plugin/
[42]: https://www.mojohaus.org/versions/versions-maven-plugin/
[43]: https://basepom.github.io/duplicate-finder-maven-plugin
[44]: http://www.apache.org/licenses/LICENSE-2.0.html
[45]: https://maven.apache.org/plugins/maven-deploy-plugin/
[46]: https://maven.apache.org/plugins/maven-gpg-plugin/
[47]: https://maven.apache.org/plugins/maven-source-plugin/
[48]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[49]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[50]: http://www.eclipse.org/legal/epl-v10.html
[51]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[52]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[53]: https://github.com/exasol/error-code-crawler-maven-plugin/
[54]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[55]: http://zlika.github.io/reproducible-build-maven-plugin
