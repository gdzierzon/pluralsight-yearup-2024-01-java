import com.pluralsight.application.BlackJackConsole;
import com.pluralsight.application.UnoConsole;
import com.pluralsight.models.cards.Card;
import com.pluralsight.models.cards.Deck;
import com.pluralsight.models.cards.facecards.FaceCard;
import com.pluralsight.models.cards.facecards.FaceCardDeck;
import com.pluralsight.models.games.CardGame;
import com.pluralsight.ui.UserInput;
import com.pluralsight.ui.UserOutput;
import com.pluralsight.ui.enumerations.GameOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardGamesApplication
{
    public static void main(String[] args)
    {
        CardGame game;
        Deck deck;

        GameOptions option = UserInput.gameToPlay();

        while(option != GameOptions.Quit)
        {
            if (option == GameOptions.BlackJack)
            {
                deck = loadFaceCardDeck("face.txt");
                game = new BlackJackConsole((FaceCardDeck) deck);
                game.play();
            }
            else if (option == GameOptions.Uno)
            {
                deck = loadDeck("uno.txt");
                game = new UnoConsole(deck);
                game.play();
            }

            option = UserInput.gameToPlay();
        }

        UserOutput.thankYou();


    }

    // these 2 methods could be implemented better through inheritance, but I didn't have time
    private static Deck loadDeck(String filePath)
    {
        List<Card> cards = new ArrayList<>();
        Deck deck = new Deck(cards);

        File file = new File(filePath);

        // open the file
        try (Scanner fileReader = new Scanner(file.getAbsoluteFile()))
        {

            fileReader.nextLine(); // skip the first line
            while(fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();

                String[] columns = line.split("\\|");

                // create variables from the split
                String name = columns[0].trim();
                String face = columns[1].trim();
                int value = Integer.parseInt(columns[2].trim());
                String color = columns[3].trim();

                // create card from input
                Card card = new Card(value, color, face);

                cards.add(card);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("There was an error loading the file.");
        }

        return deck;
    }

    // these 2 methods could be implemented better through inheritance, but I didn't have time
    private static FaceCardDeck loadFaceCardDeck(String filePath)
    {
        List<FaceCard> cards = new ArrayList<>();
        FaceCardDeck deck = new FaceCardDeck(cards);

        File file = new File(filePath);

        // open the file
        try (Scanner fileReader = new Scanner(file.getAbsoluteFile()))
        {

            fileReader.nextLine(); // skip the first line
            while(fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();

                String[] columns = line.split("\\|");

                // create variables from the split
                String name = columns[0].trim();
                String face = columns[1].trim();
                int value = Integer.parseInt(columns[2].trim());
                String suit = columns[3].trim();

                // create card from input
                FaceCard card = new FaceCard(suit, value, face);

                cards.add(card);
            }
            deck = new FaceCardDeck(cards);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("There was an error loading the file.");
        }

        return deck;
    }
}
