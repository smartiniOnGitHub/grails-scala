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

import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

/**
 * Service for get some info on the Scala published by the plugin in the webapp
 * <br/>
 * It has default scope (singleton), but in a not transactional way.
 */
class ScalaService
{
	static transactional = false  // transactional behaviour not needed here ...

	/**
	 * Initialization, automatically called after creation, via the PostConstruct annotation.
	 */
	@PostConstruct
	void init() {
		log.info "initializing Scala service: start ..."

		// initialize variables ...

		log.info "initializing Scala service: done."
	}

	/**
	 * Destroy, automatically called before destroy, via the PreDestroy annotation.
	 */
	@PreDestroy
	void destroy() {
		log.info "destroying Scala service: start shutdown ..."

		log.info "destroying Scala service: done."
	}


	/**
	 * Returns the Scala version used and published by the plugin.
	 *
	 * @return the Scala version
	 */
	String getScalaVersion() {
		// return BuildConfig.scalaVersion  // not possible in a plugin
		"2.10.5"  // to keep it simple, duplicate the value here ...
	}

	/**
	 * Returns the Scala suffix with the major version (normally used by build tools).
	 *
	 * @return the Scala suffix version
	 */
	String getScalaSuffixVersion() {
		// return BuildConfig.scalaSuffixVersion  // not possible in a plugin
		"_2.10"  // to keep it simple, duplicate the value here ...
	}
}
