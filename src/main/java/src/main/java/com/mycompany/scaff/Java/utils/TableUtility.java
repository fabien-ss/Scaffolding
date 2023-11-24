package src.main.java.com.mycompany.scaff.Java.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableUtility {
    public static String chargerModele(String cheminFichier) {
        StringBuilder contenu = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                contenu.append(ligne).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenu.toString();
    }
    public static void ecrireLettre(String contenu, String cheminFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
            writer.write(contenu);
            System.out.println("Scaffolding " + cheminFichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String ToJavaFormat(String fieldName){
        String retour = fieldName;
        List<String> regex = new ArrayList();//<String>();
        for (int i = 0; i < retour.length(); i++) {
            String field = retour.charAt(i) + "";
            if(field.equals("_") & i < retour.length()){
                regex.add(field + retour.charAt(i+1));   
            }
        }
        for (String string : regex) {
            retour = retour.replace(string, (string.charAt(1)+"").toUpperCase());
        }
        return retour;
    }
    public static String firtLetterToUpper(String text){
        return text.substring(0,1).toUpperCase().concat(text.substring(1));
    }
}