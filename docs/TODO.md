grails-scala - TODO
===================

TODO
----

- for release 2.9.2 (my first public release of the plugin):
    + add some Scala test (unit/integration) to ensure that all is good ...
    + verify at runtime, if it's enough to have only scala-runtime, and not scala-compiler ...
    + compile('org.codehaus.groovy.modules:groovytransforms:0.2') ... , verify if it's still needed (and if there is a newer version) ...
    + SCALA_LICENSE, verify if it's right to have it there, or if move in root in other license-related files ...
    + update Groovy doc files ...


- for other releases:
    + verify if add even ScalaTest, or Specs in dependencies for tests ...
        + or at least, if add some sample test using them, in the test webapp ...


- etc ...

---------------


DONE
----

- for release 0.9.2 (my first release of the plugin):
    + update dependencies to Scala-2.9.2 ... ok
    + upgrade to Grails-2.0.4 and set requirements for Grails 2.0 or higher ... ok
    + cleanup unnecessary files in the plugin ... ok
    + create eclipse files even in the plugin ... ok
    + create test webapp (grails-scala-test) ... ok
    + in test webapp, use the plugin in inline mode, to test it ... ok
    + add license header in any file ... ok
    + add Groovy doc files ... ok
    + update SCALA_LICENSE, from Scala binary distribution ... ok

---------------
