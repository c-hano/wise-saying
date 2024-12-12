package class_.level8.com.ll;


import class_.level8.com.ll.domain.wiseSaying.controller.WiseSayingController;
import class_.level8.com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private final WiseSayingController wiseSayingController = new WiseSayingController(scanner);

    public void run() {
        System.out.println("== 명언 앱 ==");


        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                wiseSayingController.actionAdd();
            } else if (cmd.equals("목록")) {
                wiseSayingController.actionIndex();
            } else if (cmd.startsWith("삭제?id")) {
                wiseSayingController.actionDelete(cmd);
            } else if (cmd.startsWith("수정?id")) {
                wiseSayingController.actionEdit(cmd);
            }

        }

        scanner.close();
    }









}

