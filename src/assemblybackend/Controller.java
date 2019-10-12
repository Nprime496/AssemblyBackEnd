/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblybackend;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


/**
 *
 * @author _Nprime496_
 */
public class Controller implements Initializable {
    @FXML
    private TextArea text;
    private ReadAndInterpret interpreter=new ReadAndInterpret();
    @FXML
    private void run(ActionEvent event) {
        interpreter.run(text.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
