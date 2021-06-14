package ehu.isad.controller.ui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import ehu.isad.GithubModel;
import ehu.isad.Main;
import ehu.isad.controller.db.ZerbitzuKudeatzailea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainKud implements Initializable {
  private Main main;
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
  void konprobatu(ActionEvent event) {

  }



  @FXML
  public void handleClose(MouseEvent event) {
    System.exit(0);
  }
  private ObservableList<GithubModel> git_zerrenda= FXCollections.observableArrayList();

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ZerbitzuKudeatzailea zk=new ZerbitzuKudeatzailea();
    List<GithubModel> repoak=zk.eman_repo_guztiak();
    git_zerrenda.addAll(repoak);
    izen_zutabea.setCellValueFactory(new PropertyValueFactory<>("izen_osoa"));

    lizentzia_zutabea.setCellValueFactory(new PropertyValueFactory<>("lizentzia"));
    deskribapena_zutabea.setCellValueFactory(new PropertyValueFactory<>("deskribapena"));
    open_zutabea.setCellValueFactory(new PropertyValueFactory<>("issues"));

    taula.setItems(git_zerrenda);
  }
}
