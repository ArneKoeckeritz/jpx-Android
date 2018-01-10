/*
 * Java GPX Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
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
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmail.com)
 */
package io.jenetics.jpx;

import nl.jqno.equalsverifier.EqualsVerifier;

import java.io.IOException;
import java.util.Random;
import java.util.function.Supplier;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 */
@Test
public class LatitudeTest extends ObjectTester<Latitude> {

	@Override
	Supplier<Latitude> factory(final Random random) {
		return () -> Latitude.ofRadians(random.nextDouble());
	}

	@Test
	public void ofRadians() {
		Assert.assertEquals(
			Latitude.ofRadians(1),
			Latitude.ofDegrees(Math.toDegrees(1))
		);

		Assert.assertEquals(
			Latitude.ofRadians(1).toRadians(),
			Latitude.ofDegrees(Math.toDegrees(1)).toRadians()
		);
	}

	@Test
	public void ofDegrees() {
		Assert.assertEquals(
			Latitude.ofDegrees(1),
			Latitude.ofRadians(Math.toRadians(1))
		);

		Assert.assertEquals(
			Latitude.ofDegrees(1).toDegrees(),
			Latitude.ofRadians(Math.toRadians(1)).toDegrees()
		);
	}

	@Test
	public void equalsVerifier() {
		EqualsVerifier.forClass(Latitude.class).verify();
	}

	@Test
	public void serialize() throws IOException, ClassNotFoundException {
		final Object object = Latitude.ofRadians(new Random().nextDouble());
		Serialization.test(object);
	}

}
