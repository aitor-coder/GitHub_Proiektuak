package ehu.isad;

public class LizentziaModel {
    private String name;

    public LizentziaModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LizentziaModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
