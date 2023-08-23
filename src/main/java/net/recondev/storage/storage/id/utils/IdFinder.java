package net.recondev.storage.storage.id.utils;

import net.recondev.storage.storage.id.Id;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IdFinder {

    private static Method findIdMethod(final Class<?> type) {
        final List<Method> annotatedMethods = Arrays.stream(type.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Id.class))
                .peek(method -> method.setAccessible(true))
                .collect(Collectors.toList());

        if (!annotatedMethods.isEmpty()) {
            return annotatedMethods.get(0);
        }

        return null;
    }

    public static Object getId(final @NotNull Class<?> type, final Object object) {
        final List<AccessibleObject> annotatedAccessibles = new ArrayList<>();

        for (final Field field : type.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                field.setAccessible(true);
                annotatedAccessibles.add(field);
            }
        }

        if (!annotatedAccessibles.isEmpty()) {
            final Field idField = (Field) annotatedAccessibles.get(0);
            try {
                return idField.get(object);
            } catch (final IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        final Method idMethod = findIdMethod(type);
        if (idMethod != null) {
            try {
                return idMethod.invoke(object);
            } catch (final ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }

        if (type.getSuperclass() != null) {
            return getId(type.getSuperclass(), object);
        }

        throw new NullPointerException();
    }
}
