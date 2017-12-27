package org.aming.core.utils;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author daming
 * @version 2017/12/10.
 */
public final class Assert {

    public static void notNull(Object object, String message) {
        if(Objects.isNull(object)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void notBlank(T t, String message, Predicate<T> action) {
         if(action.test(t))  {
             throw new IllegalArgumentException(message);
         }
    }

    public static void notBlank(String str, String message) {
        if(Objects.isNull(str) || str.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
