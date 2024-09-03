package ch.teko.bir.jumpdude.Scores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.Strictness;
import com.google.gson.stream.JsonReader;

public class ScoresController {

    private final String filePath = "C:\\temp\\ranking.json";

    public ScoresTableModel loadJson()
    {        
        CreateFileIfNotExists(filePath);
        Score[] scores = null;

        var jsonFile = new File(filePath);
        try {
            StringBuilder stringBuilder;
            try (java.io.BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonFile))) {
                stringBuilder = new StringBuilder();
                var line = bufferedReader.readLine();
                while (line != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(System.lineSeparator());
                    line = bufferedReader.readLine();
                }
            }
        
            var scoresJson = stringBuilder.toString();
            System.out.println(scoresJson);
            
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new StringReader(scoresJson));
            scores = gson.fromJson(reader, Score[].class);
            reader.setStrictness(Strictness.LENIENT);
        } catch (Exception e) {
        }
        return new ScoresTableModel(scores);
    }

    public void saveJson(Score[] scores)
    {       
        Gson gson = new Gson();
        String json = gson.toJson(scores);

        CreateFileIfNotExists(filePath);

        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println(json);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

    private void CreateFileIfNotExists(String filePath)
    {
        File file = new File(filePath);
 
        if (!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }
}
