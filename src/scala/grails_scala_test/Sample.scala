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

package grails_scala_test

/** Sample class for some logic.
 *
 * Note that in the default (primary) constructor I set some immutable data structures,
 * used later in other methods as a sample.
 *
 * @constructor create a new person with a name and age.
 * @param list a sample (immutable) List instance
 * @param map  a sample (immutable) Map instance
 * @param map  a sample (immutable) String instance
 *
 * Sample usage:
 *
 * @example {{{
 * // define data structures to use
 * val list = List(0,1,2,3,4,5,6,7,8,9)
 * val string = "test string"
 * val map = Map("a" -> "First", "b" -> "Second", "c" -> "Third")
 * val n = 10
 *
 * // create instance of sample class
 * val s1 = new Sample(list, map, string)
 * val s2 = new Sample()
 *
 * // then call sample methods ...
 * s1.filterListByFlag(-1)
 * s1.filterListByFlag(0)
 * s1.filterListByFlag(1)
 * // s1.filterListByFlag(2)
 * s1.lengthByFlag("string")
 * s1.lengthByFlag("list")
 * s1.lengthByFlag("map")
 * // s1.lengthByFlag("other")
 * s1.filterListByClosure(n => n < 5)
 * s1.filterListByClosure(n => n >= 5)
 * s1.processListByClosure(n => if (n % 2 == 0) Some(n) else None)
 * s1.processListByClosure(n => if (s1.isEven(n)) Some(n) else None)
 * // s1.isPrime(1000000000)  // expected: false//> res9: Boolean = false
 * // s1.isPrime(1000000007)  // expected: true //> res10: Boolean = true
 * s1.filterListByPrimeNumbersOnly
 * s1.filterListByPrimeNumbersOnly()
 * s1.printContentsByFlag("string")
 * s1.printContentsByFlag("list")
 * s1.printContentsByFlag("map")
 * // s1.printContentsByFlag("other")
 * s1.valueOptionalFromMap("b")
 * s1.valueOptionalFromMap("x")
 * s1.valueFromMap("b")
 * s1.valueFromMap("x")
 * // etc ...
 * }}}
 *
 */
class Sample[T](val list: List[Int], val map: Map[String, String], val string: String) {

	/** A secondary constructor, with given some immutable data structures, for sample. */
	def this() {
		this(Nil, Map.empty, "")
	}

	/** Filter the immutable global list (defined in the constructor) depending on the flag value.
	 *
	 * @param f the flag, with value:
	 *        -1 for an empty List, 0 for even elements, 1 for odd elements, or any other value will generate an Exception
	 * @return a List containing filtered elements
	 */
	def filterListByFlag(f: Int): List[Int] = f match  {
		case -1 => Nil
		case 0 => list.filter(_ % 2 == 0)
		case 1 => list.filter(_ % 2 == 1)
		// case _ => throw new Exception("Unknown Flag")
		case v => throw new Exception(s"Unknown Flag: ${v}")
	}

	/** Filter the immutable global list (defined in the constructor) with a given closure (function).
	 *
	 * @param c the closure filter (from Int to Boolean)
	 * @return a List containing filtered elements
	 */
	def filterListByClosure(c: Int => Boolean): List[Int] = {
		list.filter(c)
	}

	/** Process the immutable global list (defined in the constructor) with a given closure (function).
	 *
	 * @param c the closure filter (a function that transforms an Int to an Option[Int])
	 * @return a List containing transformed elements
	 */
	def processListByClosure(c: Int => Option[Int]): List[Option[Int]] = {
		list.map(c)
	}

	/** Utility method that returns if the given number is even.
	 *
	 * @param n the integer number
	 * @return true if even, otherwise false
	 */
	def isEven(n: Int) = n % 2 == 0

	/** Utility method that returns if the given number is odd.
	 *
	 * @param n the integer number
	 * @return true if odd, otherwise false
	 */
	def isOdd(n: Int) = !(isEven(n))

	/** Returns the length of immutable global data structures (defined in the constructor) depending on the flag value.
	 *
	 * @param f the flag, with value:
	 *        "string", "list", "map" or an Exception will be thrown
	 * @return the number of elements in the related data structure
	 */
	def lengthByFlag(f: String): Int = {
		println(s"given flag: '$f' (choose between 'string', 'list', or 'map')")
		f match  {
			case "string" => println(s"string = $string"); string.size
			case "list"   => println(s"list   = $list");   list.size
			case "map"    => println(s"map    = $map");    map.size
			// case _ => throw new Exception("Unknown Flag")
			case v => throw new Exception(s"Unknown Flag: '${v}'")
		}
	}

	/** Print contents of immutable global data structures (defined in the constructor) depending on the flag value.
	 *
	 * @param f the flag, with value:
	 *        "string", "list", "map" or an Exception will be thrown
	 */
	def printContentsByFlag(f: String): Unit = {
		println(s"given flag: '$f' (choose between 'string', 'list', or 'map')")
		f match  {
			case "string" => println(s"string = $string")
			case "list"   => list.foreach(println)
			case "map"    => map.foreach(println)
			// case _ => throw new Exception("Unknown Flag")
			case v => throw new Exception(s"Unknown Flag: '${v}'")
		}
	}

	/** Optionally returns the value associated with a key, from the immutable global map (defined in the constructor).
	 *
	 * @param key the key to search
	 * @return the associated value (if any) wrapped in a Some(value), otherwise Nome will be returned
	 */
	def valueOptionalFromMap(key: String): Option[String] = {
		map.get(key)
	}

	/** Returns the value associated with a key (or a default one), from the immutable global map (defined in the constructor).
	 *
	 * @param key the key to search
	 * @return the associated value if found, otherwise a default one will be returned
	 */
	def valueFromMap(key: String): String = {
		map.getOrElse(key, "")
	}

	/** Utility method that returns the value contained in the given Option, or a default one.
	 *
	 * @param opt the Option
	 * @param default the default value
	 * @return the value (if existing), otherwise the default one will be returned
	 */
	def valueFromOption[T](opt: Option[T], default: T) = opt match {
		case Some(v) => v
		case None    => default
	}

	/** Utility method that put the given value in an Option.
	 *
	 * @param v the value to wrap
	 * @return the value, wrapped inside an Option
	 */
	def valueToOption[T](v: T) = if (v != null) Some(v) else None

	/** Utility method that wraps the given integer value (always present) in an Option.
	 *
	 * @param n the integer value to wrap
	 * @return the value, wrapped inside an Option
	 */
	def intToOption(n: Int) = Some(n)

	/** Utility method to tell if a number if prime.
	 *
	 * Note that this is a simple (and slow) implementation, just for sample.
	 *
	 * @param n the integer value to check
	 * @return true if is prime, otherwise false
	 */
	def isPrime(n: Int) = {
		require(n > -1, "Must be a positive number")
		
		if (n == 1) false
		else if (n % 2 == 0) false
		else (3 until n by 2).forall(d => n % d != 0)
	}

	/** Filter the immutable global list (defined in the constructor) to get only numbers that are prime.
	 *
	 * @return a List containing filtered elements
	 */
	def filterListByPrimeNumbersOnly(): List[Int] = {
		filterListByClosure(n => isPrime(n))
	}

}
