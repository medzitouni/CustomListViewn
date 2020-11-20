package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView malist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        malist = findViewById(R.id.listviewperso);
        
        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
        HashMap<String, String> map;

        map = new HashMap<>();
        map.put("titre", "Word");
        map.put("description", "Editeur");
        map.put("img", String.valueOf(R.drawable.word));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Excel");
        map.put("description", "Tableur");
        map.put("img", String.valueOf(R.drawable.excel));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "PowerPoint");
        map.put("description", "logiciel de présentation");
        map.put("img", String.valueOf(R.drawable.powerpoint));
        listItem.add(map);

        map = new HashMap<>();
        map.put("titre", "Outlook");
        map.put("description", "Client de courrier électronqie");
        map.put("img", String.valueOf(R.drawable.word));
        listItem.add(map);

        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),
                listItem,R.layout.activity_list_item,
                new String[]{"img", "titre", "description"},
                new int[] {R.id.img, R.id.titre, R.id.description});


        malist.setAdapter(adapter);
        malist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView , View view , int position ,long arg3)
            {

                Toast.makeText(getApplicationContext(), listItem.get(position).get("titre")+"", Toast.LENGTH_LONG).show();
            }
        });
        malist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                            adb.setTitle( "Item selected" );
                            adb.setMessage( "Votre choix = "+ listItem.get(position).get("titre"));
                            adb.setPositiveButton("ok", null);
                            adb.show();
return true;
            }
        });
    }
}