package dev.eder.padilla.cursogdgunam.recyclerview;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Model extends RealmObject{
    @PrimaryKey
    public String id;

    public String name;

    public String type;

    public PowerLevel powerLevel;

    public String imageUrl;

    public Model(String image, String id, String name, String type, PowerLevel powerLevel) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.powerLevel = powerLevel;
        this.imageUrl = image;
    }

    public Model() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public PowerLevel getPowerLevel() {
        return powerLevel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", powerLevel=" + powerLevel +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
