/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

grails.servlet.version = "3.0"
grails.project.work.dir = "target"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.plugin.location."scala" = "../../../"

def scalaSuffixVersion = '_2.11'

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        // runtime 'mysql:mysql-connector-java:5.1.31'
        // runtime 'org.postgresql:postgresql:9.3-1102-jdbc41'

        // add ScalaTest in test scope, just as a sample
		// note that this must be aligned (but by hand) with the Scala version published by the plugin ...
		test("org.scalatest:scalatest$scalaSuffixVersion:2.2.1")
		// test("org.scalactic:scalactic$scalaSuffixVersion:2.2.1")
	}

    plugins {
        // compile "org.grails.plugins:spring-security-core:1.2.7.4"
        // compile "org.grails.plugins:mongodb:2.0.1"

        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.11.1"
        runtime ":resources:1.2.8"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        build ":tomcat:$grailsVersion"
    }
}
