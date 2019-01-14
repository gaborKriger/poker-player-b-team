package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "Version 0.3";

    public static int betRequest(JsonElement request) {

        try {
            System.err.println("1");
            JsonObject root = request.getAsJsonObject();
            System.err.println("2");
            JsonArray players = root.getAsJsonArray("players");
            System.err.println("3");
            JsonArray communityCards = root.getAsJsonArray("community_cards");
            System.err.println("4");
            List<String> holeCardsrank = new ArrayList<>();
            int myStack;

            for (int i = 0; i < players.size() ; i++) {
                System.err.println("5");
                JsonObject player = players.get(i).getAsJsonObject();
                System.err.println("6");
                JsonArray myCards = player.get("hole_cards").getAsJsonArray();
                System.err.println("7");
                String name = player.get("name").getAsString();

                for (int j = 0; j < myCards.size(); j++) {
                    System.err.println("8");
                    JsonObject cards = myCards.get(j).getAsJsonObject();
                    String rank = cards.get("rank").getAsString();

                    System.err.println("9");
                    holeCardsrank.add(rank);
                }


                /*if(name.equals("B team")){
                    myStack = player.get("stack").getAsInt();
                    if(holeCardsrank.get(0).equals(holeCardsrank.get(1))){
                        return myStack;
                    }
                }*/


            }

            if(holeCardsrank.size() > 0){
                System.err.println("10");
                return 5;
            }
            System.err.println("11");
            return 2;




        } catch (Exception e) {
            return 0;

        }

    }

    public static void showdown(JsonElement game) {

    }
}
