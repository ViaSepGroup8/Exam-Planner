package gui;

import javafx.event.ActionEvent;

public class changePeriodController extends Controller
{
  @Override public void initData()
  {

  }

  @Override public void reset()
  {

  }

  public void saveChanges(ActionEvent actionEvent)
  {
    getViewHandler().openView("mainView");
  }
}
