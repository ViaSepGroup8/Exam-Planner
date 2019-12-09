package gui;

//todo ! Implement reset method
//todo ! You cannon edit the ID by double clicking. I couldn't find a solution. Maybe someone else can.
//todo ! Multiple selection is disabled, because it throws an error.
//todo + Add validation for values.

import examPlanner.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentsController extends Controller
{
  //configure the table
  @FXML private TableView<Person> tableView;
  @FXML private TableColumn<Person, String> firstNameColumn;
  @FXML private TableColumn<Person, String> lastNameColumn;
  @FXML private TableColumn<Person, Integer> IDColumn;

  //configure other elements;
  @FXML private TextField IDTextField;
  @FXML private TextField firstNameTextField;
  @FXML private TextField lastNameTextField;

  @Override public void initialize(URL url, ResourceBundle resourceBundle)
  {
    System.out.println("INITIN");
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
    IDColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));

    tableView.setItems(getPeople());

    //This will allow the table to select multiple rows at once
    //tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    //Update the table to allow for the first and last name fields
    //to be editable
    tableView.setEditable(true);
    firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    IDColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
  }

  /**
   * This method will allow the user to double click on a cell and update
   * the first name of the person
   */
  public void changeFirstNameCellEvent(TableColumn.CellEditEvent edittedCell)
  {
    Person personSelected =  tableView.getSelectionModel().getSelectedItem();
    personSelected.setFirstName(edittedCell.getNewValue().toString());
  }

  public void changeLastNameCellEvent(TableColumn.CellEditEvent edittedCell)
  {
    Person personSelected =  tableView.getSelectionModel().getSelectedItem();
    personSelected.setLastName(edittedCell.getNewValue().toString());
  }

  public void changeIDCellEvent(TableColumn.CellEditEvent edittedCell)
  {
    Person personSelected =  tableView.getSelectionModel().getSelectedItem();
    personSelected.setId(Integer.parseInt(edittedCell.getNewValue().toString()));
  }


  /**
   * This method will remove the selected row(s) from the table
   */
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
    Person newPerson = new Person(
        Integer.parseInt(IDTextField.getText()),
        firstNameTextField.getText(),
        lastNameTextField.getText());

    //Get all the items from the table as a list, then add the new person to
    //the list
    tableView.getItems().add(newPerson);
  }

  /**
   * This method will return an ObservableList of People objects
   */
  public ObservableList<Person> getPeople()
  {
    ObservableList<Person> people = FXCollections.observableArrayList();
    people.add(new Person(123, "Lenka","Orincakova"));
    people.add(new Person(321, "Frank","Sinatra"));
    people.add(new Person(333, "Juan","Trebolle"));


    return people;
  }

  @Override public void reset()
  {
    //todo implement this method !!!
    System.out.println("resetting");
  }

  public void saveChanges(ActionEvent actionEvent)
  {
    //todo save everything to lists !!!
    getViewHandler().openView("mainView");
  }
}
