package class_.level5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.run();
    }
}

class App {

    // 인스턴스 변수
    Scanner scanner = new Scanner(System.in);
    int count = 1;
    List<WiseSaying> wiseSayings = new ArrayList<>();

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

        for (WiseSaying words : wiseSayings) {
            System.out.println("%d / %s / %s".formatted(words.getId(), words.getAuthor(), words.getContent()));

        }
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

class WiseSaying {

    private int id;
    private String content;
    private String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }


}
