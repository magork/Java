package training;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

	public static void main(String[] args) throws IOException {
		 new Program().start();

	}

	private void start() throws IOException {
		System.out.println("JavaCommander 0.1");
		File workingDirectory = new File("");
		System.out.println(workingDirectory.getAbsolutePath());
		String commandText = readLine();
		if ("pwd".equals(commandText)){
			System.out.println(workingDirectory.getAbsolutePath());
			
			
		}
	}

	private String readLine() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		return bufferedReader.readLine();
	}
}
