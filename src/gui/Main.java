package gui;

import examPlanner.BinarySave;
import examPlanner.Model;
import examPlanner.MyDate;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Try loading model from file
        Model model = (Model) BinarySave.load("data.bin");

        //Create a new one if the model doesn't exist
        if(model == null){
            //todo use setup.xml to specify the dates
            MyDate examinationStartDate = new MyDate(10,1,2020);
            MyDate examinationEndDate = new MyDate(14, 1, 2020);
            model = new Model(examinationStartDate, examinationEndDate);
            model.loadSampleData();
            model.save("data.bin");
        }

        model.loadSampleData();
        ViewHandler viewHandler = new ViewHandler(model, primaryStage);
        viewHandler.openView("mainView");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
