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
package grails_scala

import grails_scala.*
import grails_scala_test.*

/**
 * Sample Controller for displaying some Scala related info (using scalaService)
 */
class ScalaController {

	def scalaService

	def index() {
		log.info("index - params: $params")

		// get some info from the service (exposed by the plugin)
		def scalaVersion       = scalaService?.getScalaVersion()
		def scalaSuffixVersion = scalaService?.getScalaSuffixVersion()

		// test some Scala classes now, and put results in the output map for page:
		// remember that they are all available even in the Grails Console ...
		// Note that many of them are available only in dev env with plugin sources,
		// because they are excluded in the published version of the plugin.

		[
			scalaVersion: scalaVersion, scalaSuffixVersion: scalaSuffixVersion,  // defined and published by the plugin service
			scalaObjVersionMsg: ScalaInfo.scalaVersionMessage(), // scala object (singleton)
			scalaObjVersion: ScalaInfo.scalaVersion(), 
			scalaObjCompilerVersion: ScalaInfo.scalaCompilerVersio(),
			complex: new Complex(0,1),  // scala class defined in the test webapp
			rationalHalf: new Rational(1,2),
			person: new Person('First_Name', 'Last_Name', 20, 'email'),
			personWithBeanProperties: new PersonWithBeanProperties('First_Name', 'Last_Name', new Date(), true),
			// personFirstNameFromGetter: new PersonWithBeanProperties('First_Name', 'Last_Name', new Date(), true).getFirstName()
			sampleEmpty: new Sample(),
			// sampleEmptyListFiltered: new Sample().filterListByFlag(0),
			// sampleNotExistentWithDefault: new Sample().valueFromMap('not-existent'),
			screenPoint: new ScreenPoint(100, 200, null),
			stringMsg: new StringMessage('Hello from Groovy to a Scala case class extending a trait'),
			counter: Counter.next()
		]
	}


}
