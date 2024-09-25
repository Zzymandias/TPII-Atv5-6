public class Main {
    public static void main(String[] args) {
        String apiKey = "sua-chave-da-api-aqui";
        Consomeapi api = new Consomeapi(apiKey);

        try {
            String response = Consomeapi.getResponse("Como está o tempo hoje?");
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

