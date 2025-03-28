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
    
    // Only from Thailand Baht (THB) to ... 
    private static String[] exchangeRateStr = {"THB_USD", "THB_VND", "THB_JPY"};
    private static double[] exchangeRate = {0.0294649, 751.709, 4.44535};
    private String sourceCurrency;
    private double sourceCurrencyAmount;
    private String targetCurrency;
    private double targetCurrencyAmount;
    
    public CurrencyConverter() {
        sourceCurrency = "THB";
        sourceCurrencyAmount = 1.0;
        targetCurrency = "USD";
        convertCurrency();
    }
    public void convertCurrency() {
        int idx = -1;
        String userExchangeRate = sourceCurrency + "_" + targetCurrency;
        System.out.println(userExchangeRate);
        for(int i = 0; i < exchangeRateStr.length; i++) {
            if(exchangeRateStr[i].equalsIgnoreCase(userExchangeRate)) {
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            System.out.printf("CAN NOT FIND exchange Rate: From %s to %s\n", sourceCurrency, targetCurrency);
            return;
        }
        targetCurrencyAmount = sourceCurrencyAmount * exchangeRate[idx];
    }
    
    /**
     * @return the exchangeRate
     */
    public static String[] getExchangeRateStr() {
        return exchangeRateStr;
    }

    /**
     * @param aExchangeRateStr the exchangeRate to set
     */
    public static void setExchangeRateStr(String[] aExchangeRateStr) {
        exchangeRateStr = aExchangeRateStr;
    }
    
    
    /**
     * @return the sourceCurrency
     */
    public String getSourceCurrency() {
        return sourceCurrency;
    }

    /**
     * @param sourceCurrency the sourceCurrency to set
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
     * @param sourceCurrencyAmount the sourceCurrencyAmount to set
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
     * @param targetCurrency the targetCurrency to set
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
     * @param targetCurrencyAmount the targetCurrencyAmount to set
     */
    public void setTargetCurrencyAmount(double targetCurrencyAmount) {
        this.targetCurrencyAmount = targetCurrencyAmount;
    }

    /**
     * @return the exchangeRate
     */
    public static double[] getExchangeRate() {
        return exchangeRate;
    }

    /**
     * @param aExchangeRate the exchangeRate to set
     */
    public static void setExchangeRate(double[] aExchangeRate) {
        exchangeRate = aExchangeRate;
    }
    
    
}
