import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {
	static Random random;
	public static void main(String args[]){
		System.out.println("New game started!");
		System.out.println();
		Scanner s = new Scanner(System.in);
		ArrayList<Card> deck = initdeck(4);	
		random = new Random();
		ArrayList<Card> playerhand = new ArrayList<Card>();
		ArrayList<Card> dealerhand = new ArrayList<Card>();
		
		draw(playerhand, deck);
		draw(playerhand, deck);
		while (true){
			int handvalue = getvalue(playerhand);
			
			System.out.print("Your hand is:");
			for (Card c: playerhand){
				System.out.print(c.getShortName()+ " ");
			}
			System.out.println();
			System.out.println("Your hand value is " + handvalue);
			
			if (handvalue == 21){
				System.out.println("Blackjack!");
				System.out.println("--------------");
				main(null);
			}
			else if(handvalue > 21 ){
				System.out.println("Bust!");
				System.out.println("--------------");
				main(null);
			}
			
			System.out.println("Stay or Hit?");
			char option = s.nextLine().charAt(0);
			if (option == 'h' || option == 'H'){
				draw(playerhand, deck);
			}
			else if (option == 's' || option == 'S'){
				dealerplay(handvalue, dealerhand, deck);
			}
		}
	}
	private static void dealerplay(int handvalue, ArrayList<Card> dealerhand, ArrayList<Card> deck) {
		int dealervalue = 0;
		while (dealervalue < 17){
			draw(dealerhand, deck);
			dealervalue = getvalue(dealerhand);
			if (dealervalue > handvalue){
				System.out.print("The dealer wins with ");
				for (Card c: dealerhand){
					System.out.print(c.getShortName()+ " ");
				}
				System.out.println();
				main(null);
				
			}
		} 
		System.out.println("The dealer loses with ");
		for (Card c: dealerhand){
			System.out.print(c.getShortName()+ " ");
		}
		System.out.println();
		main(null);
	}
	public static ArrayList<Card> initdeck(int decknumber){
		ArrayList<Card> deck = new ArrayList<Card>();
		for (int i = 1; i <= 13*decknumber; i++){
			deck.add(new Card("H",Integer.valueOf(i%13)));
			deck.add(new Card("C",Integer.valueOf(i%13)));
			deck.add(new Card("S",Integer.valueOf(i%13)));
			deck.add(new Card("D", Integer.valueOf(i%13)));
			// H1 = Ace of Hearts, C10 = Ten of Clubs, D12 = Queen of Diamonds
		}
		return deck;
	}
	public static void draw(ArrayList<Card> drawerhand, ArrayList<Card> deck){
		int index = random.nextInt(deck.size());
		drawerhand.add(deck.get(index));
		deck.remove(index);
	}
	
	public static int getvalue(ArrayList<Card> hand){
		int acecount = 0;
		int count = 0;
		
		for (int i = 0; i < hand.size(); i++ ){
			int cardvalue = hand.get(i).getNumber();
			if (cardvalue > 10){
				count += 10;
			}
			else if(cardvalue == 1){
				count += 11;
				acecount += 1;
			}
			else{
				count += cardvalue;
			}
		}
		while (count > 21 && acecount >0){
			count -= 10;
			acecount -= 1;
		}
		return count;
	}
}
