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

/** Sample case class for a Person.
 *
 * @constructor create a new person with a first name, a last name, age, and email
 * @param firstName the person's first name
 * @param lastName the person's last name
 * @param age the person's age in years 
 * @param email the person's email
 */
case class Person(firstName: String, lastName: String, age: Int, email: String) {
	require(age >= 0, "Age must be a positive number")
	
	/** Auxiliary constructor.
	 *
	 * @constructor Auxiliary constructor to create a new person with a first name, a last name, and some defaults
	 * @param firstName the person's first name
	 * @param lastName the person's last name
	 *
	 * Note that to use it you must create an instance but using the new operator
	 * (usually not needed with case classes).
	 */
	def this(firstName: String, lastName: String) {
		this(firstName, lastName, 0, "")
	}
}

/** Sample case class for a Person with an optional attribute.
  *
 * @constructor create a new person with a first name, a last name, and age, and a fiscal code (optional)
 * @param firstName the person's first name
 * @param lastName the person's last name
 * @param age the person's age in years 
 * @param fiscalCode the person's fiscal code (optional, if not given it will be None by default)
 */
case class PersonWithFiscalCode(firstName: String, lastName: String, age: Int, fiscalCode: Option[String] = None) {
	require(age >= 0, "Age must be a positive number")
}


/** Sample class for a Person with Java compatible getters and setters.
  *
 * @constructor create a new person with a first name, a last name, bornDate, and a gender
 * @param firstName the person's first name
 * @param lastName the person's last name
 * @param age the person's born date
 * @param male true if the person is a male, otherwise false
 *
 * Note that some attributes are values, while others are mutable, but just to try different combinations
 * of generated accessors methods, for simpler interoperability with Java.
 *
 * Sample usage:
 *
 * @example {{{
   // create instance of sample class
   val p = new PersonWithBeanProperties("FirstName", "LastName", new Date(), true)
   println(s"PersonWithBeanProperties instance p = ${p}")
  
   p.getFirstName  // FirstName
   p.setFirstName("NewFirstName")
   p.getFirstName  // NewFirstName
   p.getLastName   // LastName
   p.setLastName("NewLastName")
   p.getLastName   // NewLastName
   p.getBornDate   // get the date value
   // p.setBornDate(new Date())  // impossible, no method defined for this
   // p.getMale         // impossible, no method defined for this
   p.isMale             // true
   // p.setMale(false)  // impossible, no method defined for this
   // etc ...
 * }}}
 *
 */
// TODO: check why it doesn't work (compile error) when assigning one of BeanProperty annotations to an instance attribute ...
// import java.text.SimpleDateFormat
import java.util.Date
// import java.util.Locale
import scala.beans._
// import scala.reflect.BeanProperty
// import scala.reflect.BooleanBeanProperty
// @BeanInfo
class PersonWithBeanProperties(
	@BeanProperty var firstName: String, 
	@BeanProperty var lastName: String, 
    @BeanProperty val bornDate: Date, 
	@BooleanBeanProperty val male: Boolean) {

	// @BeanProperty var phoneNumber: String

	// val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
	// val timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

	// override def toString: String = "%s %s, born %s, male: %b".format(firstName, lastName, dateFormat.format(bornDate), male)
	override def toString: String = "%s %s, born %tF, male: %b".format(firstName, lastName, bornDate, male)
	// override def toString: String = "%s %s, born %3$tY-%3$tm-%3$td %3$tT, male: %b".format(firstName, lastName, bornDate, male)
}
