package blood.bank.project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Saba saeed
 */
public class User_LoginController implements Initializable {
        
        
     @FXML
    private Label userecipient;
         @FXML
    private Label userdonor;

    @FXML
    private TextField D_name;

    @FXML
    private TextField D_phone;

    @FXML
    private TextField D_address;

    @FXML
    private CheckBox disease1;

    @FXML
    private CheckBox disease6;

    @FXML
    private CheckBox disease5;

    @FXML
    private CheckBox disease3;

    @FXML
    private CheckBox disease4;

    @FXML
    private CheckBox disease2;

    @FXML
    private Button Donor_requestbtn;

    @FXML
    private TextField D_age;

    @FXML
    private TextField D_weight;

    @FXML
    private RadioButton D_male;

    @FXML
    private RadioButton D_female;

    @FXML
    private TextField D_Blood;

    private String radiobtnlbl1;
    private String radiobtnlbl2;

    ObservableList<String> checkbox = FXCollections.observableArrayList();
    @FXML
    private ToggleGroup Gender;
    @FXML
    private TextField R_Name;
    @FXML
    private TextField R_phone;
    @FXML
    private TextField R_address;
    @FXML
    private TextField R_hospital;
    @FXML
    private TextField R_diagnosis;
    @FXML
    private RadioButton R_female;
    @FXML
    private ToggleGroup Gendar;
    @FXML
    private RadioButton R_male;
    @FXML
    private TextField R_age;
    @FXML
    private TextField R_blood;
    @FXML
    private Button R_send_request;

    @FXML
    void Donor_request(ActionEvent event) {

        String name = D_name.getText();
        String phone = D_phone.getText();
        String Blood_Group = D_Blood.getText();
        String address = D_address.getText();
        String male = D_male.getText();
        String female = D_female.getText();
        String age = D_age.getText();
        String weight = D_weight.getText();

        Connection conn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dbs", "root", "");

            pst = conn.prepareStatement("insert into blood_donate (Donor_Name ,Phone,Blood_group,Donor_Address,Donor_Gender,Donor_Age,Donor_Weight,Health_Disorder ) values(?,?,?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setString(3, Blood_Group);
            pst.setString(4, address);
            pst.setString(5, radiobtnlbl1);
            pst.setString(6, age);
            pst.setString(7, weight);
            pst.setString(8, checkbox.toString());

            int status = pst.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "Request Submitted..");
                D_name.setText("");
                D_phone.setText("");
                D_Blood.setText("");
                D_address.setText("");
                D_male.setText("");
                D_female.setText("");
                D_age.setText("");
                D_weight.setText("");
                disease1.setText("");
                disease2.setText("");
                disease3.setText("");
                disease4.setText("");
                disease5.setText("");
                disease6.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Failed..");
                D_name.setText("");
                D_phone.setText("");
                D_Blood.setText("");
                D_address.setText("");
                D_male.setText("");
                D_female.setText("");
                D_age.setText("");
                D_weight.setText("");
                disease1.setText("");
                disease2.setText("");
                disease3.setText("");
                disease4.setText("");
                disease5.setText("");
                disease6.setText("");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User_PanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

     
        
       
        
        
    }

    @FXML
    void d_1(ActionEvent event) {
        checkbox.add(disease1.getText());
        
    }

    @FXML
    void d_2(ActionEvent event) {
        checkbox.add(disease2.getText());
    }

    @FXML
    void d_3(ActionEvent event) {
        checkbox.add(disease3.getText());
    }

    @FXML
    void d_4(ActionEvent event) {
        checkbox.add(disease4.getText());
    }

    @FXML
    void d_5(ActionEvent event) {
        checkbox.add(disease5.getText());
    }

    @FXML
    void d_6(ActionEvent event) {
        checkbox.add(disease6.getText());
    }

    @FXML
    private void gendar(ActionEvent event) {
        if (D_male.isSelected()) {
            radiobtnlbl1 = D_male.getText();
        } else if (D_female.isSelected()) {
            radiobtnlbl1 = D_female.getText();
        }
    }

    @FXML
    private void gender(ActionEvent event) {
        if (D_male.isSelected()) {
            radiobtnlbl2 = R_male.getText();
        } else if (D_female.isSelected()) {
            radiobtnlbl2 = R_female.getText();
        }
    }

    @FXML
    private void Send_Request(ActionEvent event) throws ClassNotFoundException {
        String name = R_Name.getText();
        String phone = R_phone.getText();
        String Blood_Group = R_blood.getText();
        String address = R_address.getText();
        String male = R_male.getText();
        String female = R_female.getText();
        String age = R_age.getText();
        String diagnosis = R_diagnosis.getText();
        String hosp = R_hospital.getText();

        Connection conn;
        PreparedStatement pst;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dbs", "root", "");

            pst = conn.prepareStatement("insert into blood_request (Req_Name, Req_Phone,Req_BloodGroup,	Req_Address,Req_Gender,Req_Age,	Diagnosis,Req_Hospital) values(?,?,?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setString(3, Blood_Group);
            pst.setString(4, address);
            pst.setString(5, radiobtnlbl2);
            pst.setString(6, age);
            pst.setString(7, diagnosis);
            pst.setString(8, hosp);

            int status = pst.executeUpdate();
            if (status == 1) {
                JOptionPane.showMessageDialog(null, "Request Submitted..");
                R_Name.setText("");
                R_phone.setText("");
                R_blood.setText("");
                R_address.setText("");
                R_male.setText("");
                R_female.setText("");
                R_age.setText("");
                R_diagnosis.setText("");
                R_hospital.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Failed..");
                R_Name.setText("");
                R_phone.setText("");
                R_blood.setText("");
                R_address.setText("");
                R_male.setText("");
                R_female.setText("");
                R_age.setText("");
                R_diagnosis.setText("");
                R_hospital.setText("");
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User_PanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
        @FXML
    private void UserLogout(ActionEvent event) throws IOException {
        Parent welcome_page= FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        Scene welcome_scene = new Scene(welcome_page);
        Stage welcome_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        welcome_stage.setScene(welcome_scene);
        welcome_stage.show();
        
    }
}
