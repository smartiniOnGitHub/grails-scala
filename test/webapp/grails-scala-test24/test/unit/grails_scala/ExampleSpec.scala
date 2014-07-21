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

import org.scalatest._

/**
 * This class implements a sample ScalaTest Specification test suite.
 *
 * You can run it for example from the Scala Console, 
 * but remember to add the ScalaTest jar in the classpath before running it.
 * Then, inside the Console run it with:
 * {{{
 :load <path to scala source file>/ExampleSpec.scala
 run(new ExampleSpec)
 * }{{
 */
class ExampleSpec extends FlatSpec with Matchers {

	"An empty List" should "contain no elements" in {
		println("test 1: ok")
		val list = List()
		// list should be Nil
		assert(list === Nil)
	}

	"An empty List" should "no contain elements" in {
		println("test 2: interceptFailure")
		try {
			val list = List()
			// fail()  // force fail on this test
			assert(list !== Nil)  // manually set a failure condition for this test
		}
		catch {
			case _: TestFailedException => // Expected, so continue
		}
	}

	/*
	"Test Failure with Division by zero" should "not be possible" in {
		println("test 3: failure")
		val impossible = 1 / 0
	}
	 */

	"Division by zero" should "not be possible" in {
		println("test 4: ok")
		intercept[ArithmeticException] {
			val impossible = 1 / 0
		}
	}

}
