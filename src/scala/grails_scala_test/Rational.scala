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

/** Sample class for manage Rational numbers.
 *
 * @constructor create a new rational number.
 * @param numerator   the numerator
 * @param denominator the denominator
 *
 * Sample usage:
 *
 * @example {{{
   // create instance of sample class
   val r = new Rational(2, 5)
   println(s"rational r = ${r}")
   // etc ...
 * }}}
 *
 * Note that in this implementation, internal variables are defined lazy, just for sample.
 *
 */
class Rational(p: Int, q: Int) {
	require(q != 0)

	private lazy val g   = gcd(p.abs, q.abs)
	private lazy val num = p / g  // numerator,   normalized
	private lazy val den = q / g  // denominator, normalized


	/** Auxiliary constructor. */
	def this(p: Int) = this(p, 1)

	/** Calculates the Greatest Common Divisor. */
	private def gcd(p: Int, q: Int): Int = if (q == 0) p else gcd(q, p % q)
	
	override def toString = num + "/" + den

	def + (other: Rational) = new Rational(num * other.den + other.num * den, den * other.den)
	def + (i: Int) = new Rational(num + i * den, den)

	def - (other: Rational) = new Rational(num * other.den - other.num * den, den * other.den)
	def - (i: Int) = new Rational(num - i * den, den)

	def * (other: Rational) = new Rational(num * other.num, den * other.den)
	def * (i: Int) = new Rational(num * i, den)

	def / (other: Rational) = new Rational(num * other.den, den * other.num)
	def / (i: Int) = new Rational(num, den * i)

	/** Return a normalized (reduced to minimum values) version of the current rational. */
	def normalize() = if (den < 0) new Rational(-num, -den) else new Rational(num, den)

	/** Check if it's equal to the given Rational. */
	def ==(other: Rational) = num * other.den == den * other.num

	/** Check if it's not equal to the given Rational. */
	def !=(other: Rational) = ! ==(other)


// TODO: add ordering methods ...

}

/** Sample Companion Object.
 *
 * It defines implicit methods to transform an Int to a Rational.
 *
 * Sample usage:
 *
 * @example {{{
   // create instance of sample class
   val h = new Rational(1, 2)
   val r = new Rational(2, 5)
   println(s"rational h = ${h}")
   println(s"rational r = ${r}")
   import RationalHelper._
   println(s"2 * h = ${(2 * h)}")
   println(s"h * h = ${(h * h)}")
   println(s"2 * r = ${(2 * r)}")
   println(s"r * r = ${(r * r)}")
   val m12 = new Rational(1,-2)
   m12.normalize  // -1/2
   val m24 = new Rational(-2,-4)
   m24.normalize  // 1/2
   val h24 = new Rational(2, 4)
   h == h24  // true
   h != h24  // false
   h == m12  // false
   h != m12  // true
   h == m24  // true
   h != m24  // false
   // etc ...
 * }}}
 *
 */
object RationalHelper {
	implicit def int2Rational(x: Int) = new Rational(x)

// TODO: add implicit methods even for long2Rational, double2Rational ...
// TODO: check if add even rational2Int and rational2Double ...

	/** Calculates the Greatest Common Divisor. */
	def gcd(p: Int, q: Int): Int = if (q == 0) p else gcd(q, p % q)

	/** Calculates the Least Common Multiple. */
	def lcm(p: Int, q: Int): Int = (p.abs * q.abs) / gcd(p, q)

// TODO: generalize gcd, lcm methods for *Int ...

// TODO: add a valueAsInt method that returns a tuple vector (int value, int remind) ... and test with 10/3, 1/2, 2/5, etc ...
// TODO: add a valueAsDouble method that returns a tuple vector (Double value, Boolean exact) ... and test with 10/3, 1/2, 2/5, etc ...


	/** Sample for a Not Implemented method. */
	def notImplemented(): Unit = ???

}
