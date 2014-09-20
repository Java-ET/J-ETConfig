package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Config {
	private Map<String, Object> entries = new HashMap<String, Object>();
	private File cfgFile;

	public Config(String configPath) {
		cfgFile = new File(configPath);

		Scanner fileReader = null;
		try {
			fileReader = new Scanner(cfgFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Cache the config. More efficient than reading it over and over.
		while (fileReader.hasNextLine()) {
			String entry = fileReader.nextLine();
			entries.put(entry.split("=")[0], entry.split("=")[1]);
		}

		fileReader.close();
	}

	public int getInt(String key) {
		return Integer.valueOf((String) entries.get(key));
	}

	public boolean getBoolean(String key) {
		return Boolean.getBoolean((String) entries.get(key));
	}

	public String getString(String key) {
		return (String) entries.get(key);
	}

	public byte getByte(String key) {
		return Byte.valueOf((String) entries.get(key));
	}

	public void setEntry(String key, Object value) {
		entries.put(key, value);
	}

}
