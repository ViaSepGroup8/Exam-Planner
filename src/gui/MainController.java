package gui;

import javafx.event.ActionEvent;

public class MainController extends Controller{

  @Override public void initData()
  {

  }

  @Override public void reset()
  {

  }

  public void manageRooms(ActionEvent actionEvent)
  {
    getViewHandler().openView("manageRooms");
  }

  public void manageStudents(ActionEvent actionEvent)
  {
    getViewHandler().openView("manageStudents");
  }

  public void viewSchedule(ActionEvent actionEvent)
  {
  }

  public void changePeriod(ActionEvent actionEvent)
  {
    getViewHandler().openView("changePeriod");
  }
}