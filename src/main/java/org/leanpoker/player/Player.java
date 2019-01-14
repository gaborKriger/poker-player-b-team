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

            List<String> holeCardsRank = new ArrayList<>();

            for (int i = 0; i < players.size() ; i++) {
                JsonObject player = players.get(i).getAsJsonObject();
                JsonArray myCards = player.get("hole_cards").getAsJsonArray();

                String name = player.get("name").getAsString();

                for (int j = 0; j < myCards.size(); j++) {
                    JsonObject cards = myCards.get(j).getAsJsonObject();
                    String rank = cards.get("rank").getAsString();
                    holeCardsRank.add(rank);
                }
            }

            if(holeCardsRank.size() > 0){
                return 5;
            } else {
                return 2;
            }


        } catch (Exception e) {
            return 0;

        }

    }

    public static void showdown(JsonElement game) {

    }
}
