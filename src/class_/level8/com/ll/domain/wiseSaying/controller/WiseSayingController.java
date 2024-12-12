package class_.level8.com.ll.domain.wiseSaying.controller;

import class_.level8.com.ll.domain.wiseSaying.entity.WiseSaying;
import class_.level8.com.ll.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService;
    private final Scanner scanner;


    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        this.wiseSayingService = new WiseSayingService();
    }


    public void actionIndex() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();
        for (int i = wiseSayings.size()-1; i >= 0; i --) {
            System.out.printf("%d / %s / %s%n", wiseSayings.get(i).getId(), wiseSayings.get(i).getAuthor(), wiseSayings.get(i).getContent());
        }
        // .reversed() 순서 뒤집기
       /* for (WiseSaying words : wiseSayings.reversed()) {
            System.out.printf("%d / %s / %s%n", wiseSayings.get(i).getId(), wiseSayings.get(i).getAuthor(), wiseSayings.get(i).getContent());

        }*/
    }
    public void actionDelete(String cmd) {

        String str = cmd.substring(6);
        int id = Integer.parseInt(str);

        boolean removed = wiseSayingService.removeID(id);
        // removeIF() 안의 바디가 해당된다면 true를 반환한다.
        if (removed) System.out.println(id + "번 명언을 삭제하였습니다");
        else System.out.println("해당 명언은 존재하지 않습니다.");

    }

    public void actionEdit(String cmd) {
        String str = cmd.substring(6);
        int id = Integer.parseInt(str);

        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(id);

        if (opWiseSaying.isEmpty()) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        WiseSaying foundWiseSaying = opWiseSaying.get();


        System.out.println("명언(수정 전) :" + foundWiseSaying.getContent());
        System.out.print("명언(수정 후) :");
        String newContent = scanner.nextLine();
        System.out.println("작가(수정 전) :" + foundWiseSaying.getAuthor());
        System.out.print("작가(수정 후) :");
        String newAuthor = scanner.nextLine();

        wiseSayingService.modify(foundWiseSaying, newContent, newAuthor);


        System.out.println(id + "번의 명언이 수정되었습니다.");
    }

    public void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        wiseSayingService.add(content, author);


    }
}



