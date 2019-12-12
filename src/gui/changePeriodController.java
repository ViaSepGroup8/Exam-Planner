package gui;

import examPlanner.MyDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class changePeriodController extends Controller
{
  @FXML public DatePicker examStartDate;
  @FXML public DatePicker examEndDate;

  @Override public void initData()
  {

  }

  @Override public void reset()
  {

  }

  public void saveChanges(ActionEvent actionEvent)
  {
    LocalDate start = examStartDate.getValue();
    LocalDate end = examEndDate.getValue();

    MyDate startDate = new MyDate(start.getDayOfMonth(),start.getMonthValue(),start.getYear());
    MyDate endDate = new MyDate(end.getDayOfMonth(), end.getMonthValue(), end.getYear());

    getModel().setExaminationStartDate(startDate);
    getModel().setExaminationEndDate(endDate);
    getViewHandler().openView("mainView");

    getModel().save("data.bin");
  }

  public void cancel(ActionEvent actionEvent)
  {
    getViewHandler().openView("mainView");
  }
}
