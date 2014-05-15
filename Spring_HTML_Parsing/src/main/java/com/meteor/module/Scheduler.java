package com.meteor.module;

import org.apache.log4j.Logger;

public class Scheduler {
	
	static final Logger logger = Logger.getLogger( Scheduler.class );
	
	public void run(String data) {

		Store_Parsing_File
		.set_file_name(Name_gener.gener_name())
		.write_data(data);

	}	
	
}
