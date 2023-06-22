package com.example.secondassignment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private ListData[] listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Retrieve the saved data from SharedPreferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String json = sharedPreferences.getString("myListData", null);

        // Convert the JSON string back to an array of ListData objects
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ListData>>() {}.getType();
        ArrayList<ListData> dataList = gson.fromJson(json, type);

        if (dataList != null) {
            listData = dataList.toArray(new ListData[0]);
        } else if (listData == null) {
            // If no data is found in SharedPreferences, initialize the array with default values
            listData = new ListData[]{
                    new ListData("\"While in the kids there's around 300 bones, " +
                            "but they connect together when the kids grow up." , R.drawable.kidsbones),

                    new ListData("The mandible is a bone found in all jawed vertebrates.", R.drawable.mandible),

                    new ListData("The Femur is the thighbone." +
                            "It connects to the pelvis and the knee at " +
                            "the upper end and forms a hinge with the lower leg. ", R.drawable.femur),

                    new ListData("Most humans have 12 pairs of rib bones with " +
                            "one from each pair on each side of the chest.", R.drawable.ribcage),

                    new ListData("The scapula forms the back of the shoulder girdle. " +
                            "In humans, it is a flat bone, roughly triangular in shape, " +
                            "placed on a posterolateral aspect of the thoracic cage.", R.drawable.scapula),
            };

            // Save the default data to SharedPreferences
            json = gson.toJson(listData);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("myListData", json);
            editor.apply();
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TheAdapter adapter = new TheAdapter(this, listData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
