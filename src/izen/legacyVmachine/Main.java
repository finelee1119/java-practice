package izen.legacyVmachine;

import java.util.Scanner;

public class Main {
    // 초기값 정리
    static Scanner scanner = new Scanner(System.in);

    static final int MAX_PRODUCT = 5;
    static String[] product = new String[MAX_PRODUCT];
    static int[] price = new int[MAX_PRODUCT];
    static int[] stock = new int[MAX_PRODUCT];

    static boolean firstBuy = true;
    static int firstMoney;
    static int plusMoney;
    static int menuPickNumber;
    static int actionNumber;
    static int totalProfit;

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

    // 사용자 관련 메서드
    public static void user() {
        while (true) {
            int menuIndex = menuPickNumber - 1;

            System.out.println("========================================================");
            System.out.println("자판기 입니다.(번호: 상품(가격)-재고)");
            for (int i = 0; i < MAX_PRODUCT; i++) {
                if (product[i] != null) {
                    System.out.print(i + 1 + ": " + product[i] + "(" + price[i] + "W)-" + stock[i] + "개 ");
                }
            }
            System.out.println();
            System.out.println("========================================================");

            if (firstBuy) {
                System.out.print("금액을 입력하세요: ");
                firstMoney = scanner.nextInt();
                firstBuy = false;

                int adminMenuNum;
                while (true) {
                    if (firstMoney == 1004) {
                        System.out.println();
                        System.out.println("관리자 페이지 입니다.");
                        System.out.println("1: 메뉴변경 2: 가격변경 3: 재고추가 4: 메뉴추가 5: 수익확인 (종료는 -1)");
                        System.out.print("번호를 입력하세요: ");
                        adminMenuNum = scanner.nextInt();


                    switch (adminMenuNum) {
                        case 1:
                            System.out.print("변경하실 메뉴의 번호를 입력하세요(1~3): ");
                            int changThisMenu = scanner.nextInt();

                            System.out.print(product[changThisMenu - 1] + "를 무엇으로 바꾸시겠습니까: ");
                            String newProduct = scanner.next();
                            product[changThisMenu - 1] = newProduct;

                            System.out.print(newProduct + "의 가격은 얼마입니까: ");
                            int newPrice = scanner.nextInt();
                            price[changThisMenu - 1] = newPrice;

                            System.out.print(newProduct + "의 재고를 몇 개 등록하시겠습니까: ");
                            int newStock = scanner.nextInt();
                            stock[changThisMenu - 1] = newStock;

                            System.out.println("메뉴 변경이 완료되었습니다.");
                            System.out.println();
                            continue;

                        case 2:
                            System.out.print("가격변경");
                        case 3:
                            System.out.print("재고추가");
                        case 4:
                            System.out.print("메뉴추가");
                        case 5:
                            System.out.print("현재까지의 수익은 " + totalProfit + "원 입니다.");
                        }

                        if (adminMenuNum == -1) {
                            break;
                        }
                    }
                }
            }

                System.out.print("메뉴번호를 입력하세요: ");
                menuPickNumber = scanner.nextInt();


            if (firstMoney >= price[menuIndex] && stock[menuIndex] > 0) {
                provideProduct(menuIndex);
            } else if (firstMoney < price[menuIndex]) {
                notEnoughMoney(menuIndex);
            }
        }
    }

    public static void provideProduct(int menuIndex) {
        System.out.println();
        System.out.println(product[menuIndex] + " 나왔습니다.");

        firstMoney -= price[menuIndex];
        stock[menuIndex]--;

        System.out.println("잔액이 " + firstMoney + "원 남았습니다.");
        System.out.println(product[menuIndex] + " 재고: " + stock[menuIndex]);
        System.out.println();

        showActionMenu();
    }

    public static void notEnoughMoney(int menuIndex) {
        System.out.println("잔액이 부족합니다: " + firstMoney + "원");

        showActionMenu();
    }

    public static void showActionMenu() {
        System.out.println("1: 계속 구매하기 2: 금액 추가하기 3: 잔돈 반환하기");
        System.out.print("번호를 입력하세요: ");
        actionNumber = scanner.nextInt();

        switch (actionNumber) {
            case 1:
                break;
            case 2:
                System.out.print("금액 추가: ");
                plusMoney = scanner.nextInt();
                firstMoney += plusMoney;
                System.out.println("금액이 추가되었습니다. 잔액: " + firstMoney + "원");
                break;
            case 3:
                System.out.println("잔액 " + firstMoney + "원이 반환됩니다. 다음에 또 이용해주세요!");
                firstBuy = true;
                break;
            default:
                System.out.println("잘못된 번호를 선택했습니다.");
        }
    }

    public static void main(String[] args) {
        initialize();
        user();
        return;
    }
}
