package org.tickets.germes.app.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.tickets.germes.app.exception.ConfigurationException;

/**
 * Contains reflection-related utility operations
 *
 */
public class ReflectionUtil {

	private ReflectionUtil() {
	}

	/**
	 * Creates an instance of the specified class.
	 */
	public static <T> T createInstance(Class<T> clz)throws ConfigurationException {
		try {
			return clz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}



	/**
	 * Returns list of fields with identical names irregardless of their
	 * modifiers
	 */
	public static List<String> findSimilarFields(Class<?> clz1, Class<?> clz2)
			throws ConfigurationException {
		try {
			Field[] fields = clz1.getDeclaredFields();
			List<String> targetFields = new ArrayList<>();
			for (Field field1 : clz2.getDeclaredFields()) {
				String fieldName = field1.getName();
				targetFields.add(fieldName);
			}
			List<String> list = Arrays.stream(fields).map(Field::getName).filter(targetFields::contains)
				.collect(Collectors.toList());
			return list;
		} catch (SecurityException ex) {
			throw new ConfigurationException(ex);
		}
	}

	/**
	 * Copy specified fields values from source to destination objects
	 */
	public static void copyFields(Object src, Object dest, List<String> fields)
			throws ConfigurationException {
		Checks.checkParameter(src != null, "Source object is not initialized");
		Checks.checkParameter(dest != null,
				"Destination object is not initialized");
		try {
			for (String field : fields) {
				Field fld = src.getClass().getDeclaredField(field);
				// Skip unknown fields
				if (fld != null) {
					fld.setAccessible(true);
					Object value = fld.get(src);

					Field fldDest = dest.getClass().getDeclaredField(field);

					if (fldDest != null) {
						fldDest.setAccessible(true);
						fldDest.set(dest, value);
					}
				}
			}
		} catch (SecurityException | ReflectiveOperationException
				| IllegalArgumentException ex) {
			throw new ConfigurationException(ex);
		}
	}
}
