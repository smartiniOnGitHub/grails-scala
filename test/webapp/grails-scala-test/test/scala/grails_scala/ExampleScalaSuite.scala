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

import org.scalatest.FunSuite

// import org.junit.runner.RunWith
// import org.scalatest.junit.JUnitRunner

/**
 * This class implements a sample ScalaTest test suite.
 *
 * When running ScalaTest, it will automatically
 * find this class and execute all of its tests.
 * Adding the `@RunWith` annotation enables the test suite to be executed
 * inside eclipse using the built-in JUnit test runner.
 *
 * You have two options for running this test suite:
 * 
 * - Start the sbt console and run the "test" command
 * - Right-click this file in eclipse and chose "Run As" - "JUnit Test"
 *
 * You can run it for example from the Scala Console, 
 * but remember to add the ScalaTest jar in the classpath before running it.
 * Then, inside the Console run it with:
 * {{{
 :load <path to scala source file>/ExampleScalaSuite.scala
 (new ExampleScalaSuite).execute()
 or
 (new ExampleScalaSuite).execute("test name")
 or
 (new ExampleScalaSuite).execute(testname = "test name")
 or other arguments, like color, configMap, durations, shortstacks, fullstacks, stats, ...
 * }{{
 */
// @RunWith(classOf[JUnitRunner])
class ExampleScalaSuite extends FunSuite {

	test("An empty List contain no elements") {
		println("test 1: ok")
		val list = List()
		// list should be Nil
		assert(list === Nil)
	}

	test("An empty List doesn't contain elements") {
		println("test 2: interceptFailure")
		val list = List()
		val ex = intercept[Exception] {
			// fail()  // force fail on this test
			assert(list !== Nil)  // manually set a failure condition for this test
		}
		// fail("force fail on this test")
		println(s"(expected) Generated exception (from failure) is $ex")
		assert(ex.getMessage === "List() equaled List()", "Error message")
	}

	/*
	test("Test Failure with Division by zero") {
		println("test 3: failure")
		val impossible = 1 / 0
	}
	 */

	test("Division by zero not possible") {
		println("test 4: ok")
		intercept[ArithmeticException] {
			val impossible = 1 / 0
		}
	}

	ignore("temporarily disabled test") {
		println("test 5: ignored")
		val sum = 1 + 1
		assert(sum === 2)
	}

}
