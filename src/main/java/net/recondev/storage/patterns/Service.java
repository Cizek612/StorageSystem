package net.recondev.storage.patterns;


import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("unused")
public interface Service<V> {

    List<V> getService();

    default void register(@NotNull final V value) {
        this.getService().add(value);
    }

    default List<V> values() { return this.getService(); }

    default void unregister(@NotNull final V value) {
        this.getService().remove(value);
    }

    default boolean contains(@NotNull final V value) {
        return this.getService().contains(value);
    }

    default int getSize() { return this.getService().size(); }

    default void clear() {
        this.getService().clear();
    }


}