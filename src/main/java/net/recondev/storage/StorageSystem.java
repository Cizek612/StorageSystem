package net.recondev.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;

public class StorageSystem {

    @Getter @Setter
    public static Gson gson;

    public StorageSystem(final Gson customGson) {

        if(customGson!=null) {
            gson = customGson;
            return;
        }

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();



    }


}
