package izen.legacyVmachine.try1;

import java.util.Scanner;

public class Main1 {
    // 초기값 정리
    static final int MAX_PRODUCT = 5;
    static String[] product = new String[MAX_PRODUCT];
    static int[] price = new int[MAX_PRODUCT];
    static int[] stock = new int[MAX_PRODUCT];
    static Scanner scanner = new Scanner(System.in);
    static boolean firstBuy = true;
    static int currentBalance = 0;


    // 초기화 메서드
    public static void initialize() {
        product[0] = "콜라";
        price[0] = 500;
        stock[0] = 3;

        product[1] = "사이다";
        price[1] = 700;
        stock[1] = 3;

        product[2] = "커피";
        price[2] = 1500;
        stock[2] = 3;
    }

    public static void user() {
        while (true) {
            showUserMenu();
            int menuPickNumber = scanner.nextInt();
            if (menuPickNumber < 1 || menuPickNumber > MAX_PRODUCT) {
                System.out.println("잘못된 메뉴 번호입니다.");
                continue;
            }

            int selectedProductIndex = menuPickNumber - 1;
            int priceOfSelectedProduct = price[selectedProductIndex];
            if (currentBalance < priceOfSelectedProduct) {
                System.out.println("잔액이 부족합니다. 금액을 추가해주세요.");
                addMoney();
                continue;
            }

            giveProduct(selectedProductIndex);
            showActionMenu();
            int actionNumber = scanner.nextInt();
            switch (actionNumber) {
                case 1:
                    // 계속 구매
                    break;
                case 2:
                    addMoney(); // 금액 추가
                    break;
                case 3:
                    returnChange(); // 잔액 반환
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }


    private static void showUserMenu() {
        System.out.println("========================================================");
        System.out.println("자판기 입니다.(번호: 상품(가격)-재고)");
        for (int i = 0; i < MAX_PRODUCT; i++) {
            if (product[i] != null) {
                System.out.print(i + 1 + ": " + product[i] + "(" + price[i] + "W)-" + stock[i] + "개 ");
            }
        }
        System.out.println();
        System.out.println("========================================================");
    }

    private static void giveProduct(int productIndex) {
        System.out.println(product[productIndex] + " 나왔습니다.");
        currentBalance -= price[productIndex];
        stock[productIndex]--;
        System.out.println("잔액: " + currentBalance);
    }

    private static void addMoney() {
        System.out.print("금액을 추가하시겠습니까? 잔액: " + currentBalance);
        int plusMoney = scanner.nextInt();
        currentBalance += plusMoney;
    }

    private static void showActionMenu() {
        System.out.println("1: 계속 구매 2: 금액 추가 3: 잔액 반환");
    }

    private static void returnChange() {
        System.out.println("거스름돈 " + currentBalance + "원이 반환됩니다.");
        System.out.println("감사합니다. 다음에 또 이용해주세요.");
        currentBalance = 0;
        firstBuy = true;
        showUserMenu();
    }


    private static void adminMenu() {
        // 관리자 메뉴 목록 보여주기
        // 번호 입력 받기

        // 메뉴변경 : 메뉴명, 가격, 재고 변경
        // 가격변경 : 가격만 변경
        // 재고추가 : 재고만 변경
        // 메뉴추가 : 최대 5개까지 추가 가능
        // 수익확인 : 지금까지 판매한 금액 출력
        // 종료는 -1 : '메뉴 목록 보여주기'로 돌아가기 + 첫 구매로 다시 세팅
    }


    public static void main(String[] args) {
        initialize();
        user();
    }

}

    // 1. 구매하기
        // 메뉴 목록 보여주기

        // 첫 구매라면
            // 돈 받기
                // 1004 라면 '관리자 메뉴' 진입

        // 메뉴 입력 받기

        // 돈이 부족하면
            // 금액 추가
            // '액션 목록 보여주기'로 돌아가기

        // 메뉴 제공하기 + 잔액 감소 + 재고 감소

        // 액션 목록 보여주기
            // a. 계속 구매 : '메뉴 목록 보여주기'로 돌아가기
            // b. 금액 추가 : '금액 추가'로 가기
            // c. 잔액 반환 : '잔액 반환'으로 가기

    // 2. 금액 추가하기


    // 3. 잔돈 반환하기
        // '메뉴 목록 보여주기'로 돌아가기

    // 4. 관리자 메뉴
        // 관리자 메뉴 목록 보여주기
        // 번호 입력 받기

        // 메뉴변경 : 메뉴명, 가격, 재고 변경
        // 가격변경 : 가격만 변경
        // 재고추가 : 재고만 변경
        // 메뉴추가 : 최대 5개까지 추가 가능
        // 수익확인 : 지금까지 판매한 금액 출력
        // 종료는 -1 : '메뉴 목록 보여주기'로 돌아가기 + 첫 구매로 다시 세팅


