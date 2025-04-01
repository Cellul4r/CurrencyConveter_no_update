/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author cellul4r
 */
public class CurrencyConverter {
    
    public static final String[] EXCHANGE_RATEs_STR = {"AUD-AUD", "AUD-CNY", "AUD-EUR", "AUD-JPY", "AUD-SGD", "AUD-THB", "AUD-VND",
        "CNY-AUD", "CNY-CNY", "CNY-EUR", "CNY-JPY", "CNY-SGD", "CNY-THB", "CNY-VND",
        "EUR-AUD", "EUR-CNY", "EUR-EUR", "EUR-JPY", "EUR-SGD", "EUR-THB", "EUR-VND",
        "JPY-AUD", "JPY-CNY", "JPY-EUR", "JPY-JPY", "JPY-SGD", "JPY-THB", "JPY-VND",
        "SGD-AUD", "SGD-CNY", "SGD-EUR", "SGD-JPY", "SGD-SGD", "SGD-THB", "SGD-VND",
        "THB-AUD", "THB-CNY", "THB-EUR", "THB-JPY", "THB-SGD", "THB-THB", "THB-VND",
        "VND-AUD", "VND-CNY", "VND-EUR", "VND-JPY", "VND-SGD", "VND-THB", "VND-VND",};
    
    // last update 10:00 p.m.
    public static final double[] EXCHANGE_RATEs = {1.00, 4.55, 0.58, 93.36, 0.84, 21.41, 16044.68,
        0.22, 1.00, 0.13, 20.55, 0.19, 4.71, 3580.58,
        1.73, 7.84, 1.00, 161.05, 1.45, 36.95, 27681.00,
        0.011, 0.049, 0.0062, 1.00, 0.0090, 0.23, 171.87,
        1.19, 5.40, 0.69, 111.26, 1.00, 25.44, 19079.89,
        0.047, 0.213, 0.027, 4.36, 0.039, 1.00, 749.56,
        0.000062, 0.00028, 0.000036, 0.0058, 0.000052, 0.0013, 1.00};
    
    private final String[] currencyList = {"AUD - Australian Dollar", "CNY - ChineseYen", "EUR - Euro", "JPY - Japanese Yen",
        "SGD - Singapore Dollar", "THB - Thai Baht", "VND - Vietnamese Dong"};
    
    private String sourceCurrency;
    private double sourceCurrencyAmount;
    private String targetCurrency;
    private double targetCurrencyAmount;

    public CurrencyConverter() {
        sourceCurrency = "THB";
        sourceCurrencyAmount = 1.0;
        targetCurrency = "SGD";
        convertCurrency();
    }

    public void convertCurrency() {
        int idx = -1;
        String userExchangeRate = sourceCurrency + "-" + targetCurrency;
        System.out.println(userExchangeRate);
        for (int i = 0; i < EXCHANGE_RATEs_STR.length; i++) {
            if (EXCHANGE_RATEs_STR[i].equalsIgnoreCase(userExchangeRate)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            System.out.printf("CAN NOT FIND exchange Rate: From %s to %s\n", sourceCurrency, targetCurrency);
            return;
        }
        targetCurrencyAmount = sourceCurrencyAmount * EXCHANGE_RATEs[idx];
    }

    /**
     * @return the exchangeRate
     */
    public static String[] getExchangeRateStr() {
        return EXCHANGE_RATEs_STR;
    }

    /**
     * @return the sourceCurrency
     */
    public String getSourceCurrency() {
        return sourceCurrency;
    }

    /**
     * @param sourceCurrency the
     * sourceCurrency to set
     */
    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    /**
     * @return the sourceCurrencyAmount
     */
    public double getSourceCurrencyAmount() {
        return sourceCurrencyAmount;
    }

    /**
     * @param sourceCurrencyAmount the
     * sourceCurrencyAmount to set
     */
    public void setSourceCurrencyAmount(double sourceCurrencyAmount) {
        this.sourceCurrencyAmount = sourceCurrencyAmount;
    }

    /**
     * @return the targetCurrency
     */
    public String getTargetCurrency() {
        return targetCurrency;
    }

    /**
     * @param targetCurrency the
     * targetCurrency to set
     */
    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    /**
     * @return the targetCurrencyAmount
     */
    public double getTargetCurrencyAmount() {
        return targetCurrencyAmount;
    }

    /**
     * @param targetCurrencyAmount the
     * targetCurrencyAmount to set
     */
    public void setTargetCurrencyAmount(double targetCurrencyAmount) {
        this.targetCurrencyAmount = targetCurrencyAmount;
    }

    /**
     * @return the exchangeRate
     */
    public static double[] getExchangeRate() {
        return EXCHANGE_RATEs;
    }

    /**
     * @return the currencyList
     */
    public String[] getCurrencyList() {
        return currencyList;
    }
    
    public String getCurrency(int idx) {
        return currencyList[idx];
    }
    
    public String getCurrencyValue(int idx) {
        System.out.println(currencyList[idx].split("-")[0]);
        return currencyList[idx].split("-")[0];
    }
}
