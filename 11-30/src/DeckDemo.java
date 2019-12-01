import java.util.*;

class Card {
    int rank;
    String color;

    public Card(int rank,String color) {
        this.rank = rank;
        this.color = color;
    }
    public String toString() {
        String value = null;
        if(rank == 1) {
            value = "A";
        } else if (rank > 10) {
            if (rank == 11) {
                value = "J";
            } else if (rank == 12) {
                value = "Q";
            } else if (rank == 13) {
                value = "K";
            }
        } else {
            value = String.valueOf(rank);
        }
        return String.format("(%s %s)",rank,color);
    }

}

public class DeckDemo {
    public static final String[] COLOR = {"♥","♦","♣","♠"};
    public static List<Card> createCard() {
        List<Card> deck = new ArrayList<>(52);
        for (int i = 0;i < 4;i++) {
            for(int j = 0;j < 13;j++) {
                String color = COLOR[i];
                int rank = j;
                Card card = new Card(rank,color);
                deck.add(card);
            }
        }
        return deck;
    }

    public static void shuffle(List<Card> deck) {
        Random rand = new Random();
        for(int i = deck.size() - 1;i > 0;i--) {
            int position = rand.nextInt(i);
            swap(deck,i,position);
        }
    }

    public static void swap(List<Card> deck,int i,int j) {
        Card tmp = deck.get(i);
        deck.set(i,deck.get(j));
        deck.set(j,tmp);
    }

    public static void send(List<Card> deck,List<List<Card>> persons,int numberCard,int numberPerson) {
        for(int i = 0;i < numberPerson;i++) {
            List<List<Card>> person = new ArrayList<>();
        }
        for(int i = 0;i < numberCard;i++) {
            for (int j = 0;j < numberPerson;j++) {
                persons.get(j).add(deck.remove(0));
            }
        }
    }

    public static void main(String[] args) {
        List<Card> deck = createCard();
        shuffle(deck);

        //send(deck,,5,5);
    }
}
