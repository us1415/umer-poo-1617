import java.util.HashMap;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;

/**
 * Classe responsável pelo save e load dos dados de utilização.
 */
public class IO
{
   public static void WriteHashMap(HashMap<String, ?> l, int ID) {

        // creating output stream variables

        FileOutputStream fileoutput = null;
        ObjectOutputStream objectoutput = null;

        try {

            // writing data

            if (ID == 1) fileoutput = new FileOutputStream("vehicles.txt");
            if (ID == 2) fileoutput = new FileOutputStream("drivers.txt");
            if (ID == 3) fileoutput = new FileOutputStream("clients.txt");

            // converting object to binary
            objectoutput = new ObjectOutputStream(fileoutput);

            // writing HashMap to stream

            objectoutput.writeObject(l);
            objectoutput.flush();
            objectoutput.close();
        }
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }

        System.out.println("HashMap " + ID + " saved");
    }


    public static void ReadHashMap(HashMap<String, ?> l, int ID) {

       // creating a new hash to import object from file
       HashMap newHash = new HashMap();

       // creating input stream variables
       FileInputStream fileinput = null;
       ObjectInputStream objectinput = null;

       try {

            // reading data

            if (ID == 1) fileinput = new FileInputStream("vehicles.txt");
            if (ID == 2) fileinput = new FileInputStream("drivers.txt");
            if (ID == 3) fileinput = new FileInputStream("clients.txt");

            // converting data to object
            objectinput = new ObjectInputStream(fileinput);

            // reading object's value and checking if input object is HashMap

            newHash = (HashMap<String, ?>) objectinput.readObject();
            if (!(newHash instanceof HashMap)){
                newHash = null;
                System.out.println("ERROR - input object is not Hashmap");
            }
            objectinput.close();
       }
       catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
       }
       catch (IOException ioex) {
            ioex.printStackTrace();
       }
       catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
       }


       l.putAll(newHash);

       }


      public static void WriteArrayList(ArrayList<Trip> l, int ID) {

        // creating output stream variables

        FileOutputStream fileoutput = null;
        ObjectOutputStream objectoutput = null;

        try {

            // writing data

            if (ID == 1) fileoutput = new FileOutputStream("tripscompleted.txt");
            if (ID == 2) fileoutput = new FileOutputStream("tripsunderway.txt");

            // converting object to binary
            objectoutput = new ObjectOutputStream(fileoutput);

            // writing ArrayList to stream

            objectoutput.writeObject(l);
            objectoutput.flush();
            objectoutput.close();
        }
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }

        System.out.println("ArrayList " + ID + " saved");
    }

    public static void ReadArrayList(ArrayList<Trip> l, int ID) {

       // creating new arraylist to import object from file
       ArrayList<Trip> newArrayList = new ArrayList<Trip>();

       // creating input stream variables

       FileInputStream fileinput = null;
       ObjectInputStream objectinput = null;

       try {
            // reading data

            if (ID == 1) fileinput = new FileInputStream("tripscompleted.txt");
            if (ID == 2) fileinput = new FileInputStream("tripsunderway.txt");

            // converting data to object
            objectinput = new ObjectInputStream(fileinput);

            // reading object's value and checking if input object is an Arraylist

            newArrayList = (ArrayList<Trip>) objectinput.readObject();
            if (!(newArrayList  instanceof ArrayList)){
                newArrayList = null;
                System.out.println("ERROR - input object is not an Arraylist");
            }
            objectinput.close();
       }
       catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
       }
       catch (IOException ioex) {
            ioex.printStackTrace();
       }
       catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
       }

       // copy new things to Arraylist

       newArrayList.removeAll(l);
       for(Trip t: newArrayList){
           l.add(t);
        }

   }

   public static void WriteArrayDeque(ArrayDeque<String> l) {

        // creating output stream variables

        FileOutputStream fileoutput = null;
        ObjectOutputStream objectoutput = null;

        try {

            // writing data
            fileoutput = new FileOutputStream("queue.txt");

            // converting object to binary
            objectoutput = new ObjectOutputStream(fileoutput);

            // writing HashMap to stream

            objectoutput.writeObject(l);
            objectoutput.flush();
            objectoutput.close();
        }
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }

        System.out.println("Queue saved");
    }


    public static void ReadArrayDeque(ArrayDeque<String> l) {

       // creating a new queue to import object from file
       ArrayDeque<String> newQueue = new ArrayDeque<>();

       // creating input stream variables
       FileInputStream fileinput = null;
       ObjectInputStream objectinput = null;

       try {

            // reading data
            fileinput = new FileInputStream("queue.txt");

            // converting data to object
            objectinput = new ObjectInputStream(fileinput);

            // reading object's value and checking if input object is HashMap

            newQueue = (ArrayDeque<String>) objectinput.readObject();
            if (!(newQueue instanceof ArrayDeque)){
                newQueue = null;
                System.out.println("ERROR - input object is not Queue");
            }
            objectinput.close();
       }
       catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
       }
       catch (IOException ioex) {
            ioex.printStackTrace();
       }
       catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
       }

       // copy new things to Queue

       newQueue.removeAll(l);
       for(String s: newQueue){
           l.add(s);
        }

   }


}