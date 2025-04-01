<%-- 
    Document   : index
    Created on : Mar 27, 2025, 4:56:52 PM
    Author     : cellul4r
--%>
<%@page import="main.CurrencyConverter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! CurrencyConverter currencyConverter = new CurrencyConverter(); %>
<%! String[] currencyList = currencyConverter.getCurrencyList(); %>
   
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
                    <input name="sourceCurrencyAmount" type="number" step="any" min="0" placeholder="1.00" required>
                </label><br>
                <label>
                    From
                    <select name="sourceCurrency">
                        <% for(int i = 0; i < currencyList.length; i++) { %>
                        <option value=<%=currencyConverter.getCurrencyValue(i) %>> <%=currencyConverter.getCurrency(i) %></option>
                        <% } %>
                    </select>
                </label>
                <label>
                    To
                    <select name="targetCurrency">
                        <% for(int i = 0; i < currencyList.length; i++) { %>
                        <option value=<%=currencyConverter.getCurrencyValue(i) %>> <%=currencyConverter.getCurrency(i) %></option>
                        <% } %>
                    </select>
                </label><br>
                <input type="submit" value="Convert">
            </form>
        </div>
        
        <% 
            if(request.getMethod().equals("POST")) {
                double sourceCurrencyAmount = Double.parseDouble(request.getParameter("sourceCurrencyAmount"));
                String sourceCurrency = request.getParameter("sourceCurrency");
                String targetCurrency = request.getParameter("targetCurrency");
                currencyConverter.setSourceCurrencyAmount(sourceCurrencyAmount);
                currencyConverter.setSourceCurrency(sourceCurrency);
                currencyConverter.setTargetCurrency(targetCurrency);
                currencyConverter.convertCurrency(); 
                double targetCurrencyAmount = currencyConverter.getTargetCurrencyAmount();
                %>
                <h1><%= sourceCurrencyAmount%> <%=sourceCurrency%> = 
                <%= String.format("%.5f", targetCurrencyAmount)%> <%=targetCurrency%></h1>
        <% } %>
        
    </body>
</html>
