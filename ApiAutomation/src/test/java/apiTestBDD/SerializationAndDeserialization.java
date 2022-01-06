package apiTestBDD;

import java.io.*;

class Test implements Serializable {

    int i = 1, j = 2;

}

public class SerializationAndDeserialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Test t1 = new Test();

        //Serialization
        FileOutputStream fos = new FileOutputStream("text.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t1);

        //De-Serialization
        FileInputStream fis = new FileInputStream("text.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Test t2 = (Test)ois.readObject();

        System.out.println(t2.i);
        System.out.println(t2.j);


    }

}
