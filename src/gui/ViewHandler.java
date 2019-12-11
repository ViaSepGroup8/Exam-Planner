package gui;

import examPlanner.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private Model model;

  private MainController mainController = null;
  private StudentsController studentsController = null;
  private RoomsController roomsController = null;
  private changePeriodController changePeriodController = null;

  public ViewHandler(Model model, Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    this.model = model;
    this.currentScene = new Scene(new Region());
  }

//  Parent root = FXMLLoader.load(getClass().getResource("/gui/manageStudents.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 500, 500));
//        primaryStage.show();


  public void openView(String id)
  {
    Region root = null;
    String title = "";

    switch (id)
    {
      case "manageStudents":
        studentsController = (StudentsController) loadView("/xml/manageStudents.fxml", studentsController);
        root = studentsController.getRoot();
        title = "Manage Students";break;

      case "mainView":
        mainController = (MainController) loadView("/xml/mainWindow.fxml", mainController);
        root = mainController.getRoot();
        title = "Exam planner";break;

      case "manageRooms":
        roomsController = (RoomsController) loadView("/xml/manageRooms.fxml", roomsController);
        root = roomsController.getRoot();
        title = "Exam planner";break;

      case "changePeriod":
        changePeriodController = (changePeriodController) loadView("/xml/changePeriod.fxml", changePeriodController);
        root = changePeriodController.getRoot();
        title = "Exam planner";break;
    }

    currentScene.setRoot(root);
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  private Controller loadView(String fxmlFile, Controller controller)
  {
    if (controller == null){
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        controller = loader.getController();
        controller.init(this, model, root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else {
      controller.reset();
    }
    return controller;
  }

  public void closeView(){
    primaryStage.close();
  }
}
