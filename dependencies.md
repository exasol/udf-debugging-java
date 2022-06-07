<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                              | License                                                                                                      |
| --------------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| [Jakarta JSON Processing API][0]        | [Eclipse Public License 2.0][1]; [GNU General Public License, version 2 with the GNU Classpath Exception][2] |
| [error-reporting-java][3]               | [MIT][4]                                                                                                     |
| [JaCoCo :: Core][5]                     | [Eclipse Public License 2.0][6]                                                                              |
| [BucketFS Java][7]                      | [MIT][4]                                                                                                     |
| [exasol-test-setup-abstraction-java][9] | [MIT License][10]                                                                                            |
| [Apache Commons Compress][11]           | [Apache License, Version 2.0][12]                                                                            |
| [SLF4J API Module][13]                  | [MIT License][14]                                                                                            |

## Test Dependencies

| Dependency                                      | License                           |
| ----------------------------------------------- | --------------------------------- |
| [JaCoCo :: Agent][5]                            | [Eclipse Public License 2.0][6]   |
| [JUnit Jupiter Engine][17]                      | [Eclipse Public License v2.0][18] |
| [JUnit Jupiter Params][17]                      | [Eclipse Public License v2.0][18] |
| [mockito-junit-jupiter][21]                     | [The MIT License][22]             |
| [Hamcrest All][23]                              | [New BSD License][24]             |
| [Test containers for Exasol on Docker][25]      | [MIT][4]                          |
| [Testcontainers :: JUnit Jupiter Extension][27] | [MIT][28]                         |
| [Test Database Builder for Java][29]            | [MIT License][30]                 |
| [JUnit5 System Extensions][31]                  | [Eclipse Public License v2.0][32] |

## Runtime Dependencies

| Dependency                   | License                                                                                                      |
| ---------------------------- | ------------------------------------------------------------------------------------------------------------ |
| [JSON-P Default Provider][0] | [Eclipse Public License 2.0][1]; [GNU General Public License, version 2 with the GNU Classpath Exception][2] |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][36]                       | [GNU LGPL 3][37]                               |
| [Apache Maven Compiler Plugin][38]                      | [Apache License, Version 2.0][12]              |
| [Apache Maven Enforcer Plugin][40]                      | [Apache License, Version 2.0][12]              |
| [Maven Flatten Plugin][42]                              | [Apache Software Licenese][43]                 |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][44] | [ASL2][43]                                     |
| [Reproducible Build Maven Plugin][46]                   | [Apache 2.0][43]                               |
| [Maven Dependency Plugin][48]                           | [The Apache Software License, Version 2.0][43] |
| [Project keeper maven plugin][50]                       | [The MIT License][51]                          |
| [Maven Surefire Plugin][52]                             | [Apache License, Version 2.0][12]              |
| [Versions Maven Plugin][54]                             | [Apache License, Version 2.0][12]              |
| [Apache Maven Deploy Plugin][56]                        | [Apache License, Version 2.0][12]              |
| [Apache Maven GPG Plugin][58]                           | [Apache License, Version 2.0][12]              |
| [Apache Maven Source Plugin][60]                        | [Apache License, Version 2.0][12]              |
| [Apache Maven Javadoc Plugin][62]                       | [Apache License, Version 2.0][12]              |
| [Nexus Staging Maven Plugin][64]                        | [Eclipse Public License][65]                   |
| [Maven Failsafe Plugin][66]                             | [Apache License, Version 2.0][12]              |
| [JaCoCo :: Maven Plugin][68]                            | [Eclipse Public License 2.0][6]                |
| [error-code-crawler-maven-plugin][70]                   | [MIT][4]                                       |
| [Maven Clean Plugin][72]                                | [The Apache Software License, Version 2.0][43] |
| [Maven Resources Plugin][74]                            | [The Apache Software License, Version 2.0][43] |
| [Maven JAR Plugin][76]                                  | [The Apache Software License, Version 2.0][43] |
| [Maven Install Plugin][78]                              | [The Apache Software License, Version 2.0][43] |
| [Maven Site Plugin 3][80]                               | [The Apache Software License, Version 2.0][43] |

[5]: https://www.eclemma.org/jacoco/index.html
[7]: https://github.com/exasol/bucketfs-java
[3]: https://github.com/exasol/error-reporting-java
[32]: http://www.eclipse.org/legal/epl-v20.html
[23]: https://github.com/hamcrest/JavaHamcrest
[43]: http://www.apache.org/licenses/LICENSE-2.0.txt
[52]: https://maven.apache.org/surefire/maven-surefire-plugin/
[72]: http://maven.apache.org/plugins/maven-clean-plugin/
[4]: https://opensource.org/licenses/MIT
[21]: https://github.com/mockito/mockito
[42]: https://www.mojohaus.org/flatten-maven-plugin/
[11]: https://commons.apache.org/proper/commons-compress/
[50]: https://github.com/exasol/project-keeper/
[54]: http://www.mojohaus.org/versions-maven-plugin/
[38]: https://maven.apache.org/plugins/maven-compiler-plugin/
[30]: https://github.com/exasol/test-db-builder-java/blob/main/LICENSE
[6]: https://www.eclipse.org/legal/epl-2.0/
[9]: https://github.com/exasol/exasol-test-setup-abstraction-java/
[56]: https://maven.apache.org/plugins/maven-deploy-plugin/
[37]: http://www.gnu.org/licenses/lgpl.txt
[68]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[22]: https://github.com/mockito/mockito/blob/main/LICENSE
[46]: http://zlika.github.io/reproducible-build-maven-plugin
[10]: https://github.com/exasol/exasol-test-setup-abstraction-java/blob/main/LICENSE
[14]: http://www.opensource.org/licenses/mit-license.php
[36]: http://sonarsource.github.io/sonar-scanner-maven/
[17]: https://junit.org/junit5/
[0]: https://github.com/eclipse-ee4j/jsonp
[60]: https://maven.apache.org/plugins/maven-source-plugin/
[2]: https://projects.eclipse.org/license/secondary-gpl-2.0-cp
[13]: http://www.slf4j.org
[74]: http://maven.apache.org/plugins/maven-resources-plugin/
[29]: https://github.com/exasol/test-db-builder-java/
[64]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[66]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[48]: http://maven.apache.org/plugins/maven-dependency-plugin/
[28]: http://opensource.org/licenses/MIT
[65]: http://www.eclipse.org/legal/epl-v10.html
[25]: https://github.com/exasol/exasol-testcontainers
[51]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[76]: http://maven.apache.org/plugins/maven-jar-plugin/
[1]: https://projects.eclipse.org/license/epl-2.0
[12]: https://www.apache.org/licenses/LICENSE-2.0.txt
[40]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[18]: https://www.eclipse.org/legal/epl-v20.html
[24]: http://www.opensource.org/licenses/bsd-license.php
[78]: http://maven.apache.org/plugins/maven-install-plugin/
[44]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[58]: https://maven.apache.org/plugins/maven-gpg-plugin/
[27]: https://testcontainers.org
[31]: https://github.com/itsallcode/junit5-system-extensions
[80]: http://maven.apache.org/plugins/maven-site-plugin/
[62]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[70]: https://github.com/exasol/error-code-crawler-maven-plugin
