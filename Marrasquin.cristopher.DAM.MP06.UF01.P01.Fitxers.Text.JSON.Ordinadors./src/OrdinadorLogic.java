import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OrdinadorLogic {
    private final Gson gson;
    {
        this.gson = new GsonBuilder()
                .excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT) // Exclou camps 'transient'
                .setPrettyPrinting() // Format JSON bonic
                .create();
    }
    public String serializeOrdinador(Ordinador ordinador) {
        return gson.toJson(ordinador);
    }
    public String serializeOrdinadors(List<Ordinador> ordinadors) {
        return gson.toJson(ordinadors);
    }
    public Ordinador deserializeOrdinador(String json) {
        return gson.fromJson(json, Ordinador.class);
    }
    public List<Ordinador> deserializeOrdinadors(String json) {
        Type listType = new TypeToken<ArrayList<Ordinador>>() {}.getType();
        return gson.fromJson(json, listType);
    }
    public void writeToFile(String filename, String json) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(json);
            System.out.println("S'ha gravat correctament al fitxer: " + filename);
        } catch (IOException e) {
            System.err.println("Error en escriure al fitxer: " + e.getMessage());
        }
    }
    public String readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            return json.toString();
        } catch (IOException e) {
            System.err.println("Error en llegir del fitxer: " + e.getMessage());
            return null;
        }
    }
}
