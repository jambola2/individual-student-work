package stackpack;

import java.util.Scanner;

public class Main {
    static int[] array = new int[16];
	static char type;
	static int head;
	static int tail;
	public static void main(String[] args) {	
		Scanner s = new Scanner(System.in);
		System.out.println("Create a queue or a stack ?");
		while (s.hasNext()){
			char answer = s.nextLine().charAt(0);
			if (answer == 'q' || answer == 'Q'){
				type = 'q';
				head = array.length;
				tail = array.length;
				break;
			}
			else if (answer == 's' || answer == 'S'){
				type = 's';
				head = 0;
				tail = 0;
				break;
			}
		}
		System.out.println("Available commands :-");
		
		System.out.println("Add <integer>");
		System.out.println("Delete");
		System.out.println("List");

		while (s.hasNext()){
			String line = s.nextLine();
			if (line.length() > 2 && line.substring(0, 3).equalsIgnoreCase("add")){
				add(Integer.parseInt(line.substring(4,line.length()).replaceAll("//s", "")));
				System.out.println("Item has been added");

			}
			if (line.length() > 5 && line.substring(0, 6).equalsIgnoreCase("delete")){
				delete();
				System.out.println("Item has been deleted");
			}
			if (line.length() > 3 && line.substring(0,4).equalsIgnoreCase("list")){
				list();
			}
		}
		
	}
	public static void add(int number){
		if (isFull()){
			System.out.println("Error: This queue or stack is full");
			return;
		}
		if (type == 's'){
			array[tail] = number;
			tail++;
			return;
		}
		if(type == 'q'){
			head--;
			array[head] = number;
		}
	}
	public static int delete(){
		if (isEmpty()){
			System.out.println("Error: This queue or stack is empty");
			return 0;
		}
		if (type == 'q'){
			int last = array[array.length-1];
			head += 1;
				for (int i = array.length-1; array[i]!= 0; i--){
					array[i] = array[i-1];
				}

			return last;
		}
		else{
			tail--;
			array[tail] = 0;
			return array[tail];
		}
	}
	
	public static void list(){
		if (isEmpty()){
			System.out.println("Error: This queue or stack is empty");
			return;
		}
		if (type == 'q'){
			int i = array.length-1;
			while (array[i] != 0){
				System.out.print(array[i]+ " ");
				i--;
			}
			System.out.println();
		}
		else{
			for (int i = tail-1; i >= 0; i--){
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	}
	public static boolean isEmpty(){
		boolean result = true;
		for (int i = 0; i < array.length; i++){
			if (array[i]!= 0){
				result = false;
			}
		}
		return result;
	}
	
	public static boolean isFull(){
		if (type == 's'){
			if (tail == array.length + 1){
				return true;
			}
		}
		else if (type == 'q'){
			if (head == 0){
				return true;
			}
		}
		return false;
	}
}
