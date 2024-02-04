package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author anmol
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        // Fill magicHand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit
            magicHand[i] = c;
        }
        // hard code luckyCard
        Card luckyCard = new Card();
            luckyCard.setValue(7); 
            luckyCard.setSuit("Hearts");

        // Printing the values
        System.out.println("------------- Hard-coded luckyCard values: -----------------------");
        System.out.println("Value: " + luckyCard.getValue());
        System.out.println("Suit: " + luckyCard.getSuit());
        System.out.println("------------------------------------------------------------------");
        
        // Print the magic hand
        System.out.println("Magic Hand:");
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }
        
        boolean cardFound = false;
    for (Card card : magicHand) {
        if (card.getValue() == luckyCard.getValue() && card.getSuit().equals(luckyCard.getSuit())) {
            cardFound = true;
            break;
        }
    }
        
        // Report the result to the user
        if (cardFound) {
            System.out.println("Congratulations, your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        scanner.close();
    }
}
