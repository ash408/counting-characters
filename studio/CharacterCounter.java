
import java.util.Scanner;
import java.util.HashMap;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.IOException;


public class CharacterCounter {

	public static void main (String[] args) {

		String phrase = "";

		if (args.length >= 1) {
			String filePath = args[0];
			
			try {
				phrase = new String(Files.readAllBytes(Paths.get(filePath)));

			} catch (IOException e) {
				System.out.println("\nError reading file!\n");
				System.exit(0);
			}
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
		}

		System.out.println();
	}
}
