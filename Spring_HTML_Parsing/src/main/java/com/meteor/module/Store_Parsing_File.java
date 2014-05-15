package com.meteor.module;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Store_Parsing_File {

	private static final Store_Parsing_File STORE_PARSING_FILE = new Store_Parsing_File();
	
	private static String file_name = "";
	
	private Store_Parsing_File() {
		
	}
	
	public static Store_Parsing_File get() {
		return STORE_PARSING_FILE;
	}
	
	public static Store_Parsing_File set_file_name(String name) {
		file_name = name;
		
		return STORE_PARSING_FILE;
	}
	
	public void write_data(String data) {
		File file = new File(file_name);
		
		try {
			
			FileWriter fileWriter = new FileWriter(file,true);
			
			if( file.exists() ) {
				data +="\n";
				fileWriter.append(data);
			}else {
				file.createNewFile();
				fileWriter.write(data);	
			}
			
			
			
			fileWriter.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
}
