package CardApp2;

import java.util.ArrayList;

public class Player {
    Card draw(ArrayList<Card> deck) {
        int rnd = (int) (Math.random() * deck.size());
        return deck.remove(rnd); // デッキからカードを引き、削除する
    }
}
