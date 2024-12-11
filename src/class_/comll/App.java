package class_.comll;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private int count = 1;
    private final List<WiseSaying> wiseSayings = new ArrayList<>();

    public void run() {
        System.out.println("== 명언 앱 ==");


        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();
            } else if (cmd.equals("목록")) {
                actionIndex();
            }

        }

        scanner.close();
    }

    private void actionIndex() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");

        for (int i = wiseSayings.size(); i == 0; i --) {
            System.out.printf("%d / %s / %s%n", wiseSayings.get(i).getId(), wiseSayings.get(i).getAuthor(), wiseSayings.get(i).getContent());
        }
        // .reversed() 순서 뒤집기
       /* for (WiseSaying words : wiseSayings.reversed()) {
            System.out.printf("%d / %s / %s%n", wiseSayings.get(i).getId(), wiseSayings.get(i).getAuthor(), wiseSayings.get(i).getContent());

        }*/
    }

    private void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        addWiseSaying(content, author);


        System.out.println(count + "번 명언이 등록되었습니다.");

    }

    private void addWiseSaying(String content, String author) {
        wiseSayings.add(new WiseSaying(count, content, author));
        count++;
    }
}

