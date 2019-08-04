package xyz.dreeks.trailz.trails;

public class Trail {

    private String uuid;
    private String name;
    private String createdBy;
    private String texture;
    
    public String getUUID() { 
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public String getCreator() {
        return this.createdBy;
    }

    public String getTexture() {
        return this.texture;
    }

    public Trail setUUID(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public Trail setName(String name) {
        this.name = name;
        return this;
    }

    public Trail setCreator(String creator) {
        this.createdBy = creator;
        return this;
    }

    public Trail setTexture(String texture) {
        this.texture = texture;
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }

}