<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                              | License                                                                                                      |
| --------------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| [Jakarta JSON Processing API][0]        | [Eclipse Public License 2.0][1]; [GNU General Public License, version 2 with the GNU Classpath Exception][2] |
| [error-reporting-java][3]               | [MIT License][4]                                                                                             |
| [JaCoCo :: Core][5]                     | [EPL-2.0][6]                                                                                                 |
| [BucketFS Java][7]                      | [MIT License][8]                                                                                             |
| [exasol-test-setup-abstraction-java][9] | [MIT License][10]                                                                                            |
| [Apache Commons Compress][11]           | [Apache-2.0][12]                                                                                             |
| [SLF4J JDK14 Provider][13]              | [MIT][14]                                                                                                    |

## Test Dependencies

| Dependency                                      | License                           |
| ----------------------------------------------- | --------------------------------- |
| [JaCoCo :: Agent][5]                            | [EPL-2.0][6]                      |
| [JUnit Jupiter Params][15]                      | [Eclipse Public License v2.0][16] |
| [mockito-junit-jupiter][17]                     | [MIT][18]                         |
| [Hamcrest][19]                                  | [BSD-3-Clause][20]                |
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
| [Apache Maven Toolchains Plugin][32]                    | [Apache-2.0][12]                               |
| [Apache Maven Compiler Plugin][33]                      | [Apache-2.0][12]                               |
| [Apache Maven Enforcer Plugin][34]                      | [Apache-2.0][12]                               |
| [Maven Flatten Plugin][35]                              | [Apache Software License][12]                  |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][36] | [ASL2][37]                                     |
| [Maven Surefire Plugin][38]                             | [Apache-2.0][12]                               |
| [Versions Maven Plugin][39]                             | [Apache License, Version 2.0][12]              |
| [duplicate-finder-maven-plugin Maven Mojo][40]          | [Apache License 2.0][41]                       |
| [Apache Maven Artifact Plugin][42]                      | [Apache-2.0][12]                               |
| [Apache Maven Deploy Plugin][43]                        | [Apache-2.0][12]                               |
| [Apache Maven Source Plugin][44]                        | [Apache-2.0][12]                               |
| [Apache Maven Javadoc Plugin][45]                       | [Apache-2.0][12]                               |
| [spdx-maven-plugin Maven Plugin][46]                    | [The Apache Software License, Version 2.0][37] |
| [Build Helper Maven Plugin][47]                         | [The MIT License][48]                          |
| [Apache Maven GPG Plugin][49]                           | [Apache-2.0][12]                               |
| [Central Publishing Maven Plugin][50]                   | [The Apache License, Version 2.0][12]          |
| [Maven Failsafe Plugin][51]                             | [Apache-2.0][12]                               |
| [JaCoCo :: Maven Plugin][52]                            | [EPL-2.0][6]                                   |
| [error-code-crawler-maven-plugin][53]                   | [MIT License][54]                              |
| [Git Commit Id Maven Plugin][55]                        | [GNU Lesser General Public License 3.0][56]    |
| [Apache Maven Dependency Plugin][57]                    | [Apache-2.0][12]                               |
| [Project Keeper Maven plugin][58]                       | [The MIT License][59]                          |
| [Apache Maven Clean Plugin][60]                         | [Apache-2.0][12]                               |
| [Apache Maven Resources Plugin][61]                     | [Apache-2.0][12]                               |
| [Apache Maven Install Plugin][62]                       | [Apache-2.0][12]                               |
| [Apache Maven Site Plugin][63]                          | [Apache-2.0][12]                               |

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
[14]: https://opensource.org/license/mit
[15]: https://junit.org/
[16]: https://www.eclipse.org/legal/epl-v20.html
[17]: https://github.com/mockito/mockito
[18]: https://opensource.org/licenses/MIT
[19]: http://hamcrest.org/JavaHamcrest/
[20]: https://raw.githubusercontent.com/hamcrest/JavaHamcrest/master/LICENSE
[21]: https://github.com/exasol/exasol-testcontainers/
[22]: https://github.com/exasol/exasol-testcontainers/blob/main/LICENSE
[23]: https://java.testcontainers.org
[24]: http://opensource.org/licenses/MIT
[25]: https://github.com/exasol/test-db-builder-java/
[26]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[27]: https://github.com/itsallcode/junit5-system-extensions
[28]: http://www.eclipse.org/legal/epl-v20.html
[29]: https://github.com/eclipse-ee4j/parsson
[30]: https://docs.sonarsource.com/sonarqube-server/latest/extension-guide/developing-a-plugin/plugin-basics/sonar-scanner-maven/sonar-maven-plugin/
[31]: http://www.gnu.org/licenses/lgpl.txt
[32]: https://maven.apache.org/plugins/maven-toolchains-plugin/
[33]: https://maven.apache.org/plugins/maven-compiler-plugin/
[34]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[35]: https://www.mojohaus.org/flatten-maven-plugin/
[36]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[37]: http://www.apache.org/licenses/LICENSE-2.0.txt
[38]: https://maven.apache.org/surefire/maven-surefire-plugin/
[39]: https://www.mojohaus.org/versions/versions-maven-plugin/
[40]: https://basepom.github.io/duplicate-finder-maven-plugin
[41]: http://www.apache.org/licenses/LICENSE-2.0.html
[42]: https://maven.apache.org/plugins/maven-artifact-plugin/
[43]: https://maven.apache.org/plugins/maven-deploy-plugin/
[44]: https://maven.apache.org/plugins/maven-source-plugin/
[45]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[46]: https://github.com/spdx/spdx-maven-plugin
[47]: https://www.mojohaus.org/build-helper-maven-plugin/
[48]: https://spdx.org/licenses/MIT.txt
[49]: https://maven.apache.org/plugins/maven-gpg-plugin/
[50]: https://central.sonatype.org
[51]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[52]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[53]: https://github.com/exasol/error-code-crawler-maven-plugin/
[54]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[55]: https://github.com/git-commit-id/git-commit-id-maven-plugin
[56]: http://www.gnu.org/licenses/lgpl-3.0.txt
[57]: https://maven.apache.org/plugins/maven-dependency-plugin/
[58]: https://github.com/exasol/project-keeper/
[59]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[60]: https://maven.apache.org/plugins/maven-clean-plugin/
[61]: https://maven.apache.org/plugins/maven-resources-plugin/
[62]: https://maven.apache.org/plugins/maven-install-plugin/
[63]: https://maven.apache.org/plugins/maven-site-plugin/
