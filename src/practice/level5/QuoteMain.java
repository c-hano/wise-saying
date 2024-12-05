package practice.level5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuoteMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Quote> quotes = new ArrayList<>();
        int indexCount = 1;

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();

            if (command.equals("등록")) {
                System.out.print("명언 : ");
                String comment = sc.nextLine().trim();
                System.out.print("작가 : ");
                String author = sc.nextLine().trim();

                if (author.isEmpty()) {
                    author = "작자미상";
                }

                quotes.add(new Quote(author,comment,indexCount));

                System.out.println(indexCount + "번 명령이 등록되었습니다.");
                indexCount++;

            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("--------------------");

                for (int i = quotes.size() - 1; i >= 0; i--) {
                    Quote q = quotes.get(i);
                    System.out.println(q.getIndexNumber() + " / " + q.getAuthor() + "/ " + q.getComment());
                }
            } else if (command.equals("종료")) {
                System.out.println("시스템을 종료합니다");
                break;

            } else {
                System.out.println("잘못된 입력어 입니다.");
            }
        }

    }

}
