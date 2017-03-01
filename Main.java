
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        try{
            solution.procedure();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void procedure() throws Exception {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //K  Between 0 and 100
        int K;
        //Array to store the values
        double[] table;
        //Line read from console
        String[] tableValue;
        // M Between 0 and 150000
        int M;
        //The text
        String text = "";
        //Total value of processing text
        double value = 0.0;
        // N Between 0 and 5
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            K = Integer.parseInt(br.readLine());
            table = new double[0xFF];
            for (int j = 0; j < K; j++) {
                tableValue = br.readLine().split(" ");
                table[tableValue[0].charAt(0)] = Double.parseDouble(tableValue[1]) / 100;
            }
            M = Integer.parseInt(br.readLine());
            for (int j = 0; j < M; j++) {
                text += br.readLine().trim();
            }
            for (int j = 0; j < text.length(); j++) {
                value += table[text.charAt(j)];
            }
            System.out.println(String.format(Locale.ENGLISH, "%.2f", value) + "$");
            value = 0.0;
            text = "";
        }
        br.close();
    }
}
