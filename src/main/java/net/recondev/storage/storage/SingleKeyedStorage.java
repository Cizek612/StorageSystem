package net.recondev.storage.storage;



import net.recondev.storage.patterns.Service;

import java.util.Collection;

@SuppressWarnings("unused")
public interface SingleKeyedStorage<T> {

    Service<T> service();

    void remove(final T value);

    void write();

    boolean contains(final T value);

    void add(final T value);

    void add(final Collection<T> collection);
}
