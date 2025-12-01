package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CardFilter {

    public List<CardData> getFilteredCards(String csvPath) {

        List<CardData> cards = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length < 6) { 
                    continue; 
                }
                String group = data[1].trim();
                String info = data[2].trim();
                String date = data[3].trim();
                String format = data[4].trim();
                String participants = data[5].trim();
                cards.add(new CardData(group, info, date, format));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cards;
    }
}
