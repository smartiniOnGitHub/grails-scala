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

import scala.math._

/** Sample class for manage Complex numbers.
 *
 * @constructor create a new complex number.
 * @param re the real part
 * @param im the imaginary part
 *
 * Sample usage:
 *
 * @example {{{
   // create instance of sample class
   val c = new Complex(2, 5)
   println(s"complex c = ${c}")
   // etc ...
   val i = new Complex(0, 1)
 * }}}
 *
 * Note that in this implementation, internal variables are defined lazy, just for sample.
 *
 */
// TODO: complete the implementation (still many methods implementation is missing) ...
// TODO: in future verify if generalize to subclass of Number ...
case class Complex(re: Double, im: Double) {
	// require(im != 0)

	private lazy val mod = sqrt(pow(re, 2) + pow(im, 2))

	/** Auxiliary constructor. */
	def this(re: Double) = this(re, 0)

	def + (c: Complex) = new Complex(re + c.re, im + c.im)
	// def + (d: Double) = new Complex(re + d, im)

	def - (c: Complex) = this + new Complex(-re, -im)

	def * (c: Complex) = new Complex(re * c.re - im * c.im, im * c.re + re * c.im)

	def / (c: Complex) = {
		val powC = pow(c.re, 2) + pow(c.im, 2)
		require(powC != 0)
		new Complex((re * c.re + im * c.im) / powC, (im * c.re - re * c.im) / powC)
	}

	override def toString() = 
		this match {
			case Complex(re, 0) => re.toString
			case Complex(0, im) => im.toString + "*i"
			case _ => s"($re + $im *i)" 
	} 

	/** Check if it's equal to the given Complex. */
	def ==(other: Complex) = ???

	/** Check if it's not equal to the given Complex. */
	def !=(other: Complex) = ???  // = ! ==(other)

	/** Return a normalized (reduced to minimum values) version of the current complex. */
	def normalize() = ???

	/** Return an absolute version of the current complex (with all components positive). */
	def absolute() = ???

	/** Return the negative of the current complex (or multiplicated by -1). */
	def negative() = ???  // = new Complex(-re, im)

	/** Return the inverse of the current complex (or power -1). */
	def inverse() = ???

	/** Calculates a double value of division and a boolean flag that say is the result is exact, returning both as a tuple. */
	def valueAsDouble() = ???

}

/** Sample Companion Object.
 *
 * It defines implicit methods to transform an Int to a Complex.
 *
 * Sample usage:
 *
 * @example {{{
   // create instance of sample class
   val c = new Complex(1, 2)
   println(s"complex c = ${c}")
   val i = new Complex(0, 1)
   println(s"complex i = ${i}")

   import ComplexHelper._
   println(s"i = ${i}")
   // etc ...
 * }}}
 *
 */
object ComplexHelper {
	import scala.language.implicitConversions
	// import scala.language.postfixOps

	implicit def double2Complex(x: Double) = new Complex(x)

	/** Syntactic sugar for creating new Complex instances, without the need to use the new operator. */
	def apply(re: Double, im: Double) = new Complex(re, im)

	// / ** Syntactic sugar for deconstructing Complex instances in a tuple. * /
	// def unapply(c: Complex) = (c.re, c.im)

	// def zero: Complex = new Complex(0)
	lazy val zero: Complex = new Complex(0)
	lazy val unit: Complex = new Complex(1)
	lazy val i:    Complex = new Complex(0,1)

	/** Sample for a Not Implemented method. */
	def notImplemented(): Unit = ???

}
