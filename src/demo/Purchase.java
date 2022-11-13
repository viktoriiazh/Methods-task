package demo;

import java.text.DecimalFormat;

import utils.Constants;

import java.util.Scanner;

public class Purchase {
    static double purchaseSum;
    static String purchaseSumRounded;
    static double discount;
    static String discountRounded;
    static int extraRate;
    static double totalSum;
    static String totalSumRounded;
    static final int SUM_1 = 5000;
    static final int SUM_2 = 10000;
    static Scanner scan;

    public static void main(String[] args) {

        processAndShow();
    }

    private static void doInputs() {

        System.out.println(Constants.ENTER_MSG);

        scan = new Scanner(System.in);
        purchaseSum = scan.nextDouble();
        scan.close();
    }

    //Метод обчислення знижки
    private static double calcDiscount(double purchaseSum) {
        return purchaseSum * extraRate / 100;
    }

    //Метод фільтрації введених даних
    private static void filterData(double purchaseSum) {

        if (purchaseSum <= SUM_1) {
            extraRate = 5;
        } else if (purchaseSum > SUM_1 && purchaseSum <= SUM_2) {
            extraRate = 10;
        } else extraRate = 15;
    }

    //Метод обчислання суми до оплати із врахуванням знижки
    private static double calcAmountTotal(double purchaseSum, double discount) {
        return purchaseSum - discount;
    }

    //Метод округлення значень
    public static String roundValue(double value) {
        return new DecimalFormat("#.00").format(value);
    }

    //Метод виводу інформації
    static private void showInfo() {

        System.out.println(Constants.PURCHASE_MSG + purchaseSumRounded
                + Constants.DISCOUNT_MSG + discountRounded
                + Constants.AMOUNT_MSG + totalSumRounded);
    }

    //Метод обробки даних та їх виводу
    static private void processAndShow() {

        doInputs();
        filterData(purchaseSum);
        discount = calcDiscount(purchaseSum);
        totalSum = calcAmountTotal(purchaseSum, discount);

        purchaseSumRounded = roundValue(purchaseSum);
        discountRounded = roundValue(discount);
        totalSumRounded = roundValue(totalSum);

        showInfo();
    }
}
