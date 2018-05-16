import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class Data {
    private ArrayList<ArrayList<String>> readings;

    public Data(){
        readings = new ArrayList<>();
    }

    public void addNewReading(ArrayList<String> data){
        readings.add(data);
    }

    public void storeToFile(){
        String dataToStore = "[\n";
        for (int i = 0; i < readings.size(); i++){
            dataToStore += prepareDataToStore(readings.get(i));
            if (i != readings.size() - 1){
                dataToStore += ",\n";
            } else {
                dataToStore += "";
            }
        }
        dataToStore += "\n]";
        WriterToFile.storeDataToTextFile(dataToStore);
    }

    /**
     * Given a ArrayList of Strings return a digestible form for the server
     * @param data [Asus Nexus 7, 0, 100, 4274]
     * @return ["Asus Nexus 7", "0", "100", "4274"]
     */
    private String prepareDataToStore(ArrayList<String> data){
        String output = "[";
        for(int i = 0; i < data.size(); i++){
            output += "\"" + data.get(i);
            if (i != data.size() - 1){
                output += "\",";
            } else {
                output += "\"";
            }
        }

        output += "]";

        return output;
    }

    public ArrayList<String> convertFromJSONtoArrayList(String input) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        return gson.fromJson(input, type);
    }
}
