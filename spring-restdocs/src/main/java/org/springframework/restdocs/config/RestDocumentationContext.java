/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.restdocs.config;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.test.context.TestContext;

/**
 * {@code RestDocumentationContext} encapsulates the context in which the documentation of
 * a RESTful API is being performed.
 *
 * @author Andy Wilkinson
 */
public final class RestDocumentationContext {

	private final AtomicInteger stepCount = new AtomicInteger(0);

	private final TestContext testContext;

	/**
	 * Creates a new {@code RestDocumentationContext} backed by the given
	 * {@code testContext}.
	 * 
	 * @param testContext the test context
	 */
	public RestDocumentationContext(TestContext testContext) {
		this.testContext = testContext;
	}

	/**
	 * Returns the test {@link Method method} that is currently executing
	 *
	 * @return The test method
	 */
	public Method getTestMethod() {
		return this.testContext == null ? null : this.testContext.getTestMethod();
	}

	/**
	 * Gets and then increments the current step count
	 *
	 * @return The step count prior to it being incremented
	 */
	int getAndIncrementStepCount() {
		return this.stepCount.getAndIncrement();
	}

	/**
	 * Gets the current step count
	 *
	 * @return The current step count
	 */
	public int getStepCount() {
		return this.stepCount.get();
	}

}