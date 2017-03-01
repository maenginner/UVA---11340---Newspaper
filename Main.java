
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;
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
        HashMap <Character, Double> table= new HashMap<>();        
        // M Between 0 and 150000
        int M;
        //Total value of processing text
        double value = 0.0;
        // N Between 0 and 5
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            K = Integer.parseInt(br.readLine());
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                table.put(st.nextToken().charAt(0), Double.parseDouble(st.nextToken())/100);
            }
            M = Integer.parseInt(br.readLine());
            for (int j = 0; j < M; j++) {
               char[] line =br.readLine().toCharArray();
               for (Character c: line){
                   if (table.containsKey(c))value+=table.get(c);
               }
            }
          
            System.out.println(String.format(Locale.ENGLISH, "%.2f", value) + "$");
            value = 0.0;
            table.clear();
        }
        br.close();
    }
}
