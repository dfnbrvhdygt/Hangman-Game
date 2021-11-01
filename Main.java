
import java.util.*;


// Hangman class to provide the abstraction for words
class Hangman
{
    // decide attribute
    private String word;

    // create constructor for word parameter
    public Hangman(String word){
        this.word = word;
    }

    // getter method for word parameter
    public String getWord(){
        return word;
    }

}


class Main { // Testing class

// defined variables
    static String word = "";
    static String asterisk = "";
    static int count = 0;



  public static void main(String[] args) {
   // declared some states of USA  using Hangman class
        Hangman word1 = new Hangman("alabama");
        Hangman word2 = new Hangman("california");
        Hangman word3 = new Hangman("nebraska");
        Hangman word4 = new Hangman("oklahama");
        Hangman word5 = new Hangman("washington");
        Hangman word6 = new Hangman("mississipi");

        // created an array of objects with words above
        Hangman[] words = {word1, word2, word3, word4, word5, word6};

        //  start the game
        startGame(words);
    }



        // this method calls selectWord() and displayWord() functions
    public static void startGame(Hangman []words)
    {
        selectWord(words);
        displayWord();
    }

    // this method randomly selects a word from the array of words
    // and then create a String of asterisks with the same length
    public static void selectWord(Hangman []words)
    {
        // selected random word
        word = words[(int)(Math.random() * words.length)].getWord();

        // create a String asterisks with length equal to length of word
        asterisk = new String(new char[word.length()]).replace("\0", "*");
    }

    // this method displays the word with asterisks
    // th game will be over with 7 wrong choices
    public static void displayWord()
    {
        Scanner sc = new Scanner(System.in);
        while (count<7 && asterisk.contains("*"))
        {
            // display asterisk
            System.out.println("Word is: " + asterisk);

            // Guess a letter
            System.out.print("Guess any letter in the word: ");
            String guess = sc.next();
            System.out.println();

            //  change the string asterisk
            hang(guess);
        }
    }

    // this method updates the string asterisk
    public static void hang(String guess)
    {
        // declare temporary String
        String newasterisk = "";

        // check each Character from words
        for (int i=0; i<word.length(); i++)
        {
            // match Characters
            if(word.charAt(i) == guess.charAt(0))
            {
                newasterisk += guess.charAt(0);
            }
            else if(asterisk.charAt(i) != '*')
            {
                newasterisk += word.charAt(i);
            }
            else
            {
                newasterisk += "*";
            }
        }

        // if asterisk and newasterisk are still same
        // then it simply means that the player guesses wrong letter
        if(asterisk.equals(newasterisk))
        {
            // call displayHangMan()
            count++;
            displayHangMan();
        }
        else
        {
            // otherwise, updated String asterisk
            asterisk = newasterisk;
        }

        // if asterisk matches with word, know the all letters of the word
        if (asterisk.equals(word))
        {
            System.out.println("Correct! You win! The word was " + word);
        }
    }

    // create this method to display  hanging man by counting number
    public static void displayHangMan()
    {
        // 1.wrong guess
        if(count == 1){
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }

        // 2. wrong guess
        if(count == 2){
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }

        // 3. wrong guess
        if(count == 3){
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }

        // 4. wrong guess
        if(count == 4){
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }

        // 5.wrong guess
        if(count == 5){
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }

        // 6. wrong guess
        if(count == 6){
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }

        // 7. wrong guess
        if(count == 7){
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("GAME OVER! The word was " + word);
        }
    }





}
