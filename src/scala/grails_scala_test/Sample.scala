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
 * s1.printContentsByFlag("string")
 * s1.printContentsByFlag("list")
 * s1.printContentsByFlag("map")
 * // s1.printContentsByFlag("other")
 * // etc ...
 * }}}
 *
 */
class Sample(val list: List[Int], val map: Map[String, String], val string: String) {

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
	
}
