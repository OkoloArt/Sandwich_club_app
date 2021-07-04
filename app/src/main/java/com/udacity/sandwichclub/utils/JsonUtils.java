package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();
        String mainName;
        String placeOfOrigin;
        String description;
        String image;
        List<String> ingredientList = new ArrayList<>();
        List<String> alsoKnownAs = new ArrayList<>();

        if (json != null) {
            try {
                JSONObject sandwichObject = new JSONObject(json);
                JSONObject nameObject = sandwichObject.getJSONObject("name");

                mainName = nameObject.getString("mainName");
                placeOfOrigin = nameObject.getString("placeOfOrigin");
                description = nameObject.getString("description");
                image = nameObject.getString("image");

                JSONArray ingredients = nameObject.getJSONArray("ingredients");
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
