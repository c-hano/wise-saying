package class_.level1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.run();
    }
}

class App {
    public void run() {
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("명령) ");
            String cmd = scanner.nextLine();

            if(cmd.equals("종료")) break;


        }

        scanner.close();
    }
}
