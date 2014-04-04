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
 * // create instance of sample class
 * val r = new Rational(2, 5)
 * println(s"rational r = ${r}")
 * // etc ...
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

	/** Calculates the Greatest common divisor. */
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


// TODO: add a normalize method, to simplify the ratio (for what is possible) ...

}

/** Sample Companion Object.
 *
 * It defines implicit methods to transform an Int to a Rational.
 *
 * Sample usage:
 *
 * @example {{{
 * // create instance of sample class
 * val h = new Rational(1, 2)
 * val r = new Rational(2, 5)
 * println(s"rational h = ${h}")
 * println(s"rational r = ${r}")
 * import RationalHelper._
 * println(s"2 * h = ${(2 * h)}")
 * println(s"h * h = ${(h * h)}")
 * println(s"2 * r = ${(2 * r)}")
 * println(s"r * r = ${(r * r)}")
 * // etc ...
 * }}}
 *
 */
object RationalHelper {
	implicit def int2Rational(x: Int) = new Rational(x)

// TODO: add implicit methods even for long2Rational, double2Rational ...
// TODO: check if add even rational2Int and rational2Double ...

}
