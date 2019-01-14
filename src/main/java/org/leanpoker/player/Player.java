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
            JsonObject root = request.getAsJsonObject();
            JsonArray players = root.getAsJsonArray("players");
            JsonArray communityCards = root.getAsJsonArray("community_cards");

            List<String> holeCardsrank = new ArrayList<>();
            int myStack;

            for (int i = 0; i < players.size() ; i++) {
                JsonObject player = players.get(i).getAsJsonObject();
                JsonArray myCards = player.get("hole_cards").getAsJsonArray();

                String name = player.get("name").getAsString();

                for (int j = 0; j < myCards.size(); j++) {
                    JsonObject cards = myCards.get(j).getAsJsonObject();
                    String rank = cards.get("rank").getAsString();
                    holeCardsrank.add(rank);
                }

                if(name.equals("B team")){
                    myStack = player.get("stack").getAsInt();
                    if(holeCardsrank.get(0).equals(holeCardsrank.get(1))){
                        return myStack;
                    }
                }


            }

            return 0;

        } catch (Exception e) {
            return 0;

        }

    }

    public static void showdown(JsonElement game) {

    }
}
