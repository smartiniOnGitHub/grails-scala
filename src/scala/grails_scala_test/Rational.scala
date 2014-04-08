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
// TODO: in future verify if generalize to subclass of Number ...
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

	def < (other: Rational) = num * other.den < den * other.num
	def < (i: Int) = num < den * i

	def > (other: Rational) = num * other.den > den * other.num
	def > (i: Int) = num > den * i

	/** Check if it's equal to the given Rational. */
	def ==(other: Rational) = num * other.den == den * other.num

	/** Return a normalized (reduced to minimum values) version of the current rational. */
	def normalize() = if (den < 0) new Rational(-num, -den) else new Rational(num, den)

	/** Check if it's not equal to the given Rational. */
	def !=(other: Rational) = ! ==(other)

	/** Return the negative of the current rational (or multiplicated by -1). */
	def negative() = new Rational(-p, q)

	/** Return the inverse of the current rational (or power -1). */
	def inverse() = new Rational(q, p)

	/** Return the power of the current rational.
	 *
	 * Note that if redefine operator "**" or "^" for this operation, 
	 * to add parentheses to have the right precedence in expressions,
	 * this is the main reason to not re-defining them here (for more simplicity).
	 */
	def power(n: Int) = n match {
		case e if n < 0 => new Rational(Math.pow(den, e.abs).toInt, Math.pow(num, e.abs).toInt)
		case _          => new Rational(Math.pow(num, n).toInt, Math.pow(den, n).toInt)
	}

	/** Calculates the integer value of division, and the integer remainder, returning both as a tuple. */
	def valueAsInt() = (num / den, num % den)

// TODO: add a valueAsDouble method that returns a tuple vector (Double value, Boolean exact) ... and test with 10/3, 1/2, 2/5, etc ...

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
   h > r  // true
   h < r  // false

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
   h.power(0)   // 1/1
   h.power(1) == h  // true
   h.power(2)   // 1/4
   h.power(-2)  // 4/1
   r.power(2)   // 4/25
   r.power(-2)  // 25/4
   h.valueAsInt  // (0,1)

   val r58 = RationalHelper(5, 8)
   val r13 = RationalHelper(1, 3)
   val r42 = RationalHelper(4, 2)
   val r103 = RationalHelper(10, 3)
   r103.valueAsInt  // (3,1)
   // etc ...
 * }}}
 *
 */
object RationalHelper {
	import scala.language.implicitConversions
	// import scala.language.postfixOps

	implicit def int2Rational(x: Int) = new Rational(x)

	implicit def long2Rational(x: Long) = new Rational(x.toInt)

// TODO: add implicit methods even for double2Rational (scaling it by its decimals) ...
// TODO: check if add even rational2Int and rational2Double ...

	/** Syntactic sugar for creating new Rational instances, without the need to use the new operator. */
	def apply(p: Int, q: Int) = new Rational(p, q)

	// / ** Syntactic sugar for deconstructing Rational instances in a tuple. * /
	// def unapply(r: Rational) = (r.num, r.den)

	/** Calculates the Greatest Common Divisor. */
	def gcd(p: Int, q: Int): Int = if (q == 0) p else gcd(q, p % q)

	/** Calculates the Least Common Multiple. */
	def lcm(p: Int, q: Int): Int = (p.abs * q.abs) / gcd(p, q)

// TODO: generalize gcd, lcm methods for *Int ...

	// def zero: Rational = new Rational(0)
	lazy val zero: Rational = new Rational(0)
	lazy val unit: Rational = new Rational(1)

	/** Sample for a Not Implemented method. */
	def notImplemented(): Unit = ???

}
