package net.recondev.storage.storage;


import net.recondev.storage.patterns.Registry;

import java.util.Collection;

@SuppressWarnings("unused")
public interface Storage<K, V> {
    Registry<K, V> registry();

    V get(final K key);

    void remove(final K key);

    void write();

    void add(final V value);

    void add(final Collection<V> collection);

    boolean contains(final K key);

    Collection<V> values();

    Collection<K> keys();
}