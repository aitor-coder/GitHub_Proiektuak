package ehu.isad;

public class LizentziaModel {
    private String name;

    public LizentziaModel(String Name){
            this.name = Name;
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
