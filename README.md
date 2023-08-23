# StorageSystem


## Simple system allows you to save Lists of Objects or HashMaps to a JSON file!

```

public class PlayerStorage extends JsonStorage<UUID, Player> {

    public PlayerStorage(final File yourFile) {
        super(yourFile, Player.class);
    }

}

```

```
@Data (Makes Getters & Setters, using lombok)
public class Player {

    // @Id must be the type of the key you have specified previously
    @Id private final UUID uuid;
    private int level;

    public PrestigesPlayer(final UUID uuid) {
        this.uuid = uuid;
        this.prestige = 0L;
    }


}

```

```

final Storage storage = new PlayerStorage(file);

// adding a value
storage.add(new Player(uuid));

//removing it using the key
storage.remove(uuid);

storage.write()
```
