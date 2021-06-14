package ehu.isad.controller.db;




import ehu.isad.GithubModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ZerbitzuKudeatzailea {
    public ZerbitzuKudeatzailea(){}
    public List<GithubModel> eman_repo_guztiak()  {
        String sententzia="select full_name,description,license,open_issues from repos;";
        List<GithubModel> pertsona_zerrenda=new ArrayList<>();
        DBKudeatzaile db=DBKudeatzaile.getInstantzia();
        ResultSet erantzuna=db.execSQL(sententzia);
        GithubModel g = null;
        while (true){
            try {
                if (!erantzuna.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                g=new GithubModel(erantzuna.getString("full_name"),erantzuna.getString("description"),erantzuna.getString("license"),erantzuna.getInt("open_issues"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println(g.toString());
            pertsona_zerrenda.add(g);
        }
        return pertsona_zerrenda;
    }

    public void gorde_Datuak(GithubModel g){
        String sententzia="insert into repos values ('"+g.getIzen_osoa()+"','"+g.getLizentzia()+"','"+g.getDeskribapena()+"',"+g.getIssues()+")";
        DBKudeatzaile db=DBKudeatzaile.getInstantzia();
        ResultSet erantzuna=db.execSQL(sententzia);

    }

    public void egunaratu_issues(int issues, String izena){
        String sententzia="update repos set open_issues="+issues+" where full_name='"+izena+"';";
        DBKudeatzaile db=DBKudeatzaile.getInstantzia();
        ResultSet erantzuna=db.execSQL(sententzia);

    }


}
