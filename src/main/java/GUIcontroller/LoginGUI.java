package GUIcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginGUI {

    @FXML
    Button loginButton;
    @FXML
    TextField namefield;
    @FXML
    Label welcomeLabel;
    @FXML
    Button registerBtn;
    @FXML
    PasswordField pass;

    Stage stage;

    public void login(ActionEvent e) {
        if (mainLogin()) {
            try {
                stage = ((Stage) (((Node) (e.getSource())).getScene()).getWindow());
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("mainMenu.fxml"));
                Parent root = loader.load();
                MainMenuGUI mainMenuGUI = loader.getController();
                mainMenuGUI.setName(namefield.getText());

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void loginByEnter(KeyEvent keyEvent) {


        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (mainLogin()) {
                try {
                    stage = ((Stage) (((Node) (keyEvent.getSource())).getScene()).getWindow());
                    //FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("mainMenu.fxml"));
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mainMenu.fxml"));

                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    mainLogin();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                namefield.clear();
            }
        }
    }

    public boolean mainLogin() {
        String username = namefield.getText();
        String password = pass.getText();
        if (username.equals("") || password.equals("")) {
            System.out.println("enter both username and password");
        } else {

            return true;
        }
        return false;
    }

    public void register(ActionEvent actionEvent) {

    }
}
