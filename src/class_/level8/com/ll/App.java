package class_.level8.com.ll;


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
            } else if (cmd.startsWith("삭제?id")) {
                String str = cmd.substring(6);
                int id = Integer.parseInt(str);
                actionDelete(id);
            } else if (cmd.startsWith("수정?id")) {
                String str = cmd.substring(6);
                int id = Integer.parseInt(str);
                actionEdit(id);
            }

        }

        scanner.close();
    }

    private void actionEdit(int id) {

        WiseSaying foundWiseSaying = null;

        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                foundWiseSaying = wiseSaying;
                break;
            }
        }
        if (foundWiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(수정 전) :" + foundWiseSaying.getContent());
        System.out.print("명언(수정 후) :");
        String newContent = scanner.nextLine();
        System.out.println("작가(수정 전) :" + foundWiseSaying.getAuthor());
        System.out.print("작가(수정 후) :");
        String newAuthor = scanner.nextLine();

        foundWiseSaying.SetContent(newContent);
        foundWiseSaying.SetAuthor(newAuthor);
        System.out.println(id + "번의 명언이 수정되었습니다.");
    }

    private void actionDelete(int id) {

        boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
        // removeIF() 안의 바디가 해당된다면 true를 반환한다.
        if (removed) System.out.println(id + "번 명언을 삭제하였습니다");
        else System.out.println("해당 명언은 존재하지 않습니다.");

    }

    private void actionIndex() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");

        for (int i = wiseSayings.size()-1; i >= 0; i --) {
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
        count++;

    }

    private void addWiseSaying(String content, String author) {
        wiseSayings.add(new WiseSaying(count, content, author));

    }
}

