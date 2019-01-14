package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "Version 0.1";

    public static int betRequest(JsonElement request) {

        JsonObject root = request.getAsJsonObject();
        JsonArray players = root.getAsJsonArray("players");
        JsonArray communityCards = root.getAsJsonArray("community_cards");

        for (int i = 0; i < players.size() ; i++) {
            JsonObject player = players.get(i).getAsJsonObject();
            player.get("hole_cards");
        }


        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
