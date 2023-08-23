package net.recondev.storage.storage.patterns.service;

import lombok.Getter;
import net.recondev.storage.patterns.Service;

import java.util.ArrayList;
import java.util.List;

public class StorageService<T> implements Service<T> {
    @Getter  public final List<T> service = new ArrayList<>();
}
