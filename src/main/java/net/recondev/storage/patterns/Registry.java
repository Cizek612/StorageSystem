package net.recondev.storage.patterns;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;

@SuppressWarnings("unused")
public interface Registry<K, V> {

    Map<K, V> getRegistry();

    default void register(@NotNull final K key, @NotNull final V value) {
        this.getRegistry().put(key, value);
    }

    @NotNull
    default Optional<V> get(@NotNull final K key) {
        return Optional.ofNullable(this.getRegistry().get(key));
    }

    default void unregister(@NotNull final K key) {
        this.getRegistry().remove(key);
    }

    default void iterate(@NotNull final BiConsumer<K, V> consumer) {

        for (final Map.Entry<K, V> entry : this.getRegistry().entrySet()) {
            consumer.accept(entry.getKey(), entry.getValue());
        }

    }

    default boolean containsKey(@NotNull final K key) {
        return this.getRegistry().containsKey(key);
    }

    default boolean containsValue(@NotNull final V value) {
        return this.getRegistry().containsValue(value);
    }

    default Set<K> keySet() {
        return this.getRegistry().keySet();
    }

    default Set<Map.Entry<K, V>> entrySet() {
        return this.getRegistry().entrySet();
    }

    default Collection<V> values() {
        return this.getRegistry().values();
    }

}