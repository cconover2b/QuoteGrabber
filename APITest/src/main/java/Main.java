
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            //Public API:
            //https://run.mocky.io/v3/b2772cea-c31a-4630-836c-a4c9853d6132

            URL url = new URL("https://run.mocky.io/v3/b2772cea-c31a-4630-836c-a4c9853d6132");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //See if connection is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                System.out.println(informationString);


                //JSON simple library Setup with Maven is used to convert strings to JSON
//                JSONParser parse = new JSONParser();
////                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));
//                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));
//
//
//                //Get the first JSON object in the JSON array
//                System.out.println(dataObject.get(0));
//
//                JSONObject quoteData = (JSONObject) dataObject.get(0);
//
//                System.out.println(quoteData.get("title"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}