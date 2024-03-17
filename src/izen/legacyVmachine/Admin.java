package izen.legacyVmachine;

import java.util.Scanner;

public class Admin {

    // 관리자 메뉴 시작
    public void accessToAdminMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("관리자 메뉴 입니다.");

        while (true) {
            System.out.println("원하는 작업을 선택하세요:");
            System.out.println("1. 메뉴 변경");
            System.out.println("2. 가격 변경");
            System.out.println("3. 재고 추가");
            System.out.println("4. 메뉴 추가");
            System.out.println("5. 수익 확인");
            System.out.println("6. 사용자 메뉴로 이동");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    break;
                case 2:
                    // 가격 변경 기능 호출
                    break;
                case 3:
                    // 재고 추가 기능 호출
                    break;
                case 4:
                    // 메뉴 추가 기능 호출
                    break;
                case 5:
                    // 수익 확인 기능 호출
                    break;
                case 6:
                    System.out.println("사용자 메뉴로 이동합니다.");
                    return; // 사용자 메뉴로 이동하고 메소드를 종료
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요.");
            }
        }

    }


    // 초기 메뉴 세팅
    static Product[] products = new Product[5];

    public static void initialize() {
        System.out.println("메뉴를 초기 세팅 합니다.");

        products[0] = new Product("콜라", 500, 3);
        products[1] = new Product("사이다", 700, 3);
        products[2] = new Product("커피", 1500, 3);
    }


}
