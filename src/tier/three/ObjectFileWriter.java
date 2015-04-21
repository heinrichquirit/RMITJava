package tier.three;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import tier.first.Methods;

public class ObjectFileWriter {
	
	private File f;
	private Object o;
	
	public ObjectFileWriter(File file, Object obj) {
		f = file;
		o = obj;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				Methods.print(f.getName() + " file cannot be created.");
			}
		}
	}
	
	public void save() {
		// Allows us to stream data to specified file
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f))) {
			os.writeObject(o);
			// Don't need to invoke close() as the new try-with-resources syntax handles it
		} catch (FileNotFoundException e) {
			Methods.print(f.getName() + " file cannot be found.");
		} catch (IOException e) {
			Methods.print("Cannot save to file " + f.getName());
		}
	}
	
}
