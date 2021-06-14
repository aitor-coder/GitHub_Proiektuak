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
//
//    public void igo_puntuazioak(String p){
//        String sententzia="insert into puntuazioa values ('"+ DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+"','"+p+"')";
//        DBKudeatzaile db=DBKudeatzaile.getInstantzia();
//        ResultSet erantzuna=db.execSQL(sententzia);
//
//    }


}
