# StorageSystem


## Simple system allows you to save Lists of Objects or Maps to a JSON file!

### The Storage Class

```java

public class PlayerStorage extends JsonStorage<UUID, Player> {

    public PlayerStorage(final File yourFile) {
        super(yourFile, Player.class);
    }

}

```

### Object Class Example

```java
@Data 
public class Player {

    // @Id must be the type of the key you have specified previously
    @Id private final UUID uuid;
    private int level;

    public Player(final UUID uuid) {
        this.uuid = uuid;
        this.level = 0;
    }


}

```

### Adding, Removing, Writing

```java

final Storage storage = new PlayerStorage(file);

final UUID uuid = UUID.randomUUID();

// adding a value
storage.add(new Player(uuid));

//removing it using the key
storage.remove(uuid);

storage.write()
```

## Note: There is also SingleKeyedStorage & SingleKeyedJsonStorage which can be used for Lists
