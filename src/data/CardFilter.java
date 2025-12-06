package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.tinylog.Logger;

public class CardFilter {
	
	private static final int ENTRIES_PER_LINE = 4;

    public List<CardData> getFilteredCards(String csvPath) {

        List<CardData> cards = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(csvPath))) {
        	
            String line;

            while ((line = buffer.readLine()) != null) {
 
                String[] data = line.split(",");

                if (data.length < ENTRIES_PER_LINE) continue;
          
                String group = data[0].trim();
                String info = data[1].trim();
                String date = data[2].trim();
                String format = data[3].trim();

                cards.add(new CardData(group, info, date, format));
                
            }

        } catch (IOException exception) {
        	
        	Logger.error("Erro ao acessar o arquivo: " + exception.getStackTrace());
            
        }

        return cards;
        
    }
    
}
