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
        readDataToTextFile();
        ArrayList<Pair> dataPoints = parse();
        constructDataForChart(dataPoints);

    }

    /**
     * Store data to a text file.
     */
    public static void readDataToTextFile() throws IOException {
        String contents = readFile(StandardCharsets.UTF_8);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ArrayList<String>>>(){}.getType();
        data = gson.fromJson(contents, type);

        System.out.println(data);

    }

    static ArrayList<Pair> parse(){
        ArrayList<Pair> result = new ArrayList<>();
        for (ArrayList<String> aData : data) {
            Pair point = new Pair<>(Integer.parseInt(aData.get(2)),
                                    Integer.parseInt(aData.get(4)));
            result.add(point);
        }

        return result;
    }

    static void constructDataForChart(ArrayList<Pair> data){
        String ini =  "data: [\n";
        for (int i = 0; i < data.size(); i++) {
            ini += "{ \nx: ";
            ini += data.get(i).getKey() + ",\n";
            ini += "y: ";
            ini += data.get(i).getValue() + "\n";
            ini += "}";

            if (i < data.size() - 1) {
                ini += ",";
            }
        }
        ini += "],";

        System.out.println(ini);
    }

    static String readFile(Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(PATH));
        return new String(encoded, encoding);
    }

}
