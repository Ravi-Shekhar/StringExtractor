package com.mps.util;

import static com.mps.util.constant.Constants.OUTPUT_FILE;
import static com.mps.util.constant.Constants.OUTPUT_VALUE;
import static com.mps.util.constant.Constants.SUCCESS_OUTPUT_MSG;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

	public static void writeOutputInFile(String fileContent) throws IOException {
		File file = new File(OUTPUT_FILE);
		file.createNewFile();
		
		writeOutputFile(fileContent, file);
		
		System.out.println(SUCCESS_OUTPUT_MSG + file.getAbsolutePath());		
		System.out.println(OUTPUT_VALUE + fileContent);
	}

	private static void writeOutputFile(String fileContent, File file)
			throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(fileContent);
		
		fileWriter.flush();
		fileWriter.close();
	}
}
