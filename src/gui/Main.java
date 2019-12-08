package gui;

import examPlanner.Model;
import examPlanner.MyDate;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MyDate examinationStartDate = new MyDate(10,1,2020);
        MyDate examinationEndDate = new MyDate(14, 1, 2020);

        Model model = new Model(examinationStartDate, examinationEndDate);
        ViewHandler viewHandler = new ViewHandler(model, primaryStage);
        viewHandler.openView("mainView");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
