package Serialisation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialisation implements Serializable {
	
	static ObjectOutputStream oos = null;
	
	public static void init() {


		try {
			final FileOutputStream fichier = new FileOutputStream("mon_objet.ser");
			oos = new ObjectOutputStream(fichier);

			// ...
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void writeObj(Object obj) {

		try {
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

