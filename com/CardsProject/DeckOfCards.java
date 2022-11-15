package com.CardsProject;

import java.util.Random;

public class DeckOfCards {

	String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
	String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	int suitLength = suit.length;
	int rankLength = rank.length;
	int result = suitLength * rankLength;
	int shufflePosition;
	int deckLength;
	String temp;
	String[][] cards = new String[suitLength][rankLength];
	String[] deck = new String[result];
	String[] shuffledDeck = new String[result];
	int persons = 4;
	int cardsForEach = 9;
	String[][] perEachCards = new String[persons][cardsForEach];
	String[][] orderedDeck = new String[persons][cardsForEach];

	public void shuffleCards() {

		Random random = new Random();

		// Concatenate 2 array String Values
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				cards[i][j] = suit[i].concat(rank[j]);
			}
		}

		// 2D Array to 1D Array
		int k = 0;
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				if (k < result) {
					deck[k] = cards[i][j];
					k++;
				}
			}
		}

		// Copying deck array to shuffledDeck array
		for (int i = 0; i < deck.length; i++) {
			shuffledDeck[i] = deck[i];
		}

		// Shuffle the deck
		deckLength = shuffledDeck.length;
		for (int i = 0; i < deckLength; i++) {

			shufflePosition = random.nextInt(deckLength);
			// System.out.println(shufflePosition+" "+i);
			temp = shuffledDeck[shufflePosition];
			shuffledDeck[shufflePosition] = shuffledDeck[i];
			shuffledDeck[i] = temp;
		}

		//// Print shuffled deck
		// for(int i = 0; i < deckLength; i++) {
		// System.out.println(shuffledDeck[i]+" "+i);
		// }

		// Distributing 9 cards for each persons
		int c = 0;
		for (int i = 0; i < persons; i++) {
			for (int j = 0; j < cardsForEach; j++) {

				perEachCards[i][j] = shuffledDeck[c];
				shuffledDeck[c] = "empty";
				c++;

			}
		}

		System.out.println("****************Before ranking **********************************************");
		// Print cards distributed for each person from 1D array deck[] to 2D array
		// perEachCards[][]
		for (int i = 0; i < persons; i++) {
			for (int j = 0; j < cardsForEach; j++) {
				System.out.print(perEachCards[i][j] + " ");
			}
			System.out.println("");
		}

		System.out.println("****************After ranking **********************************************");
		// person 1 arranging per rank order
		int num1 = 0;
		for (int r = 0; r < rank.length; r++) {
			for (int i = 0; i < cardsForEach; i++) {

				if (perEachCards[0][i].contains(rank[r])) {

					String temp1 = perEachCards[0][i];
					perEachCards[0][i] = perEachCards[0][num1];
					perEachCards[0][num1] = temp1;
					System.out.print(perEachCards[0][num1] + " ");
					num1++;

				}
			}
		}
		System.out.println("");

		// person 2 arranging per rank order
		int num2 = 0;
		for (int r = 0; r < rank.length; r++) {
			for (int i = 0; i < cardsForEach; i++) {

				if (perEachCards[1][i].contains(rank[r])) {

					String temp2 = perEachCards[1][i];
					perEachCards[1][i] = perEachCards[1][num2];
					perEachCards[1][num2] = temp2;
					System.out.print(perEachCards[1][num2] + " ");
					num2++;

				}
			}
		}
		System.out.println("");

		// person 3 arranging per rank order
		int num3 = 0;
		for (int r = 0; r < rank.length; r++) {
			for (int i = 0; i < cardsForEach; i++) {

				if (perEachCards[2][i].contains(rank[r])) {

					String temp3 = perEachCards[2][i];
					perEachCards[2][i] = perEachCards[2][num3];
					perEachCards[2][num3] = temp3;
					System.out.print(perEachCards[2][num3] + " ");
					num3++;

				}
			}
		}
		System.out.println("");

		// person 4 arranging per rank order
		int num4 = 0;
		for (int r = 0; r < rank.length; r++) {
			for (int i = 0; i < cardsForEach; i++) {

				if (perEachCards[3][i].contains(rank[r])) {

					String temp4 = perEachCards[3][i];
					perEachCards[3][i] = perEachCards[3][num4];
					perEachCards[3][num4] = temp4;
					System.out.print(perEachCards[3][num4] + " ");
					num4++;

				}
			}
		}
	}

	public static void main(String[] args) {

		DeckOfCards dc = new DeckOfCards();
		dc.shuffleCards();
	}
}
