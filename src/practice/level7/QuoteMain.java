package practice.level7;



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

            } else if (command.startsWith("삭제?id")) {

                try {
                    String[] str = command.split("=", 2);
                    int deleteIndexNumber = Integer.parseInt(str[1]);
                    boolean isdeletedNumber = false;
                    //boolean을 쓰는 이유 -> 반복문 안에서 해당 명언을 찾으면 나와야함.
                    //3번 인덱스를 찾는데 1번부터 반복이 들어감.
                    //3번 인덱스이니 1번은 당연히 맞지 않음.
                    //맞지 않으니 else로 넘어가고 그러면 3번 인덱스를 가기 전에
                    //해당 명언은 찾지 못한다고 출력이 되어버림.
                    //boolean을 사용하여 true값을 반환하고 이후에 true가 아닐 경우의 식을 만들어서
                    //반복문을 다 돌았으나 찾지 못하면 false값이므로 찾지 못하였다고 식을 써 놓을 수 있음.

                    for (Quote q : quotes) {
                        if (q.getIndexNumber() == deleteIndexNumber) {
                            quotes.remove((deleteIndexNumber - 1));
                            System.out.println(deleteIndexNumber+ "번의 명언이 삭제되었습니다.");
                            isdeletedNumber = true;
                            break;
                        }
                    }
                    if (!isdeletedNumber) {
                        System.out.println("해당 번호의 명언은 없습니다.");
                    }
                } catch (Exception e) {
                    System.out.println("잘못된 명령어 입니다.");
                }

            } else {
                System.out.println("잘못된 입력어 입니다.");
            }
        }

    }

}
