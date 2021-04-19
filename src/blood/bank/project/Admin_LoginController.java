package blood.bank.project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shahzaib saeed
 */
public class Admin_LoginController implements Initializable {

    @FXML
    private TableView<Donor> D_table;

    @FXML
    private TableColumn<Donor, String> D_Name;

    @FXML
    private TableColumn<Donor, String> D_phone;

    @FXML
    private TableColumn<Donor, String> D_blood;

    @FXML
    private TableColumn<Donor, String> D_address;

    @FXML
    private TableColumn<Donor, String> D_gender;

    @FXML
    private TableColumn<Donor, String> D_age;

    @FXML
    private TableColumn<Donor, String> D_weight;

    @FXML
    private TableColumn<Donor, String> D_health;

    ObservableList<Donor> dlist = FXCollections.observableArrayList();
    ObservableList<Acceptor> Alist = FXCollections.observableArrayList();
    @FXML
    private TableView<Acceptor> Acceptor_Table;
    @FXML
    private TableColumn<Acceptor, String> A_Name;
    @FXML
    private TableColumn<Acceptor, String> A_phone;
    @FXML
    private TableColumn<Acceptor, String> A_blood;
    @FXML
    private TableColumn<Acceptor, String> A_gender;
    @FXML
    private TableColumn<Acceptor, String> A_address;
    @FXML
    private TableColumn<Acceptor, String> A_age;
    @FXML
    private TableColumn<Acceptor, String> A_hospital;
    @FXML
    private TableColumn<Acceptor, String> A_diagnosis;
    
        @FXML
    private Label donors;
        
    @FXML
    private Label recipients;
   
        
        

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT *FROM blood_donate");
            while (rs.next()) {
                dlist.add(new Donor(rs.getString("Donor_Name"), rs.getString("Phone"),
                        rs.getString("Blood_group"), rs.getString("Donor_Address"),
                        rs.getString("Donor_Gender"), rs.getString("Donor_Age"),
                        rs.getString("Donor_Weight"), rs.getString("Health_Disorder")));
            }
            D_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            D_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            D_blood.setCellValueFactory(new PropertyValueFactory<>("Blood"));
            D_address.setCellValueFactory(new PropertyValueFactory<>("address"));
            D_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            D_age.setCellValueFactory(new PropertyValueFactory<>("age"));
            D_weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
            D_health.setCellValueFactory(new PropertyValueFactory<>("Health_Disorder"));

            D_table.setItems(dlist);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_LoginController.class.getName()).log(Level.SEVERE, "Donor", ex);
        }

        try {
            // TODO
            Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT *FROM blood_request");
            while (rs.next()) {
                Alist.add(new Acceptor(rs.getString("Req_Name"), rs.getString("Req_Phone"),
                        rs.getString("Req_BloodGroup"), rs.getString("Req_Address"),
                        rs.getString("Req_Gender"), rs.getString("Req_Age"),
                        rs.getString("Diagnosis"), rs.getString("Req_Hospital")));
            }
            A_Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            A_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            A_blood.setCellValueFactory(new PropertyValueFactory<>("Blood"));
            A_address.setCellValueFactory(new PropertyValueFactory<>("address"));
            A_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            A_age.setCellValueFactory(new PropertyValueFactory<>("age"));
            A_diagnosis.setCellValueFactory(new PropertyValueFactory<>("disese"));
            A_hospital.setCellValueFactory(new PropertyValueFactory<>("hospital"));

            Acceptor_Table.setItems(Alist);

        } catch (SQLException ex) {
            Logger.getLogger(Admin_LoginController.class.getName()).log(Level.SEVERE, "Acceptor", ex);
        }
        
         Connection con;
         String donors_no = null;
         String recipients_no = null;
        try {
            con = DBConnector.getConnection();
             ResultSet rs1 = con.createStatement().executeQuery("SELECT count(Donor_Name) from blood_donate");
             while(rs1.next()){
             donors_no = rs1.getString("count(Donor_Name)");
             
                            
             }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            con = DBConnector.getConnection();
             ResultSet rs2 = con.createStatement().executeQuery("SELECT count(Req_Name) from blood_request");
             while(rs2.next()){
             recipients_no = rs2.getString("count(Req_Name)");
             
                            
             }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

       donors.setText(donors_no);
       recipients.setText(recipients_no);
       
          
       
        
             
         
     
        
    }
              @FXML
    private void AdminLogout(ActionEvent event) {
        try {

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Welcome.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
