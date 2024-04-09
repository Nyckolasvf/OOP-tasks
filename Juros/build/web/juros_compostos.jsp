<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculo juros compostos</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        <h1>Calculo de juros compostos:</h1>
                
        <form action="" method="get">
            <input type="number" name="capital_inicial" placeholder="Capital Inicial:"/>
            <input type="number" name="juros" placeholder="Taxa de Juros:"/>
            <input type="number" name="tempo" placeholder="Tempo:"/>
            <input type="submit" value="Calcular"/>
        </form>

        <%
            try{
                double capital_inicial, juros, montante = 1;
                int tempo;

                capital_inicial = Double.valueOf(request.getParameter("capital_inicial"));
                juros = Double.valueOf(request.getParameter("juros"));
                tempo = Integer.valueOf(request.getParameter("tempo"));
        %>
        <br>

        <table>
            <tr>
                <th>Mês</th>
                <th>Montante</th>
            </tr>
                <%
                    for (double i = 1; i <= apli; i++){
                        montante = cap * Math.pow((1 + (jur/100)), (i / 12));
                        %><tr><%
                            %><th><%
                            out.println(String.format("%.0f", i));
                                %></th><%
                            %><th><%
                            out.println(String.format("%.2f",montante));
                                %></th>
                        </tr>

                <% } %>
            </table>
            <br>
            <h2 id="info">
                Informações:<br><br>
                <%
        out.println("Taxa de juros = " + String.format("%.0f", jur) + "%");%><br><br><%
        out.println("Tempo de aplicação = " + apli + " meses");%><br><br><%
        out.println(String.format("Lucro obtido: R$ %.2f ", (montante-cap)));%><br><br><% 
                out.println(String.format("Valor total: R$ %.2f", montante)); 

            } catch(NullPointerException e){
                out.println(" ");
            }

                %>
            </h2>

    </body>
</html>
