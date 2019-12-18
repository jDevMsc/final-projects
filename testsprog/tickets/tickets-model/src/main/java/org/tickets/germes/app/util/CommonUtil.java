package org.tickets.germes.app.util;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CommonUtil {
    /**
     * Returns not-null unmodifiable copy of the source set
     */
    public static <T> Set<T> getSafeSet(Set<T> source) {
        return Collections.unmodifiableSet(source == null ? Collections.emptySet() : Collections.unmodifiableSet(source)); //protection(unmodifiableSet)
        // or		return Optional.ofNullable(stations).orElse(Collections.emptySet());
    }
    /**
     * Returns not-null unmodifiable copy of the source List
     */
    public static <T> List<T> getSafeList(List<T> source) {
        return Collections.unmodifiableList(Optional.ofNullable(source).orElse(Collections.emptyList()));
    }
    /**
     * Сonverts param into string  using all object state
     */
    public static String toString(Object param) {
        return ReflectionToStringBuilder.toString(param,ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
