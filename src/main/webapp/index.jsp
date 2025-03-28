<%-- 
    Document   : index
    Created on : Mar 27, 2025, 4:56:52 PM
    Author     : cellul4r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="currencyConverter" scope="session" class="main.CurrencyConverter" />

<!DOCTYPE html> 
<link rel="stylesheet" href="style.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Currency Converter</title>
    </head>
    <body>
        <h1>Currency Converter</h1>
        <div>
            <form action="index.jsp" method="post">
                <label>
                    Amount:<br>
                    <input name="sourceCurrencyAmount" type="number" step="any" min="0" required>
                </label><br>
                <label>
                    From
                    <select name="sourceCurrency">
                        <option value="THB">THB - Thai Baht</option>
                    </select>
                </label>
                <label>
                    To
                    <select name="targetCurrency">
                        <option value="USD" deafult>USD - United States Dollar</option>
                        <option value="VND">VND - Vietnamese Dong</option>
                        <option value="JPY">JPY - Japanese Yen</option>
                    </select>
                </label><br>
                <input type="submit" value="Convert">
            </form>
        </div>
        <jsp:setProperty name="currencyConverter" property="sourceCurrencyAmount"/>
        <jsp:setProperty name="currencyConverter" property="sourceCurrency"/>
        <jsp:setProperty name="currencyConverter" property="targetCurrency"/>
        <% currencyConverter.convertCurrency(); %>
        <jsp:setProperty name="currencyConverter" property="targetCurrencyAmount"/>
        <%
        double sourceCurrencyAmount = currencyConverter.getSourceCurrencyAmount();
        String sourceCurrency = currencyConverter.getSourceCurrency();
        double targetCurrencyAmount = currencyConverter.getTargetCurrencyAmount();
        String targetCurrency = currencyConverter.getTargetCurrency();
        %>
        <h1><%= sourceCurrencyAmount%> <%=sourceCurrency%> = 
            <%= String.format("%.5f", targetCurrencyAmount)%> <%=targetCurrency%></h1>
    </body>
</html>
