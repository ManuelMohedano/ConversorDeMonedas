import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda realizaCambio(String monedaBase, String monedaObjetivo, double cantidad){
        String llave ="b1701122247ab8055158937a";
        var url = "https://v6.exchangerate-api.com/v6/"+llave+"/pair/"+monedaBase+"/"+monedaObjetivo+"/"+cantidad;
        URI direccion = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try{
            HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("No pude realizar la conversión");
        }
    }
}
