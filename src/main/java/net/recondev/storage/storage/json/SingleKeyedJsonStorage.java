package net.recondev.storage.storage.json;

import lombok.SneakyThrows;
import net.recondev.storage.StorageSystem;
import net.recondev.storage.patterns.Service;
import net.recondev.storage.storage.SingleKeyedStorage;
import net.recondev.storage.storage.patterns.service.StorageService;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Collection;

@SuppressWarnings("all")
public abstract class SingleKeyedJsonStorage<T> implements SingleKeyedStorage<T> {

    private final Service<T> service;
    private final File file;

    @SneakyThrows
    public SingleKeyedJsonStorage(final File file, final Class<T> type, final Service<T> service) {
        this.file = file;
        this.service = service;

        for(final T value : (T[]) StorageSystem.getGson().fromJson(new FileReader(this.file), Array.newInstance(type, 0).getClass())) {
            this.add(value);
        }
    }

    public SingleKeyedJsonStorage(final File file, final Class<T> type) {
        this(file, type, new StorageService());
    }

    @Override
    public Service<T> service() {
        return this.service;
    }
    @Override
    public boolean contains(final T value) {
        return service.contains(value);
    }
    @Override
    public void remove(final T value) {
        this.service.unregister(value);
    }
    @Override
    public void add(final T value) {
        this.service.register(value);
    }
    @Override
    public void add(final Collection<T> values) {
        values.forEach(this::add);
    }
}
