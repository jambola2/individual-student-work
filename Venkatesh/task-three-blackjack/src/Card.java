
public class Card {
	String suit;
	int number;
	
	public Card(String suit, int number){
		this.suit = suit;
		this.number = number;
	}
	
	public String getCardName(){
		String name = "";
		if (number == 1){
			name += "Ace of ";
		}
		else if (number == 2){
			name += "Two of ";
		}
		else if (number == 3){
			name += "Three of ";
		}
		else if (number == 4){
			name += "Four of ";
		}
		else if (number == 5){
			name += "Five of ";
		}
		else if (number == 6){
			name += "Six of ";
		}
		else if (number == 7){
			name += "Seven of ";
		}
		else if (number == 8){
			name += "Eight of ";
		}	
		else if (number == 9){
			name += "Nine of ";
		}
		else if (number == 10){
			name += "Ten of ";
		}
		else if (number == 11){
			name += "Jack of ";
		}
		else if (number == 12){
			name += "Queen of ";
		}
		else if (number == 0){
			name += "King of ";
		}
		if (suit.equals("H")){
			name += "Hearts";
		}
		else if (suit.equals("C")){
			name += "Clubs";
		}
		else if (suit.equals("D")){
			name += "Diamonds";
		}
		else if (suit.equals("S")){
			name += "Spades";
		}
		return name;
	}
	public int getNumber(){
		return this.number;
	}

	public String getShortName(){

		String name = suit;
		if (number<11&&number > 0){
			name += Integer.valueOf(number);
		}
		else if (number == 11){
			name += "J";
		}
		else if (number == 12){
			name += "Q";
		}
		else{
			name +=  "K";
		}
		return name;
	}
}
