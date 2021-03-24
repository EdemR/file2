package com.codecool.chessopen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName){
        List<String[]> list = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String row;
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(",");
                list.add(data);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }

        return orderList(list);
    }

    private static List<String> orderList(List<String[]> list) {
        List<Competitor> competitors = new ArrayList<>();
        List<String> orderedList = new ArrayList<>();

        for (String[] strings : list) {
            competitors.add(new Competitor(strings));
        }

        Collections.sort(competitors);

        for (Competitor competitor : competitors) {
            orderedList.add(competitor.getName());
        }
        
        Collections.reverse(orderedList);

        return orderedList;
    }

}
