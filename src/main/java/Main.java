import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Group root = new Group();
//        Scene scene = new Scene(root,600,600, Color.PURPLE);
//
//        Text lable = new Text();
//        lable.setText("HELLLLLLLLLLLLLLLLLLLO");
//        lable.setX(50);
//        lable.setY(50);
//        //lable.setText("ggggg");
//
//        root.getChildren().add(lable);
//
//        Circle cir = new Circle();
//        cir.setRadius(50);
//        cir.setFill(Color.VIOLET);
//        cir.setCenterX(100);
//        cir.setCenterY(100);
//        root.getChildren().add(cir);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Careful!");
            alert.setHeaderText("login confirmation");
            alert.setContentText("Are you sure you want to logout?");
            if(alert.showAndWait().get() == ButtonType.OK){
                primaryStage.close();
            }

        });
        //Image icon = new Image(String.valueOf(getClass().getResource("Image/1284290.jpg")));
        System.out.println(getClass().getResource("Image/1284290.jpg"));
        Image icon = new Image("file:src/main/resources/Image/724477.jpg");
        primaryStage.getIcons().add(icon);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
