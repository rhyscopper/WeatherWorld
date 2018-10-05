/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WeatherWorld;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Rhys
 */
public class SettingsFXController implements Initializable {
    
    public Button CloseButton;
    public RadioButton london;
    public RadioButton newyork;
    public RadioButton paris;

        @FXML
    private void Donebutton(ActionEvent event) throws Exception {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("WeatherWorldFX.fxml"));
         Scene home_page_scene = new Scene(home_page_parent);
         Stage home_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         home_stage.setScene(home_page_scene);
         home_stage.setResizable(false);
         home_stage.show();
         
         if(london.isSelected())
         {
             System.out.println(london.getText());
         }
         if(newyork.isSelected())
         {
             System.out.println(newyork.getText());
         }
         if(paris.isSelected())
         {
             System.out.println(paris.getText());
         }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
