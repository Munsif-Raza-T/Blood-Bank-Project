package blood.bank.project;
import com.mysql.jdbc.Driver;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.println;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Saba saeed
 */
public class User_PanelController implements Initializable {
 

    @FXML
    private TextField Login_Name;

    @FXML
    private Button Loginbtn;

    @FXML
    private PasswordField Log_Pass;

    @FXML
    private Label lblError;

    @FXML
    private TextField Nametxt;
    @FXML
    private TextField UserNametxt;
    @FXML
    private PasswordField Passtxt;

    @FXML
    private PasswordField ConfirmPasstxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }

    Connection conn;
    PreparedStatement pst;
    ResultSet rs = null;

    @FXML
    private void RegisterBtn(ActionEvent event) {
        String name = Nametxt.getText();
        String Uname = UserNametxt.getText();
        String Passt = Passtxt.getText();
        String ConfirmPasst = ConfirmPasstxt.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dbs", "root", "");

            pst = conn.prepareStatement("insert into user(Name, UserName, Password, Confirm_Password) values(?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, Uname);
            pst.setString(3, Passt);
            pst.setString(4, ConfirmPasst);
            if (Passt.equals(ConfirmPasst)) {
                int status = pst.executeUpdate();
                if (status == 1) {
                    JOptionPane.showMessageDialog(null, "Registered..");
                    Nametxt.setText("");
                    UserNametxt.setText("");
                    Passtxt.setText("");
                    ConfirmPasstxt.setText("");
                    Nametxt.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed..");
                    Nametxt.setText("");
                    UserNametxt.setText("");
                    Passtxt.setText("");
                    ConfirmPasstxt.setText("");
                    Nametxt.requestFocus();
                }
            } else {
//               JOptionPane.showMessageDialog(null, "Check username or Password.."); 
                System.out.println("Check username or Password..");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User_PanelController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String login() {

        
       
        
        String username = Login_Name.getText();
        String password = Log_Pass.getText();

        String sql = "SELECT *FROM user WHERE username = ? and password= ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dbs", "root", "");
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Enter correct username/password.");
                Nametxt.setText("");
                UserNametxt.setText("");
                Passtxt.setText("");
                ConfirmPasstxt.setText("");
                Nametxt.requestFocus();
                return "Error";
            } else {
                JOptionPane.showMessageDialog(null, "Login Successfull..Redirecting...");
                Nametxt.setText("");
                UserNametxt.setText("");
                Passtxt.setText("");
                ConfirmPasstxt.setText("");
                Nametxt.requestFocus();
                System.out.println("Successfull Login");
                return "Success";
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User_PanelController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User_PanelController.class.getName()).log(Level.SEVERE, null, ex);
            return "Exception";
        }
         
        return "";

    }

    @FXML
    void U_Login(ActionEvent event) {
        if (event.getSource() == Loginbtn) {
            if (login().equals("Success")) {
                try {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();

                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("User_Login.fxml")));
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

}
