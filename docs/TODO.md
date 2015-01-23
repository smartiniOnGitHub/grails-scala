grails-scala - TODO
===================

TODO
----

- for 2.10.5:
	- make it in a dedicated branch (2.10.x), if needed ...
	- set new plugin version and update Scala dependencies ...


- for other releases:
	- check if compile even /test/scala sources (if any, in this new folder) in the test environment (in plugin Events), and make some tests ...
	- check if publish other Scala info in ScalaService or in another (inside the Plugin) ...
	- run ScalaDoc on Scala sources and see what happens (and fix something, if needed) ...
	- test webapp: check if add a (controller and) page with text area to put some Scala code and run it ...
	- plugin: check if add a (controller and) page with text area to put some Scala code and run it, but with a dedicated flag in Config and by default disabled ...
	- check if add a command to trigger generation of documentation for Scala sources, using ScalaDoc ...
	- check if add Grails command scala-console, to get a Scala Console from the shell (if possible) ...
	- check if add Grails command scala-test-app, to run Scala tests (if given) ...
	- after update to Scala-2.11 (and its re-modularized structure), check if/what dependencies should be changes/updated ...
	- compile('org.codehaus.groovy.modules:groovytransforms:0.2') , verify if it's still needed now (and if there is a newer version) ...


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

- for release 0.9.3 (small improvements/cleanup):
    + add Thumbs.db in pluginExcludes ... ok

- for release 0.10.2:
	- update to Scala-2.10.2 (the same used by Akka-2.2.3) ... ok
	- removed the Typesafe Maven repository (no more needed) ... ok
	- update Groovy doc files ... ok

- for release 0.10.3 (small improvements/cleanup):
	- update to Scala-2.10.3 ... ok
	- update to Grails-2.2.x the plugin ... ok
	- update to Grails-2.2.x the test webapp (and resources:1.2.1, etc) ... ok

- update Groovy doc files and then publish in related web site at GitHUB ... ok
- verify if add even ScalaTest, ScalaCheck, or Specs in dependencies for tests ... ok, but only in test webapps (as a sample)
- test webapp: add controller to log/show in page even Scala version ... ok
- compile('org.codehaus.groovy.modules:groovytransforms:0.2') , verify if it's needed ... yes it is (at least now) ... ok

- for 2.10.4:
	- update to Scala-2.10.4 ... ok
    - add some Scala test class (normal, case, object, trait, abstract, BeanProperty annotations, etc) to ensure that Scala code is compiled ... ok
	- add a ScalaService to be able to get some info on Scala made available by the plugin, and call it in the test webapp ... ok
	- test webapp: use sample classes (Scala) defined in the plugin, but from Groovy (using the Java interoperability way) ... ok
	- add ScalaTest and make some tests using it ... ok, but only in the test webapp, and note that they aren't used in Grails test-app command ... ok
		- add sample tests both for a Spec and a Suite under unit tests folder (Example*.scala) ... ok
		- then copied both even under a test/scala folder but renamed in ExampleScala*.scala for simplifying checks on built files ... ok
    - verify at runtime, if it's enough to have only scala-runtime, and not scala-compiler ... no, the compiler is needed to build Scala sources ... ok
    - SCALA_LICENSE, verify if it's right to have it there (but in a subfolder), or if move in root in other license-related files ... ok
	- update Groovy doc files ... ok

- for 2.10.4.1 (maintenance release for 2.10.4):
	- stay to Scala-2.10.4 ... ok
	- add a test webapp made with Grails-2.4.x ... ok
	- merge changes from the older test webapp (based on Grails-2.2.5) to this new one (based on Grails-2.4.2) ... ok
	- make the plugin pass tests in the test-webapp24 ... ok
	- make the plugin pass tests in the original test-webapp ... ok
	- update (and then publish) Groovy doc files ... ok

- for 2.11.2:
	- set new plugin version and update Scala dependencies ... ok
	- update to the new (clarified) Scala-2.11.x license ... ok
	- make the plugin pass tests in all test-webapps, then run and ensure that all is good ... ok
	- update (and then publish) Groovy doc files ... ok

- for 2.11.4:
	- do all steps as usual ... ok

- for 2.11.5:
	- do all steps as usual ... ok


---------------
