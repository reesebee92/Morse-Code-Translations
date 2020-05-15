
/** MorseCodeTranslations
 * 
 *  This class will allow a user to input a sentence in English or,
 *  a morse code pattern sequence
 *  Once input is received, the user will receive the translated version
 *  
 *  */

import java.util.Scanner;

public class MorseCodeTranslations {

   public static void main(String[] args) {

      // create a scanner for the user to make a translation selection
      Scanner input = new Scanner(System.in);
      // change the delimiter input to include spaces
      input.useDelimiter("\n");

      // prompt the user
      System.out
            .print("Enter 1 for English to Morse, or 2 for Morse to English: ");
      int translationSelection = input.nextInt();

      // enum values for switch statement
      final int englishInput = 1;
      final int morseInput = 2;

      // switch statement used to pick a translation
      switch (translationSelection) {
         case englishInput:
            // prompt the user to enter English code with spaces
            System.out.println(
                  "Enter English letters and numbers separated by a space (e.g. book 223): ");
            String userInput = input.next().strip();

            // call method to translate
            englishToMorse(userInput);
            break;
         case morseInput:
            // prompt the user to enter morse code with '|' separator
            System.out.println(
                  "Enter Morse code separated by a space for a word and | for multiple words"
                        + " (e.g. -... --- --- -.- | ..--- ..--- ...--): ");
            userInput = input.next();

            // call method to translate
            morseToEnglish(userInput);
            break;
      }// end switch statement translationSelection

   }// end main method

   /**
    * englishToMorse
    * 
    * This method will return morse code for English inputed code
    * precondition:the English code needs to be separated by a space for each
    * word 
    * postcondition: the original input is displayed along with the morse
    * code translation
    * 
    * @param user input
    */
   public static void englishToMorse(String userInput) {

      // create a String array to hold all the morse code patterns
      String[] morsePatterns = { ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "|" };

      // create a String array to hold all the English and letter values
      String[] englishLetterAndNums = { "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", " " };

      // create a translation index to loop through Integer object array
      int translationIndex = 0;
      // create Integer object array to assign values to null
      Integer[] indexTranslationValues = new Integer[50];

      // create a nested for loop for each value of the userInput String to be
      // compared to each value in the englishLetterAndNums array
      for (int userIndex = 0; userIndex < userInput.length(); userIndex++) {
         for (int englishIndex = 0; englishIndex < englishLetterAndNums.length; englishIndex++) {
            // create a char value for each char in userInput
            char englishChar = userInput.charAt(userIndex);

            // then convert the value to a string to compare String to String
            String englishStr = Character.toString(englishChar);

            // Compare content of both Strings
            if (englishStr
                  .equalsIgnoreCase(englishLetterAndNums[englishIndex])) {
               // if the Strings are equal record the index value in the
               // translation array
               indexTranslationValues[translationIndex] = englishIndex;
               translationIndex++;
            } // end if

         } // end inner loop
      } // end outer loop

      // Display the English word(s) and/or number(s) in morse code
      String output = "Your english code " + userInput + " in morse code is: ";

      for (int printIndex = 0; printIndex < indexTranslationValues.length; printIndex++) {
         if (indexTranslationValues[printIndex] != null) {
            output += " " + morsePatterns[indexTranslationValues[printIndex]];
         } // end if
      } // end for loop

      System.out.print(output + " ");
   }// end method englishToMorse

   /**
    * morseToEnglish
    * 
    * This method will return an English translation for inputed code
    * precondition:the morse code needs to be separated by a space for each
    * symbol set and separated by a | for each word 
    * postcondition: the original
    * input is displayed along with the English code translation
    * 
    * @param user input
    */
   public static void morseToEnglish(String userInput) {

      // create a String array to hold all the morse code patterns
      String[] morsePatterns = { ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "|" };

      // create a String array to hold all the English and letter values
      String[] englishLetterAndNums = { "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", " " };
      // create a String array to store morse code values
      String[] userArray = userInput.split(" ");

      // create a translation index to loop through Integer object array
      int translationIndex = 0;
      // create Integer object array to assign values to null
      Integer[] indexTranslationValues = new Integer[50];

      // create a nested for loop for each value of the userInput array to be
      // compared to each value in the morsePatterns array
      for (int userIndex = 0; userIndex < userArray.length; userIndex++) {
         for (int morseIndex = 0; morseIndex < morsePatterns.length; morseIndex++) {

            // Compare content of both Strings
            if (userArray[userIndex].equals(morsePatterns[morseIndex])) {
               // if the Strings are equal record the index value in the
               // translation array
               indexTranslationValues[translationIndex] = morseIndex;
               translationIndex++;
            } // end if

         } // end inner loop
      } // end outer loop

      // Display the morse code in English word(s) and/or number(s)
      String output = "Your morse code " + userInput + " in English is: ";

      for (int printIndex = 0; printIndex < indexTranslationValues.length; printIndex++) {
         if (indexTranslationValues[printIndex] != null) {
            output += englishLetterAndNums[indexTranslationValues[printIndex]];
         } // end if
      } // end for loop
      System.out.print(output + " ");
   }// end method morseToEnglish

}// end class MorseCodeTranslations
