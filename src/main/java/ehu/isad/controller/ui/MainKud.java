package ehu.isad.controller.ui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import ehu.isad.GithubDatuakModel;
import ehu.isad.GithubModel;
import ehu.isad.LizentziaModel;
import ehu.isad.Main;
import ehu.isad.controller.db.ZerbitzuKudeatzailea;
import ehu.isad.controller.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainKud implements Initializable {
  private final Main main;
  private final ObservableList<GithubModel> git_zerrenda= FXCollections.observableArrayList();
  @FXML
  private FontAwesomeIconView btnClose;

  @FXML
  private Label egoera_label;

  @FXML
  private TableView<GithubModel> taula;

  @FXML
  private TableColumn<GithubModel, String> izen_zutabea;

  @FXML
  private TableColumn<GithubModel, String> lizentzia_zutabea;

  @FXML
  private TableColumn<GithubModel, String> deskribapena_zutabea;

  @FXML
  private TableColumn<GithubModel, Integer> open_zutabea;

  @FXML
  private TextField txt_url;

  @FXML
  private Button btn_konprobatu;

  public MainKud(Main main) {
    this.main=main;
  }


  @FXML
  void konprobatu(ActionEvent event) throws IOException {
    egoera_label.setText("");
    System.out.println(txt_url.getText().split("/").length);

    if(txt_url.getText().split("/").length==2){
      if(!badagoZerrendan(txt_url.getText().trim())){
        Utils u=new Utils();
        ZerbitzuKudeatzailea zk=new ZerbitzuKudeatzailea();
        GithubDatuakModel g=u.readFromUrl(txt_url.getText());
        System.out.println(g.toString());
        if(g.getLicense()==null){
          System.out.println("Lizentzia gabe");
          g.setLicense(new LizentziaModel("Ez dauka lizentziarik."));
        }
        if(g.getDescription()==null){
          System.out.println("Deskribapen gabe.");
          g.setDescription("Ez dauka deskribapenik");
        }
        System.out.println(g);
        GithubModel eredua=new GithubModel(g.getFull_name(),g.getDescription(),g.getLicense().getName(),g.getOpen_issues());
        git_zerrenda.add(eredua);
        zk.gorde_Datuak(eredua);
        egoera_label.setText("Datu Basean ondo gorde da.");
      }
      else{
        egoera_label.setText("Zuk jarritako erabiltzailea: "+txt_url.getText()+". Datu Basean gordeta dago.");
      }

    }else{
      egoera_label.setText(txt_url.getText()+" ez da aurkitu");
    }


  }

  private Boolean badagoZerrendan(String izena){
    Boolean badago=false;
    for(GithubModel g: git_zerrenda){
      if(g.getIzen_osoa().equals(izena)){
        badago=true;
        break;
      }
    }
    return badago;
  }

  @FXML
  public void handleClose(MouseEvent event) {
    System.exit(0);
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {

    ZerbitzuKudeatzailea zk=new ZerbitzuKudeatzailea();
    List<GithubModel> repoak=zk.eman_repo_guztiak();
    git_zerrenda.addAll(repoak);
    taula.setEditable(true);
    izen_zutabea.setCellValueFactory(new PropertyValueFactory<>("izen_osoa"));
    lizentzia_zutabea.setCellValueFactory(new PropertyValueFactory<>("lizentzia"));
    deskribapena_zutabea.setCellValueFactory(new PropertyValueFactory<>("deskribapena"));
    open_zutabea.setCellValueFactory(new PropertyValueFactory<>("issues"));

    Callback<TableColumn<GithubModel, Integer>, TableCell<GithubModel, Integer>> defaultTextFieldCellFactory
            = TextFieldTableCell.forTableColumn(new IntegerStringConverter());
    open_zutabea.setCellFactory(col -> {
      TableCell<GithubModel, Integer> cell = defaultTextFieldCellFactory.call(col);

      cell.setOnMouseClicked(event -> {
          cell.setEditable(true);
      });

      return cell ;
    });


    open_zutabea.setOnEditCommit(
            t -> {
              t.getTableView().getItems().get(t.getTablePosition().getRow())
                      .setIssues(t.getNewValue());
              GithubModel g=t.getTableView().getItems().get(t.getTablePosition().getRow());
            System.out.println(g);
            zk.egunaratu_issues(g.getIssues(),g.getIzen_osoa());

            }
    );



    taula.setItems(git_zerrenda);
  }
}
