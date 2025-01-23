package CardApp2;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Player p;
    ArrayList<Card> deck;//デッキを表すArrayList

    Game() {
        p = new Player();
        deck = new ArrayList<>();// ArrayListのインスタンスを生成
        String[] marks = {"♠", "♦", "♣", "♥"};

        for (String mark : marks) {// マークごとにカードを生成
            for (int j = 1; j <= 13; j++) {
                Card cd = new Card();// Cardクラスのインスタンスを生成
                cd.mark = mark;// markフィールドに代入
                cd.number = j;// numberフィールドに代入
                deck.add(cd);// デッキにカードを追加
            }
        }
    }

    void start() {
        System.out.println("ゲームを開始します！");
        Card openCard = p.draw(deck); // 最初のカードを引く
        System.out.print("開いたカード: ");
        openCard.open();// カードを表示

        Card hiddenCard = p.draw(deck); // 次のカードを引く
        System.out.println("次のカードは大きいか小さいかを予想してください。");
        System.out.print("1: 大きい, 2: 小さい > ");
        
        Scanner sc = new Scanner(System.in);// 入力を受け付ける
        int guess = sc.nextInt();// 予想を入力

        System.out.print("伏せたカード: ");
        hiddenCard.open();// カードを表示

        judge(openCard, hiddenCard, guess);// 勝敗を判定
        sc.close();
    }

    void judge(Card openCard, Card hiddenCard, int guess) {
        boolean isHigher = hiddenCard.number > openCard.number;// 隠れたカードが大きいかどうか

        if ((guess == 1 && isHigher) || (guess == 2 && !isHigher)) {
            System.out.println("あなたの勝ちです！");
        } else {
            System.out.println("あなたの負けです。");
        }
    }
}
