package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();
        String mainName;
        String placeOfOrigin;
        String description;
        String image;
        ArrayList<String> ingredientList = new ArrayList<>();
        ArrayList<String> alsoKnownAs = new ArrayList<>();

        if (json != null) {
            try {
                JSONObject sandwichObject = new JSONObject(json);
                JSONObject nameObject = sandwichObject.getJSONObject("name");

                mainName = nameObject.getString("mainName");
                placeOfOrigin = sandwichObject.getString("placeOfOrigin");
                description = sandwichObject.getString("description");
                image = sandwichObject.getString("image");

                JSONArray ingredients = sandwichObject.getJSONArray("ingredients");
                for (int i = 0; i < ingredients.length(); i++) {
                    ingredientList.add(ingredients.getString(i));
                }

                JSONArray alsoKnown = nameObject.getJSONArray("alsoKnownAs");
                for (int i = 0; i < alsoKnown.length(); i++) {
                    alsoKnownAs.add(alsoKnown.getString(i));
                }

                sandwich.setMainName(mainName);
                sandwich.setAlsoKnownAs(alsoKnownAs);
                sandwich.setIngredients(ingredientList);
                sandwich.setImage(image);
                sandwich.setPlaceOfOrigin(placeOfOrigin);
                sandwich.setDescription(description);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return sandwich;
    }
}
