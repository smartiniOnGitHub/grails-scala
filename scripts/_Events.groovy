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

import org.codehaus.gant.GantBinding

/*
 * Hooks an event handler to the CompileStart event to run the Scala compiler on Java and Scala sources.
 * It also updates source and class paths for the groovyc compiler with scala sources and libraries and optionally
 * copies Scala runtime libraries to the project's lib folder.
 *
 * Scala sources may be placed and combined in any way with Java sources in and across both /src/java and /src/scala.
 * All the Groovy sources including Grails-specific ones, like domain classes, controllers and such,
 * are directly visible inside the Scala sources, as well as all Groovy sources can use all Scala
 * or Java classes.
 */

/**
 * Hooks to the compile grails event
 */
eventCompileStart = {GantBinding compileBinding ->
	if (compilingScalaPlugin()) {
		return
	}

	ant.path(id: "scala.compile.classpath") {
		path(refid: "grails.compile.classpath")
	}

	ant.taskdef(name: 'generateGroovyStubsForScala', classname: 'org.codehaus.groovy.grails.cli.GenerateStubsTask')
	ant.taskdef(name: 'scalac', classname: 'scala.tools.ant.Scalac', classpathref: "scala.compile.classpath")

	try {
		def scalaSrcEncoding = buildConfig.scala?.src?.encoding ?: 'UTF-8'

		println "[scalaPlugin] Compiling Scala sources from plugin to $pluginClassesDirPath"
		ant.mkdir(dir: pluginClassesDirPath)
		ant.scalac(classpathref: "scala.compile.classpath",
		           destdir:       pluginClassesDirPath,
		           encoding:      scalaSrcEncoding) {
			pluginSettings.pluginInfosMap.each { name, pluginInfo ->
				File pluginPath = getPluginDirForName(pluginInfo.name).file
				def newFile = new File(pluginPath.path, "src/java")
				if (newFile.directory) {
					src(path: newFile.path)
				}
				newFile = new File(pluginPath.path, "src/scala")
				if (newFile.directory) {
					src(path: newFile.path)
				}
			}
		}

		println "[scalaPlugin] Compiling Scala sources to $classesDirPath"
		ant.mkdir(dir: classesDirPath)
		ant.scalac(classpathref: "scala.compile.classpath",
		           destdir:       classesDirPath,
		           encoding:      scalaSrcEncoding) {
			['java', 'scala'].each { String dir ->
				File src = new File(basedir, 'src/' + dir)
				if (src.exists()) {
					src(path: src)
				}
			}
		}
	} catch (e) {
		ant.fail(message: "Could not compile Scala sources: ${e.class.simpleName}: $e.message")
	}
}

/**
 * Detects whether we're compiling the scala plugin itself
 */
private boolean compilingScalaPlugin() {
	getPluginDirForName("scala") == null
}
