package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "Version 0.4";

    public static int betRequest(JsonElement request) {

        try {
            System.err.println("1");
            JsonObject root = request.getAsJsonObject();
            System.err.println("2");
            JsonArray players = root.getAsJsonArray("players");
            System.err.println("3");
            List<String> holeCardsRank = new ArrayList<>();
            int myStack;

            for (int i = 0; i < players.size() ; i++) {
                System.err.println("4");
                JsonObject player = players.get(i).getAsJsonObject();
                System.err.println("5");
                JsonArray myCards = player.getAsJsonArray("hole_cards");
                System.err.println("6");
                String name = player.get("name").getAsString();

                for (int j = 0; j < myCards.size(); j++) {
                    System.err.println("7");
                    JsonObject cards = myCards.get(j).getAsJsonObject();
                    System.err.println("8");
                    String rank = cards.get("rank").getAsString();
                    holeCardsRank.add(rank);
                    System.err.println("9");
                }


                if (name.equals("B team")) {
                    System.err.println("10");
                    myStack = player.get("stack").getAsInt();
                    System.err.println("11");
                    if (holeCardsRank.get(0).equals(holeCardsRank.get(1))) {
                        System.err.println("12");
                        return myStack;
                    }

                }

            return 0;
            }

        } catch (Exception e) {
            return 0;
        }

        return 0;
    }

    public static void showdown(JsonElement game) {

    }
}
