package ehu.isad;

public class GithubModel {
    private String izen_osoa;
    private String deskribapena;
    private String lizentzia;
    private int issues;

    public GithubModel(String izen_osoa, String deskribapena, String lizentzia, int issues) {
        this.izen_osoa = izen_osoa;
        this.deskribapena = deskribapena;
        this.lizentzia = lizentzia;
        this.issues = issues;
    }

    public String getIzen_osoa() {
        return izen_osoa;
    }

    public void setIzen_osoa(String izen_osoa) {
        this.izen_osoa = izen_osoa;
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

    public String getLizentzia() {
        return lizentzia;
    }

    public void setLizentzia(String lizentzia) {
        this.lizentzia = lizentzia;
    }

    public int getIssues() {
        return issues;
    }

    public void setIssues(int issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "GithubModel{" +
                "izen_osoa='" + izen_osoa + '\'' +
                ", deskribapena='" + deskribapena + '\'' +
                ", lizentzia='" + lizentzia + '\'' +
                ", issues=" + issues +
                '}';
    }
}
