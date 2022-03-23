package GUIcontroller;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.html.HTMLImageElement;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class MainMenuGUI implements Initializable {

    @FXML
    Label toBeSet;
    @FXML
    ChoiceBox<String> choiceBox;
    @FXML
    Label date;
    @FXML
    DatePicker datePicker;

    @FXML
    ToggleButton toggleBtn;
    @FXML
    ColorPicker colorPicker;
    @FXML
    Pane filterPane;

    @FXML
    Button logoutBtn;

    @FXML
    Label name;

    PauseTransition timer = new PauseTransition(Duration.seconds(5));
    boolean color = false; //false : red , true: green

    public void toggle(ActionEvent actionEvent) {
        timer.playFromStart();
        if (!color){
            toggleBtn.setStyle("-fx-background-color: #00c200;");
            color = true;
        }

        else{
            toggleBtn.setStyle("-fx-background-color: #ff0000;");
            color = false;
        }

    }

    public void color(ActionEvent actionEvent) {
        timer.playFromStart();
        Color color = colorPicker.getValue();
        filterPane.setBackground(new Background(new BackgroundFill(color, null, null)));
    }

    public void logout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Careful!");
        alert.setHeaderText("login confirmation");
        alert.setContentText("Are you sure you want to logout?");
        if(alert.showAndWait().get() == ButtonType.OK){
            trueLogout();
        }


    }

    private void trueLogout() {
        timer.stop();
        try {
            Stage stage = ((Stage) (((name)).getScene()).getWindow());
            //FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("mainMenu.fxml"));
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void showDate(ActionEvent actionEvent) {
        timer.playFromStart();
        LocalDate myDate = datePicker.getValue();
        String niceDate = myDate.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd"));
        date.setText(niceDate);
    }

    public void setName(String text) {
        name.setText(text);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        timer.setOnFinished(event -> {
            event.consume();
            trueLogout();
        });


        toBeSet.setText("HELLLLO!");

        String[] choices = {"transcript","recommendation","exit"};

        choiceBox.getItems().addAll(choices);
        choiceBox.setOnAction(this::choose);
        timer.playFromStart();

    }

    public  void choose (ActionEvent e){
        String choice = choiceBox.getValue();
        name.setText(choice);
    }
}
