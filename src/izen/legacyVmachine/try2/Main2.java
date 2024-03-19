package izen.legacyVmachine.try2;

import java.util.Scanner;

public class Main2 {
    // 초기 세팅
    static final int MAX_PRODUCT = 5;
    static String[] product = new String[MAX_PRODUCT];
    static int[] price = new int[MAX_PRODUCT];
    static int[] stock = new int[MAX_PRODUCT];

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

    // 메인 메서드
    public static void main(String[] args) {
        // 0. 초기값 정리
        Scanner scanner = new Scanner(System.in);
        initialize();

        int currentMoney = 0;
        boolean firstView = true;
        boolean firstInput = true;

        while (true) {
            int plusMoney = 0;
            
            if(firstView) {
                // 초기 화면
                System.out.println("=================================================================");
                System.out.println("자판기 입니다.(번호: 상품(가격)-재고)");
                for (int i = 0; i < MAX_PRODUCT; i++) {
                    if(product[i] != null) {
                        System.out.print(i+1 + ": " + product[i] + "(" + price[i] + "W)-" + stock[i] + "개 ");
                    }
                }
                System.out.println();
                System.out.println("=================================================================");

                if(firstInput) {
                    // 1. 금액 입력
                    System.out.print("돈을 넣어주세요: ");
                    currentMoney = scanner.nextInt();
                    firstInput = false;

                    if(currentMoney == 1004) {
                        while (true) {
                            System.out.println("관리자 페이지 입니다.");
                            System.out.println("1: 메뉴변경 2: 가격변경 3: 재고추가 4: 메뉴추가 5: 수익확인 (종료는 -1)");
                            System.out.print("번호를 입력하세요: ");
                            int adminMenuNumber = scanner.nextInt();

                            int menuChangeNumber;
                            int menuChangeIndex;

                            if (adminMenuNumber == 1) {
                                //메뉴변경
                                System.out.print("변경하실 메뉴 번호를 입력하세요(1~3): ");
                                menuChangeNumber = scanner.nextInt();
                                menuChangeIndex = menuChangeNumber - 1;

                                System.out.print(product[menuChangeIndex] + "를(을) 무엇으로 바꾸시겠습니까?: ");
                                product[menuChangeIndex] = scanner.next();

                                System.out.print(product[menuChangeIndex] + "의 가격은 얼마 입니까?: ");
                                price[menuChangeIndex] = scanner.nextInt();

                                System.out.print(product[menuChangeIndex] + "의 재고를 몇 개 등록하시겠습니까?: ");
                                stock[menuChangeIndex] = scanner.nextInt();

                                System.out.println("메뉴 변경이 완료되었습니다!");
                                System.out.println();

                            } else if (adminMenuNumber == 2) {
                                //가격변경
                                System.out.print("가격을 변경하실 메뉴 번호를 입력하세요(1~3): ");
                                menuChangeNumber = scanner.nextInt();
                                menuChangeIndex = menuChangeNumber - 1;

                                System.out.print(product[menuChangeIndex] + "의 가격을 얼마로 바꾸시겠습니까?: ");
                                price[menuChangeIndex] = scanner.nextInt();

                                System.out.println("가격 변경이 완료되었습니다!");
                                System.out.println();

                            } else if (adminMenuNumber == 3) {
                                //재고추가
                                System.out.print("재고를 변경하실 메뉴 번호를 입력하세요(1~3): ");
                                menuChangeNumber = scanner.nextInt();
                                menuChangeIndex = menuChangeNumber - 1;

                                System.out.print(product[menuChangeIndex] + "의 재고를 몇 개로 바꾸시겠습니까?: ");
                                price[menuChangeIndex] = scanner.nextInt();

                                System.out.println("재고 변경이 완료되었습니다!");
                                System.out.println();

                            } else if (adminMenuNumber == 4) {
                                // 배열이 꽉 찼는지 확인
                                if (product[MAX_PRODUCT - 1] != null) {
                                    System.out.println("더 이상 메뉴를 추가할 수 없습니다! (최대 5개까지 저장 가능)");
                                    System.out.println();
                                }

                                //메뉴추가 (배열에 최대 5개까지만 저장 가능)
                                System.out.print("추가하실 메뉴의 이름을 입력하세요: ");
                                String newProduct = scanner.next();

                                System.out.print("추가하실 메뉴의 가격을 입력하세요: ");
                                int newPrice = scanner.nextInt();

                                System.out.print("추가하실 메뉴의 재고를 입력하세요: ");
                                int newStock = scanner.nextInt();

                                // 배열에 새로운 메뉴 추가
                                for (int i = 0; i < MAX_PRODUCT; i++) {
                                    if (product[i] == null) {
                                        product[i] = newProduct;
                                        price[i] = newPrice;
                                        stock[i] = newStock;

                                        System.out.println("메뉴 추가가 완료되었습니다!");
                                        System.out.println();
                                        break;
                                    }
                                }
                                
                            } else if (adminMenuNumber == 5) {
                                //수익확인
                                System.out.println("현재까지의 수익은 " + "원 입니다.");

                            } else if (adminMenuNumber == -1) {
                                //관리자메뉴 종료
                                break;
                            }

                        }

                        // 초기 상태로 재설정 후 초기화면으로 이동하기
                        currentMoney = 0;
                        firstView = true;
                        firstInput = true;
                        continue; 

                    }
                }

                // 2. 제품번호 입력
                System.out.print("메뉴 입력: ");
                int menuNumber = scanner.nextInt();
                int menuIndex = menuNumber - 1;

                // 2. 메뉴 받기 -> 금액, 재고 차감
                // 3. 잔액 부족 -> 메시지 출력, 금액 충전
                if (currentMoney >= price[menuIndex] && stock[menuIndex] > 0) {
                    System.out.println(product[menuIndex] + " 나왔습니다.");
                    currentMoney -= price[menuIndex];
                    stock[menuIndex]--;
                    System.out.println("잔액: " + currentMoney + "원");
                }
                else if(currentMoney < price[menuIndex]) {
                    System.out.print("잔액이 부족합니다! \n잔액: " + currentMoney + "원");
                    System.out.println();
                }

                firstView = false;

            }

            System.out.println("1: 계속 구매 2: 금액 추가 3: 잔액 반환");
            System.out.print("번호를 입력하세요: ");
            int actionNumber = scanner.nextInt();

            if(actionNumber == 1) {
                // 어떻게 firstView로 돌아가지?
                firstView = true;
            }
            else if (actionNumber == 2) {
                System.out.print("얼마를 추가하시겠습니까: ");
                plusMoney = scanner.nextInt();
                currentMoney += plusMoney;
                System.out.println("금액이 추가되었습니다! 잔액: " + currentMoney + "원");
            }
            // 4. 잔액 반환 -> 초기화면 보여주기
            else if (actionNumber == 3) {
                System.out.println("잔액 " + currentMoney + "원을 반환 합니다.");
                System.out.println("감사합니다. 다음에 또 이용해주세요!");

                // 어떻게 프로세스를 마치고 firstView로 돌아가지?
                // 초기 상태로 재설정
                currentMoney = 0;
                firstView = true;
                firstInput = true;
            }

        }

    }

}
