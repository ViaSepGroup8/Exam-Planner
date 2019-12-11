package gui;
//Tutorial for tableView
//https://github.com/JaretWright/GUIDemo

import examPlanner.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;

public class RoomsController extends Controller
{
  @FXML public TableView<Room> tableView;
  @FXML public TableColumn<Room, String> roomNameColumn;
  @FXML public TableColumn<Room, Integer> capacityColumn;
  @FXML public TableColumn<Room, String> subjectsColumn;
  @FXML public TableColumn<Room, String> functionalitiesColumn;

  @FXML public TextField nameTextField;
  @FXML public TextField capacityTextField;
  @FXML public TextField subjectsTextField;
  @FXML public TextField functionalitiesTextField;

  @Override public void initData()
  {
    roomNameColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("name"));

    functionalitiesColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("functionalities"));
    capacityColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>("capacity"));
    subjectsColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("subjects"));

    ObservableList<Room> rooms = FXCollections.observableArrayList();
    rooms.addAll(getModel().getRooms());
    tableView.setItems(rooms);

    //This will allow the table to select multiple rows at once
    //tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    //Update the table to allow for the first and last name fields
    //to be editable
    tableView.setEditable(true);
    roomNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    functionalitiesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    subjectsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    capacityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
  }

  @Override public void reset() { }

  public void addRoom(ActionEvent actionEvent)
  {
    Room newRoom;

      newRoom = new Room(nameTextField.getText(), Integer.parseInt(capacityTextField.getText()), subjectsTextField.getText(), functionalitiesTextField.getText());
    tableView.getItems().add(newRoom);
  }

  public void removeRoom(ActionEvent actionEvent)
  {
    ObservableList<Room> selectedRows, allRooms;
    allRooms = tableView.getItems();

    //this gives us the rows that were selected
    selectedRows = tableView.getSelectionModel().getSelectedItems();

    //loop over the selected rows and remove the  objects from the table``
    for (Room room: selectedRows)
    {
      allRooms.remove(room);
    }
  }

  public void saveChanges(ActionEvent actionEvent)
  {
    //todo save everything to lists !!!
    ArrayList<Room> rooms = new ArrayList<Room>();
    rooms.addAll(tableView.getItems());
    getModel().setRooms(rooms);
    getModel().save("data.bin");
    getViewHandler().openView("mainView");
  }

  public void editCapacity(TableColumn.CellEditEvent<Room, Integer> roomIntegerCellEditEvent)
  {
    Room roomSelected = tableView.getSelectionModel().getSelectedItem();
    roomSelected.setCapacity(Integer.parseInt(roomIntegerCellEditEvent.getNewValue().toString()));
  }

  public void editName(TableColumn.CellEditEvent<Room, String> roomStringCellEditEvent)
  {
    Room roomSelected = tableView.getSelectionModel().getSelectedItem();
    roomSelected.setName(roomStringCellEditEvent.getNewValue().toString());
  }

  public void editSubjects(TableColumn.CellEditEvent<Room, String> roomStringCellEditEvent)
  {
    Room roomSelected = tableView.getSelectionModel().getSelectedItem();
    roomSelected.setSubjects(roomStringCellEditEvent.getNewValue().toString());
  }

  public void editFunctionalities(TableColumn.CellEditEvent<Room, String> roomStringCellEditEvent)
  {
    Room roomSelected = tableView.getSelectionModel().getSelectedItem();
    roomSelected.setFunctionalities(roomStringCellEditEvent.getNewValue().toString());
  }
}
