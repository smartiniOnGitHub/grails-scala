grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        mavenCentral()
    }
    dependencies {
		def scalaVersion = '2.9.1'
        build "org.scala-lang:scala-compiler:$scalaVersion",
              "org.scala-lang:scala-library:$scalaVersion"
        compile "org.scala-lang:scala-compiler:$scalaVersion",
                "org.scala-lang:scala-library:$scalaVersion"
        compile('org.codehaus.groovy.modules:groovytransforms:0.2') { transitive = false }
    }
}
