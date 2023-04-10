package com.example.cubatouristguide;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class HelperTextReader extends Activity {

    public static String getJSONFileFromAssets(Context context, String fileName)  {

        String textFromJSON ="";

        try {
            AssetManager manager = context.getAssets();
            InputStream file = manager.open(fileName);
            byte[] formArray = new byte[file.available()];
            file.read(formArray);
            file.close();

            textFromJSON = new String(formArray, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return textFromJSON;
    }

}
