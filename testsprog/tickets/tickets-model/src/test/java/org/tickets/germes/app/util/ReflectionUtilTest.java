package org.tickets.germes.app.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.tickets.germes.app.exception.ConfigurationException;
import org.tickets.germes.app.exception.flow.InvalidParameterException;

/**
 * Verifies functionality
 */
public class ReflectionUtilTest {

	@Test
	public void createInstanceSuccess() {
		Object value = ReflectionUtil.createInstance(Source.class);
		assertNotNull(value);
	}

	@Test(expected = ConfigurationException.class)
	public void createInstanceFailure() {
		ReflectionUtil.createInstance(Restricted.class);
	}

	@Test
	public void findSimilarFieldsSuccess() {
		List<String> fields = ReflectionUtil.findSimilarFields(Source.class,
				Destination.class);
		assertNotNull(fields);
		assertTrue(fields.contains("value"));
	}

	@Test
	public void copyFieldsSuccess() {
		Source src = new Source();
		src.setValue(10);
		Destination dest = new Destination();
		List<String> fields = ReflectionUtil.findSimilarFields(src.getClass(), dest.getClass());

		ReflectionUtil.copyFields(src, dest, fields);
		assertEquals(dest.getValue(), 10);
	}

	@Test(expected= InvalidParameterException.class)
	public void copyFieldsDestinationNullFailure() {
		Source src = new Source();
		ReflectionUtil.copyFields(src, null, Collections.emptyList());
	}	
}

class Source {
	private int value;

	private String text;

	public void setValue(int value) {
		this.value = value;
	}
}

class Destination {
	private int value;

	public int getValue() {
		return value;
	}
}

class Restricted {
	public Restricted(int value) {

	}
}