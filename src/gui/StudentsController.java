package gui;

//todo ! Implement reset method
//todo ! You cannon edit the ID by double clicking. I couldn't find a solution. Maybe someone else can.
//todo ! Multiple selection is disabled, because it throws an error.
//todo + Add validation for values.

import examPlanner.Model;
import examPlanner.Person;
import examPlanner.Student;
import examPlanner.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;

public class StudentsController extends Controller
{
  //configure the table
  @FXML private TableView<Person> tableView;
  @FXML private TableColumn<Person, String> firstNameColumn;
  @FXML private TableColumn<Person, String> lastNameColumn;
  @FXML private TableColumn<Person, Integer> IDColumn;
  @FXML public TableColumn<Person, String> subjectsColumn;

  //configure other elements;
  @FXML private TextField IDTextField;
  @FXML private TextField firstNameTextField;
  @FXML private TextField lastNameTextField;
  @FXML public TextField subjectsTextField;
  @FXML public CheckBox isTeacherCB;

  @Override public void initData()
  {
    System.out.println("INIT STUDENT" + getModel() + getViewHandler() + getRoot() + getModel().getPeople());
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
    IDColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
    subjectsColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("subjects"));

    ObservableList<Person> people = FXCollections.observableArrayList();
    people.addAll(getModel().getPeople());
    tableView.setItems(people);

    //This will allow the table to select multiple rows at once
    //tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    //Update the table to allow for the first and last name fields
    //to be editable
    tableView.setEditable(true);
    firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    subjectsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    IDColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
  }

  @Override public void reset()
  {
    //todo implement this method !!!
    System.out.println("resetting");
  }

  public void removePerson()
  {
    ObservableList<Person> selectedRows, allPeople;
    allPeople = tableView.getItems();

    //this gives us the rows that were selected
    selectedRows = tableView.getSelectionModel().getSelectedItems();

    //loop over the selected rows and remove the Person objects from the table
    for (Person person: selectedRows)
    {
      allPeople.remove(person);
    }
  }


  /**
   * This method will create a new Person object and add it to the table
   */
  public void addPerson()
  {
    Person newPerson;

    if(isTeacherCB.isSelected()){
      newPerson = new Teacher(Integer.parseInt(IDTextField.getText()),
          firstNameTextField.getText(), lastNameTextField.getText(), subjectsTextField.getText());
    }else{
      newPerson = new Student(Integer.parseInt(IDTextField.getText()),
          firstNameTextField.getText(), lastNameTextField.getText(), subjectsTextField.getText());
    }
    //Get all the items from the table as a list, then add the new person to
    //the list
    tableView.getItems().add(newPerson);
  }


  public void saveChanges(ActionEvent actionEvent)
  {
    //todo save everything to lists !!!
    ArrayList<Person> people = new ArrayList<Person>();
    people.addAll(tableView.getItems());
    getModel().setPeople(people);
    getModel().save("data.bin");
    getViewHandler().openView("mainView");
  }

  public void editID(TableColumn.CellEditEvent<Person, Integer> personIntegerCellEditEvent)
  {
    Person personSelected = tableView.getSelectionModel().getSelectedItem();
    personSelected.setId(Integer.parseInt(personIntegerCellEditEvent.getNewValue().toString()));
  }

  public void editFirstName(TableColumn.CellEditEvent<Person, String> personStringCellEditEvent)
  {
    Person personSelected = tableView.getSelectionModel().getSelectedItem();
    personSelected.setFirstName(personStringCellEditEvent.getNewValue().toString());
  }

  public void editSubjects(TableColumn.CellEditEvent<Person, String> personStringCellEditEvent)
  {
    Person personSelected = tableView.getSelectionModel().getSelectedItem();
    personSelected.setSubjects(personStringCellEditEvent.getNewValue().toString());
  }


    public void editLastName(TableColumn.CellEditEvent<Person, String> personStringCellEditEvent)
  {
    Person personSelected = tableView.getSelectionModel().getSelectedItem();
    personSelected.setLastName(personStringCellEditEvent.getNewValue().toString());
  }
}
