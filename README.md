scala
=====

This is a Grails Plugin that enables the use of Scala code in Grails Web projects.


Distribution
============

grails-scala-<version>.zip for the plugin source distribution
  -- this is the recommended version, because the binary version of this plugin doesn't contain required jars


Dependencies
============

* a Servlet container to run the Web application, as required by the used version of Grails
* Scala (as specified in plugin descriptor) and related dependencies


Installation
============

In BuildConfig.groovy of the webapp, under the plugins section (at the end of the file) add:

    compile ":scala:<version>"

then run `grails compile` and the plugin should be installed. In case of errors during plugin installation, set log level to 'warn' in BuildConfig.groovy to get more information, and retry. Instead of the compile it's possible even to use runtime, and in that case simply running a Grails console should be enough.


Documentation
=============

See the Plugin documentation (sources under src/docs/), or the "live" version here: [grails-scala docs](http://smartiniongithub.github.com/grails-scala/)

Home Page for the project (and sources) on GitHUB: [grails-scala](https://github.com/smartiniOnGitHub/grails-scala/)


License
=======

Licensed under the terms of the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)
