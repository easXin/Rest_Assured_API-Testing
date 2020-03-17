package serializationAndDeserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable{
	int i = 10;
	int j = 20;
}
public class SerializationAndDeserialization {
	public static void main(String[] args) throws IOException, NotSerializableException{
		Test t1 = new Test();
		// Serialization
		FileOutputStream fos=new FileOutputStream("test.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		// convert object into file format
		oos.writeObject(t1); // in binary format
		// De-serilization
		FileInputStream fis = new FileInputStream("test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		// get object back from file 
		try {
			Test t2 = (Test)ois.readObject();
			System.out.println(t2.i + t2.j);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
