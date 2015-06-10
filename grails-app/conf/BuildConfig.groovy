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

grails.project.work.dir = "target"
// grails.project.docs.output.dir = 'docs/manual'

def scalaVersion = '2.11.6'
// def scalaSuffixVersion = '_2.11'  // ok, but not needed here, nor published to webapps ...
// to keep things simple, remember to update both values inside the related service ...

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenCentral()
		// jcenter()  // ok in Grails 2.4 or later, so add it manually for now ...
		mavenRepo("http://dl.bintray.com/smartiniontray/releases/")
    }

    dependencies {
        // String[] compilerAndLibrary = ['compiler', 'library'].collect { "org.scala-lang:scala-$it:$scalaVersion" }
        // build  (compilerAndLibrary)
        // compile(compilerAndLibrary)
        build  ("org.scala-lang:scala-compiler:$scalaVersion", "org.scala-lang:scala-library:$scalaVersion")
        compile("org.scala-lang:scala-compiler:$scalaVersion", "org.scala-lang:scala-library:$scalaVersion")
        compile("org.codehaus.groovy.modules:groovytransforms:0.3") { transitive = false }
    }

    plugins {
        build ':release:2.2.1', ':rest-client-builder:1.0.3', {
            export = false
        }
    }
}

grails.project.repos.default = "grailsCentral"
