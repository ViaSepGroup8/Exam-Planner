package gui;

import examPlanner.Exam;
import examPlanner.MyDate;
import examPlanner.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController extends Controller{

  //Table
  @FXML public TableView<Exam> examTable;
  @FXML public TableColumn<Exam, String> subjectColumn;
  @FXML public TableColumn<Exam, Room> RoomColumn;
  @FXML public TableColumn<Exam, MyDate> DateColumn;
  @FXML public TableColumn<Exam, String> TeacherColumn;
  @FXML public TableColumn<Exam, String> typeColumn;
  @FXML public TableColumn<Exam, String> formatColumn;
  @FXML public TableColumn<Exam, String> ectsColumn;
  @FXML public TableColumn<Exam, String> examinersColumn;

  //ListViews
  @FXML public ListView subjectList;
  @FXML public ListView roomList;
  @FXML public ListView dateList;

  //TextFields
  @FXML public TextField teacherTextField;
  @FXML public TextField typeTextField;
  @FXML public TextField formatTextField;
  @FXML public TextField ectsTextField;
  @FXML public TextField examinersTextField;

  @Override public void initData()
  {
    subjectColumn.setCellValueFactory(new PropertyValueFactory<Exam, String>("subject"));
    RoomColumn.setCellValueFactory(new PropertyValueFactory<Exam, Room>("room"));
    DateColumn.setCellValueFactory(new PropertyValueFactory<Exam, MyDate>("date"));

    TeacherColumn.setCellValueFactory(new PropertyValueFactory<Exam, String>("teacher"));
    typeColumn.setCellValueFactory(new PropertyValueFactory<Exam, String>("type"));
    formatColumn.setCellValueFactory(new PropertyValueFactory<Exam, String>("format"));
    ectsColumn.setCellValueFactory(new PropertyValueFactory<Exam, String>("ects"));
    examinersColumn.setCellValueFactory(new PropertyValueFactory<Exam, String>("examiners"));
    //todo for other columns

    ObservableList<Exam> exams = FXCollections.observableArrayList();
    exams.addAll(getModel().getExams());
    examTable.setItems(exams);

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

  public void deleteExam(ActionEvent actionEvent)
  {
  }

  public void createExam(ActionEvent actionEvent)
  {
    Exam newExam;
    newExam = new Exam(
        new MyDate(1,1,1),
        "TODO",
        new Room("toDoRoom",2,"rwd", "hdmi"),
        "Michal",
        typeTextField.getText(),
        formatTextField.getText(),
        ectsTextField.getText(),
        examinersTextField.getText());

    examTable.getItems().add(newExam);
  }

  public void saveChanges(ActionEvent actionEvent)
  {
  }

  public void upload(ActionEvent actionEvent)
  {
  }

  public void exit(ActionEvent actionEvent)
  {
  }
}