
import java.util.Scanner;
import java.util.HashMap;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.IOException;
import java.io.FileWriter;


public class CharacterCounter {

	public static void main (String[] args) {

		String phrase = "";
		String outputFile = "out.txt";

		if (args.length >= 1) {
			String filePath = args[0];
			
			try {
				phrase = new String(Files.readAllBytes(Paths.get(filePath)));

			} catch (IOException e) {
				System.out.println("\nError reading file!\n");
				System.exit(0);
			}
		}

		else if (args.length >= 2) {
			outputFile = args[1];
		}

		else {
			Scanner input = new Scanner(System.in);

			System.out.print("\nEnter a word or phrase: ");
			phrase = input.nextLine().toLowerCase();
			System.out.println();

			input.close();
		}
		

		char[] characterArray = phrase.toCharArray();
		HashMap<Character, Integer> characterCount = new HashMap<>();
			
		for (char character : characterArray) {
			
			if (Character.isLetter(character)) {
				
				characterCount.put(character, characterCount.getOrDefault(character, 0) + 1);
			}
		}

		for (char character : characterCount.keySet()) {
			System.out.println(character + ": " + characterCount.get(character));
			CharacterCounter.writeFile(outputFile, (character + ": " + characterCount.get(character)));
		}

		System.out.println();
	}

	public static void writeFile(String filePath, String line) {
		try {
			FileWriter file = new FileWriter(filePath, true);
			file.write(line + "\r\n");
			file.close();
		}

		catch (IOException e) {
			System.out.println("Output error!");
			System.exit(0);
		}
	}
}
