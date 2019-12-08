package gui;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Controller{
  @Override public void reset()
  {

  }

  @Override public void initialize(URL url, ResourceBundle resourceBundle)
  {

  }

  public void manageStudents(ActionEvent actionEvent)
  {
    getViewHandler().openView("manageStudents");
  }
}
