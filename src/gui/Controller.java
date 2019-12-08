package gui;

import examPlanner.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.Region;

public abstract class Controller implements Initializable
{
  private Region root;
  private Model model;
  private ViewHandler viewHandler;


  public void init(ViewHandler viewHandler, Model model, Region root){
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
  }

  abstract public void reset();

  public Region getRoot(){
    return root;
  }

  public Model getModel()
  {
    return model;
  }

  public ViewHandler getViewHandler()
  {
    return viewHandler;
  }
}
