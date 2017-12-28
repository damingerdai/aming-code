package org.aming.core.utils;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * @author daming
 * @version 2017/12/25.
 */
public class CommonsUtils {

    public static boolean isBlank(Object object) {
        if (Objects.isNull(object)) {
            return true;
        } else {
            return false;
        }
    }

    public static <T> boolean isEmpty(T[] t) {
        return Objects.isNull(t) || t.length <= 0;
    }

    public static <T> boolean isNotEmpty(T[] t) {
        return !isEmpty(t);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?,?> map) {
        return Objects.isNull(map) || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?,?> map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(String charSequence) {
        return Objects.isNull(charSequence) || charSequence.trim().isEmpty();
    }

    public static boolean isNotEmpty(String charSequence) {
        return !isNotEmpty(charSequence);
    }
}
