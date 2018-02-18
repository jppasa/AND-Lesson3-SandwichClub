package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonSandwich = new JSONObject(json);

            JSONObject jsonName = jsonSandwich.getJSONObject("name");

            String mainName = jsonName.getString("mainName");
            JSONArray arrayKnownAs = jsonName.getJSONArray("alsoKnownAs");

            List<String> alsoKnownAs = new ArrayList<>(arrayKnownAs.length());

            for (int i = 0; i < arrayKnownAs.length(); ++i) {
                String name = arrayKnownAs.getString(i);
                alsoKnownAs.add(name);
            }

            String placeOfOrigin = jsonSandwich.getString("placeOfOrigin");
            String description = jsonSandwich.getString("description");
            String image = jsonSandwich.getString("image");

            JSONArray arrayIngredients = jsonSandwich.getJSONArray("ingredients");

            List<String> ingredients = new ArrayList<>(arrayIngredients.length());

            for (int i = 0; i < arrayIngredients.length(); ++i) {
                String ingredient = arrayIngredients.getString(i);
                ingredients.add(ingredient);
            }

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
