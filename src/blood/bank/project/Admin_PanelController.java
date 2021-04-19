/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author shahzaib saeed
 */
public class Admin_PanelController implements Initializable {
    @FXML
    private TextField Admin_name;

    @FXML
    private Button Admin_loginbtn;

    @FXML
    private PasswordField Admin_pass;

    Connection conn ;
    PreparedStatement pst;
    ResultSet rs = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    void A_Login(ActionEvent event) {
        if(event.getSource()== Admin_loginbtn){
            if(login().equals("Success")){  
                try {
                    Parent u_panel = FXMLLoader.load(getClass().getResource("Admin_Login.fxml"));
                    Scene u_scene = new Scene(u_panel);
                    Stage u_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
                    u_stage.setScene(u_scene);
                    u_stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(User_PanelController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   
    }
    
    
    private String login(){
        String username= Admin_name.getText();
        String password= Admin_pass.getText();
        
        String sql = "SELECT *FROM admin WHERE  email = ? and Password= ?";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost/dbs", "root", "");
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs= pst.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "Enter correct username/password.");
                Admin_name.setText("");
                Admin_pass.setText("");
                System.out.println("Error");
                return "Error";
            }
            else{
                JOptionPane.showMessageDialog(null, "Welcome Dear Admin..");
                Admin_name.setText("");
                Admin_pass.setText("");
                System.out.println("Successfull Login");
                return "Success";
            }
            
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("Exception");
            Logger.getLogger(User_PanelController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            System.out.println("Exception");
            Logger.getLogger(User_PanelController.class.getName()).log(Level.SEVERE, null, ex);
            return "Exception";
        }
        return "";
    }
    
}
