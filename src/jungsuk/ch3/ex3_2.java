package jungsuk.ch3;

public class ex3_2 {
    public static void main(String[] args) {
        int numOfApples = 123; // 사과 개수
        int sizeOfBucket = 10; // 바구니에 담을 수 있는 사과 개수
        int numOfBucket = numOfApples / sizeOfBucket + (numOfApples % sizeOfBucket > 0 ? 1 : 0); // 모든 사과를 담는 데 필요한 바구니 수

        System.out.println("필요한 바구니의 수: " + numOfBucket);
    }
}
