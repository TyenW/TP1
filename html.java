import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class html {
    static String getHtml(String endereco) {
        StringBuilder resp = new StringBuilder();
        try {
            URL obj = new URL(endereco);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Método de requisição
            con.setRequestMethod("GET");

            // Código de resposta da conexão
            int responseCode = con.getResponseCode();

            // Se a conexão foi bem-sucedida (código 200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    resp.append(inputLine);
                }

                // Fecha os buffers
                in.close();
            } else {
                System.out.println("Erro na conexão: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp.toString();
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String nome;

        while (!(nome = ler.nextLine()).equals("FIM")) {
            String endereco = ler.nextLine();
            String html = getHtml(endereco);

            // Array to store the counts of each character type
            int[] counts = new int[28];
            // String containing all the vowels and accented vowels
            String vowels = "aeiouáéíóúàèìòùãõâêîôû";
            // Iterate over each character in the HTML content
            for (char c : html.toCharArray()) {
                // Find the index of the character in the vowels string
                int index = vowels.indexOf(c);
                if(index>30){

                    System.out.println("Valor de C = "+c);
                    System.out.println("Valor de INDEX = "+index);
                }
                // If the character is a vowel, increment the corresponding count
                if (index != -1) {
                    counts[0]++;
                } 
                // If the character is a letter but not a vowel, increment the consonant count
                else if (Character.isLetter(c)) {
                    counts[22]++;
                } 
                // If the character is a '<', increment the count for '<'
                else if (c == '<') {
                    counts[23]++;
                } 
                // If the character is a '>', increment the count for '>'
                else if (c == '>') {
                    counts[24]++;
                }
            }

            System.out.println("a(x " + counts[0] + ") e(x " + counts[1] + ") i(x " + counts[2] + ") o(x " + counts[3] + ") u(x "
                + counts[4] + ") " +
                "á(x " + counts[5] + ") é(x " + counts[6] + ") í(x " + counts[7] + ") ó(x " + counts[8] + ") ú(x " + counts[9]
                + ") " +
                "à(x " + counts[10] + ") è(x " + counts[11] + ") ì(x " + counts[12] + ") ò(x " + counts[13] + ") ù(x "
                + counts[14] + ") " +
                "ã(x " + counts[15] + ") õ(x " + counts[16] + ") â(x " + counts[17] + ") ê(x " + counts[18] + ") î(x "
                + counts[19] + ") " +
                "ô(x " + counts[20] + ") û(x " + counts[21] + ") consoante(x " + counts[22] + ") <(x " + counts[23]
                + ") >(x " + counts[24] + ") " + nome + "(x 26).");
        }
        ler.close();
    }
}
