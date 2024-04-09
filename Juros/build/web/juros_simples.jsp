<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculo juros simples</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        <h1>Calculo de juros simples:</h1>
        
        <form action="" method="get">
            <input type="number" name="capital_inicial" placeholder="Capital Inicial:"/>
            <input type="number" name="juros" placeholder="Taxa de Juros:"/>
            <input type="number" name="tempo" placeholer="Tempo:"/>
            <!--<input type="string" name="moeda" placeholder="Moeda:"/>-->
            <input type="submit" value="Calcular"/>
        </form>
                
        <h2>
            <%
                try{
                    double capital_inicial, juros;
                    int tempo;
                    //String moeda;

                    capital_inicial = Double.valueOf(request.getParameter("capital_inicial"));
                    juros = Double.valueOf(request.getParameter("juros"));
                    tempo = Integer.valueOf(request.getParameter("tempo"));
                    //moeda = String.valueOf(request.getParameter("moeda"));

                    double juros_simples = capital_inicial * (juros/100) * (tempo);
                    
                    out.println("Taxa de juros = " + String.format("%.0f", juros) + "%");%><br><br><%
                    out.println("Tempo de aplicação = " + tempo + " meses");%><br><br><%
                    
                    out.println(String.format("Lucro obtido: R$ %.2f ", (juros_simples - capital_inicial)));%><br><br><% 
                    out.println(String.format("Valor total: R$ %.2f", juros_simples));
            

                }catch(NullPointerExeption e){
                out.println(" ");
                }
            %>
        </h2>
        
    </body>
</html>
