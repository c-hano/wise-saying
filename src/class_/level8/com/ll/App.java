package class_.level8.com.ll;


import class_.level8.com.ll.domain.system.controller.SystemController;
import class_.level8.com.ll.domain.wiseSaying.controller.WiseSayingController;
import class_.level8.com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private final WiseSayingController wiseSayingController;
    private final SystemController systemController;

    public App() {
        this.scanner = new Scanner(System.in);
        this.wiseSayingController = new WiseSayingController(scanner);
        this.systemController = new SystemController();
        //생성자를 굳이 쓰는 이유? -> 후에 추가 될때 파라미터를 사용하기 용이하다.
    }
    public void run() {
        System.out.println("== 명언 앱 ==");


        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                systemController.actionExit();
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

