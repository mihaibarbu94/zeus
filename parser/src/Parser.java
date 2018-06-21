import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.util.Pair;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Parser {
    private static final String PATH = "startbootstrap/chart.txt";
    private static ArrayList<ArrayList<String>> data;
    public static void main(String[] args) throws IOException {
        jsonToString();
        ArrayList<Pair> dataPoints = parseStringToArray(2, 4);
        ArrayList<Pair> dataWithAmendedTimes = amendTime(dataPoints);
        constructDataForChart(dataWithAmendedTimes);

    }

    /**
     * Store data to a text file.
     */
    public static void jsonToString() throws IOException {
        String contents = readFile(StandardCharsets.UTF_8);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ArrayList<String>>>(){}.getType();
        data = gson.fromJson(contents, type);

        System.out.println(data);

    }

    static ArrayList<Pair> parseStringToArray(int time, int measurment){
        ArrayList<Pair> result = new ArrayList<>();
        for (ArrayList<String> aData : data) {
            Pair point = new Pair<>(Integer.parseInt(aData.get(time)),
                                    Integer.parseInt(aData.get(measurment)));
            result.add(point);
        }

        return result;
    }

    static void constructDataForChart(ArrayList<Pair> data){
        String result =  "data: [\n";
        for (int i = 0; i < data.size(); i++) {
            result += "{ \nx: ";
            result += data.get(i).getKey() + ",\n";
            result += "y: ";
            result += data.get(i).getValue() + "\n";
            result += "}";

            if (i < data.size() - 1) {
                result += ",";
            }
        }
        result += "],";

        System.out.println(result);
    }

    static ArrayList<Pair> amendTime (ArrayList<Pair> data){
        ArrayList<Pair> result = new ArrayList<>();

        int time = 0;
        for (int i = 0; i < data.size() - 1; i++){
            Pair point = new Pair<>(time +
                                Integer.parseInt(data.get(i).getKey().toString()),
                                Integer.parseInt(data.get(i).getValue().toString()));
            result.add(point);

            if (Integer.parseInt(data.get(i).getKey().toString()) >
                Integer.parseInt(data.get(i + 1).getKey().toString())) {

                time += Integer.parseInt(data.get(i).getKey().toString());
            }
        }
        Pair point = new Pair<>(time +
                Integer.parseInt(data.get(result.size() ).getKey().toString
                        ()),
                Integer.parseInt(data.get(result.size()).getValue().toString
                        ()));
        result.add(point);

        return result;
    }

    static String readFile(Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(PATH));
        return new String(encoded, encoding);
    }

}
