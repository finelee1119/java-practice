package izen.vendingMachine3.dto;

public record SalesDto(int productId, String productName, int sumSalesAmount, int countSales, String userId, String userName, int userBalance) {

    public static SalesDto ofProductName(int productId, String productName, int sumSalesAmount, int countSales) {
        return new SalesDto(productId, productName, sumSalesAmount, countSales, null, null, 0);
    }

    public static SalesDto ofUser(String userId, String userName, int sumSalesAmount, int userBalance) {
        return new SalesDto(0, null, sumSalesAmount, 0, userId, userName, userBalance);
    }

    @Override
    public String toString() {
        if (userId != null && userName != null) {
            return " " + userId + " \t\t " + userName + " \t " + sumSalesAmount + " \t\t " + userBalance;
        } else {
            return " " + productId + " \t\t " + productName + " \t " + sumSalesAmount + "\t\t\t" + countSales;
        }
    }
}