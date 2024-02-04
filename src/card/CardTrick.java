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
        Card luckyCard = new Card();
            luckyCard.setValue(7); 
            luckyCard.setSuit("Hearts");
        
        // Print the magic hand
        System.out.println("Magic Hand:");
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }
        
        // Ask the user to input a card value and suit
        System.out.print("\nEnter a card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.print("Enter a suit (0-3 where 0-Hearts, 1-Diamonds, 2-Clubs, 3-Spades): ");
        int userSuit = scanner.nextInt();
        
        // Search magicHand for the user's card
        boolean cardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equals(Card.SUITS[userSuit])) {
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
