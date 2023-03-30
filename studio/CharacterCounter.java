
import java.util.Scanner;
import java.util.HashMap;


public class CharacterCounter {

	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a word or phrase: ");
		String phrase = input.nextLine().toLowerCase();

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
	}
}
