package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "Version 0.1";

    public static int betRequest(JsonElement request) {

        try {
            JsonObject root = request.getAsJsonObject();
            JsonArray players = root.getAsJsonArray("players");
            JsonArray communityCards = root.getAsJsonArray("community_cards");

            List<String> holeCardsrank = new ArrayList<>();

            for (int i = 0; i < players.size() ; i++) {
                JsonObject player = players.get(i).getAsJsonObject();
                JsonArray myCards = player.get("hole_cards").getAsJsonArray();
                for (int j = 0; j < myCards.size(); j++) {
                    JsonObject cards = myCards.get(j).getAsJsonObject();
                    String rank = cards.get("rank").getAsString();
                    holeCardsrank.add(rank);
                }
            }

            if(holeCardsrank.get(0).equals(holeCardsrank.get(1))){
                return 1000;
            }

            return 0;

        } catch (Exception e) {
            return 0;

        }

    }

    public static void showdown(JsonElement game) {
    }
}
