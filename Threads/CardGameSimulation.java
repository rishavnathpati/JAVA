package Threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
    private final String suit;
    private final int number;

    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return suit + " " + number;
    }
}

class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"Club", "Heart", "Diamond", "Spade"};
        for (String suit : suits) {
            for (int i = 0; i < 13; i++) {
                cards.add(new Card(suit, i));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }

    public void returnCard(Card card) {
        cards.add(card);
    }
}

class Player extends Thread {
    private final String name;
    private final Deck deck;
    private int kingsDrawn = 0;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
    }

    public int getKingsDrawn() {
        return kingsDrawn;
    }

    @Override
    public void run() {
        while (kingsDrawn < 4) {
            List<Card> hand = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                hand.add(deck.draw());
            }
            System.out.println(name + " drew: " + hand);
            for (Card card : hand) {
                if (card.getNumber() == 0) {
                    kingsDrawn++;
                } else {
                    deck.returnCard(card);
                }
            }
            deck.shuffle();
        }
        System.out.println(name + " wins the game!");
    }
}

public class CardGameSimulation {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Player player1 = new Player("Player 1", deck);
        Player player2 = new Player("Player 2", deck);
        Player player3 = new Player("Player 3", deck);
        Player player4 = new Player("Player 4", deck);

        player1.start();
        player2.start();
        player3.start();
        player4.start();

        try {
            player1.join();
            player2.join();
            player3.join();
            player4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
