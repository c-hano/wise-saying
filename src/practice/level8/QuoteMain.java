package practice.level8;




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

                    for (Quote q : quotes) {
                        if (q.getIndexNumber() == deleteIndexNumber) {
                            quotes.remove((deleteIndexNumber - 1));
                            System.out.println(deleteIndexNumber+ "번의 명언이 삭제되었습니다.");
                            isdeletedNumber = true;
                            break;
                        }
                    }
                    if (!isdeletedNumber) {
                        System.out.println("해당 번호는 존재하지 않습니다.");
                    }
                } catch (Exception e) {
                    System.out.println("잘못된 입력어입니다.");
                }

            } else if (command.startsWith("수정?id")) {
                try {
                    String[] str2 = command.split("=", 2);
                    int replaceIndex = Integer.parseInt(str2[1]);
                    boolean isreplacedIndex = false;

                    for (Quote q : quotes) {
                        if (q.getIndexNumber() == replaceIndex) {
                            System.out.println("명언(기존) : " + q.getComment());
                            System.out.print("명언(수정) : ");
                            q.setComment(sc.nextLine().trim());
                            System.out.println("작가(기존) : " + q.getAuthor());
                            System.out.print("작가(수정) : ");
                            q.setAuthor(sc.nextLine().trim());

                            isreplacedIndex = true;
                            break;
                        }
                    }
                    if (!isreplacedIndex) {
                        System.out.println("해당 번호은 존재하지 않습니다.");
                    }

                }catch (Exception e) {
                    System.out.println("입력 방식이 잘못되었습니다.");
                }

            } else {
                System.out.println("잘못된 입력어입니다.");
            }
        }

    }

}
