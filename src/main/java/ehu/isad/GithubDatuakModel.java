package ehu.isad;

public class GithubDatuakModel {
    private String full_name;
    private String description;
    private LizentziaModel license;
    private int open_issues;

    public GithubDatuakModel(String full_name, String description, LizentziaModel license, int open_issues) {
        this.full_name = full_name;
        this.description = description;
        this.license = license;
        this.open_issues = open_issues;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LizentziaModel getLicense() {
        return license;
    }

    public void setLicense(LizentziaModel license) {
        this.license = license;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public void setOpen_issues(int open_issues) {
        this.open_issues = open_issues;
    }

    @Override
    public String toString() {
        return "GithubDatuakModel{" +
                "full_name='" + full_name + '\'' +
                ", description='" + description + '\'' +
                ", license=" + license +
                ", open_issues=" + open_issues +
                '}';
    }
}
