package gui;

import examPlanner.BinarySave;
import examPlanner.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Try loading model from file
        Model model = (Model) BinarySave.load("data.bin");

        //Create a new one if the model doesn't exist
        if(model == null){
            model = new Model();
            model.loadSampleData();
            model.save("data.bin");
        }

        ViewHandler viewHandler = new ViewHandler(model, primaryStage);
        viewHandler.openView("mainView");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
