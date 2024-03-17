package izen.legacyVmachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 제품 번호 선택
        // 메뉴 확인
        // 제품 받기
        // 금액, 재고 차감
        // 잔액 부족 시 잔액 부족 확인 및 금액 충전
        // 잔돈 반환 시 남은 금액 받기 및 초기화면 보기

        // 메뉴 변경
        // 가격 변경
        // 재고 추가
        // 메뉴 추가 (최대 총 5개 가능)
        // 수익 확인
        // -1 입력 시 사용자 메뉴로 이동


        // 세팅
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        Admin admin = new Admin();

        // 초기 화면 : 숫자 입력 받기 (사용자 메뉴: 금액, 관리자 메뉴: 1004)
        System.out.print("금액을 입력해주세요: ");
        int initInput = scanner.nextInt();

        if (initInput == 1004) { // 관리자 메뉴 진입
            admin.accessToAdminMenu();
        } else { // 사용자 메뉴 진입
            user.accessToUserMenu();
        }

    }


}
