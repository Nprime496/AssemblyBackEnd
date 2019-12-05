/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import assembly.filemanager.FileManager;
import assembly.filemanager.Parser;
import assembly.instruction.Instruction;
import assembly.interpreter.Interpreter;
import assembly.interpreter.InterpreterTwoAdress;
import assembly.memory.MyDesktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 *
 * @author _Nprime496_
 */
public class Controller implements Initializable {
    @FXML
    private MenuBar menuBar;
    @FXML
    private ChoiceBox<Interpreter> assemblychooser;
    @FXML
    private TextArea text;
    @FXML
    private TextArea console;
    //private final ReadAndInterpret interpreter=new ReadAndInterpret();
    private FileManager fileReader=new FileManager(new Parser());
    private Interpreter interpreter=new InterpreterTwoAdress();
    
    public void InterpretMemoryInstructions()
    {
        //int i=0;
        //MyDesktop.getMemory().clear();
        MyDesktop.getCounter().setAdressNextInstruction(Integer.toString(0));
        boolean allIsFine=true;
        console.setText("Output:");//vider la console
        System.out.println("Running!!");
        while(allIsFine)
        {
            try
            {
                allIsFine=interpreter.interpretInstruction((Instruction)MyDesktop.getMemory().retrieve(Integer.toString(Integer.parseInt(MyDesktop.getCounter().getAdressInstruction()))));
            }
            catch(Exception e)
            {
                MyDesktop.getMemory().retrieve(Integer.toString(Integer.parseInt(MyDesktop.getCounter().getAdressInstruction())));
                allIsFine=false;
            }
            System.out.println("LINE TO EXECUTE : "+Integer.toString(Integer.parseInt(MyDesktop.getCounter().getAdressInstruction())));
            Object val=MyDesktop.getBuffer();
            if(val!=null)
                console.setText(console.getText()+"\n"+(val));
            MyDesktop.setBuffer(null);   
        }
    }

    @FXML
    private void run(ActionEvent event) {
        MyDesktop.getMemory().clear();
        this.fileReader.loadInMemory(text.getText());
        this.InterpretMemoryInstructions();
        //print("A");
    }
    @FXML
    private void openFile(ActionEvent event) {
        FileChooser f=new FileChooser();
        
        f.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
                ,new FileChooser.ExtensionFilter("Pseudo-assembly", "*.pasm")
        );
        File selected=f.showOpenDialog((Stage)(menuBar.getScene().getWindow()));
        //print("A");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Interpreter[] lst={new InterpreterZeroAdress(),new InterpreterTwoAdress(),new InterpreterThreeAdress(),new InterpreterOneAdress()};
        Interpreter[] lst={new InterpreterTwoAdress()};
        assemblychooser.setItems(FXCollections.observableArrayList(lst));
        // TODO
    }    
    @FXML
    private void tutorial(ActionEvent event ) throws IOException
    {
        Stage stage=new Stage();
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("tutorial.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("About");
        stage.show();
    }
    @FXML
    private void about(ActionEvent event ) throws IOException
    {
        Stage stage=new Stage();
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("About");
        stage.show();
    }
}
