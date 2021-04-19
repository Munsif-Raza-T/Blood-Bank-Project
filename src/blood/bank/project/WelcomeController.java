/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood.bank.project;
import com.mysql.jdbc.Driver;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shahzaib saeed
 */
public class WelcomeController implements Initializable {

       

    /**
     * Initializes the controller class.
     */
     @FXML
    private PieChart piechart;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       int A_pos = 0 ;
       int A_neg = 0;
       int AB_pos = 0;
        int AB_neg = 0; 
        int B_pos = 0;
         int B_neg = 0;
         int O_pos = 0;
         int O_neg = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dbs", "root", "");
          Statement st = conn.createStatement();
          
          
          
          String A_pos_query = "SELECT count(Blood_group) from blood_donate where Blood_group='A+'";
      ResultSet rs1 = st.executeQuery(A_pos_query);
           while (rs1.next())
      {
        A_pos = rs1.getInt("count(Blood_group)");
        
      }
           
           
                
          String A_neg_query = "SELECT count(Blood_group) from blood_donate where Blood_group='A-'";
      ResultSet rs2 = st.executeQuery(A_neg_query);
           while (rs2.next())
      {
        A_neg = rs2.getInt("count(Blood_group)");
      
      }
         
           
           
                 String AB_pos_query = "SELECT count(Blood_group) from blood_donate where Blood_group='AB+'";
      ResultSet rs3 = st.executeQuery(AB_pos_query);
           while (rs3.next())
      {
        AB_pos = rs3.getInt("count(Blood_group)");
        
      }
           
           
           
           
           
                 String AB_neg_query = "SELECT count(Blood_group) from blood_donate where Blood_group='AB-'";
      ResultSet rs4 = st.executeQuery(AB_neg_query);
           while (rs4.next())
      {
        AB_neg = rs4.getInt("count(Blood_group)");
       
      }
           
           
           
           
           
           
                 String O_pos_query = "SELECT count(Blood_group) from blood_donate where Blood_group='O+'";
      ResultSet rs5 = st.executeQuery(O_pos_query);
           while (rs5.next())
      {
        O_pos = rs5.getInt("count(Blood_group)");
        
      }
           
           
           
           
           
           
           
                 String O_neg_query = "SELECT count(Blood_group) from blood_donate where Blood_group='O-'";
      ResultSet rs6 = st.executeQuery(O_neg_query);
           while (rs6.next())
      {
        O_neg = rs6.getInt("count(Blood_group)");
       
      }
           
           
           
           
           
           
         
           
                   String B_pos_query = "SELECT count(Blood_group) from blood_donate where Blood_group='B+'";
      ResultSet rs7 = st.executeQuery(B_pos_query);
           while (rs7.next())
      {
        B_pos = rs7.getInt("count(Blood_group)");
       
      }
           
           
           
                   String B_neg_query = "SELECT count(Blood_group) from blood_donate where Blood_group='B-'";
      ResultSet rs8 = st.executeQuery(B_neg_query);
           while (rs8.next())
      {
        B_neg = rs8.getInt("count(Blood_group)");
       
      }
           
           
           
     
            conn.close();
         
  
            }
           
            
         catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User_PanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
         ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("A+", A_pos),
                new PieChart.Data("B+", B_pos),
                new PieChart.Data("AB+",AB_pos),
                new PieChart.Data("O+", O_pos),
                new PieChart.Data("A-",  A_neg),
                new PieChart.Data("B-", B_neg),
                new PieChart.Data("AB-", AB_neg),
                new PieChart.Data("O-", O_neg));
         
         piechart.setData(pieChartData);
         piechart.setStartAngle(90);
    }


 


               
   

    
 
      
    @FXML
    private void User(ActionEvent event) throws IOException {
        Parent welcome_page= FXMLLoader.load(getClass().getResource("User_Panel.fxml"));
        Scene welcome_scene = new Scene(welcome_page);
        Stage welcome_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        welcome_stage.setScene(welcome_scene);
        welcome_stage.show();
        
    }

    @FXML
    private void Admin(ActionEvent event) throws IOException {
        Parent welcome_page= FXMLLoader.load(getClass().getResource("Admin_Panel.fxml"));
        Scene welcome_scene = new Scene(welcome_page);
        Stage welcome_stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        welcome_stage.setScene(welcome_scene);
        welcome_stage.show();
    }
    
}
