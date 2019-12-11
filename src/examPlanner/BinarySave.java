package examPlanner;

import java.io.*;

public interface BinarySave extends Serializable
{
  default void save(String filename){
    try
    {
      FileOutputStream fos = new FileOutputStream(filename);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(this);
      oos.flush();
      oos.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Warning cannot find save file.");
    }
    catch (IOException e)
    {
      System.out.println("Error save file is not accessible");
    }
  }

  static Object load(String filename){
    Object obj = null;
    try
    {
      File file = new File(filename);
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream ois = new ObjectInputStream(fis);
      obj = ois.readObject();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Warning cannot find save file.");
    }
    catch (IOException e)
    {
      System.out.println("Error save file is not accessible");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Error cannot find Class of the save file");
    }
    finally
    {
      return obj;
    }
  }
}
