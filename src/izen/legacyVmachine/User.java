package izen.legacyVmachine;

import java.util.Scanner;

public class User {
    Scanner scanner = new Scanner(System.in);

    public void accessToUserMenu() {
        System.out.println("===========================================================");
        System.out.println("자판기 입니다. (번호: 상품(가격)-재고");
        System.out.println(
                "1: 콜라(500W)-3개 " +
                "2: 사이다(700W)-3개 " +
                "3: 커피(1500W)-3개 "
        );
        System.out.println("===========================================================");

        // 금액 입력

        System.out.print("돈을 넣어주세요: ");
        int firstMoney = scanner.nextInt();
    }



    // 제품 번호 선택
    // 메뉴 확인
    // 제품 받기
    // 금액, 재고 차감
    // 잔액 부족 시 잔액 부족 확인 및 금액 충전
    // 잔돈 반환 시 남은 금액 받기 및 초기화면 보기


}
