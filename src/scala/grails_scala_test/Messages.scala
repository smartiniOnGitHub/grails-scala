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

/** Sample base class */
// sealed abstract class Message[T]
sealed trait Message[T]

/** Sample case class for a String Message */
case class StringMessage(msg: String) extends Message[String]

/** Sample case class for a Binary (byte []) Message */
case class BinaryMessage(msg: Array[Byte]) extends Message[Array[Byte]]


/** Sample case class for a generic event Message */
case class EventMessage(event: Any, timestamp: Long = 0l) extends Message[Any]
