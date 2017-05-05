package com.example.marcgayraud.keybug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by MarcGAYRAUD on 05/05/2017.
 */

public class DeckMenu extends AppCompatActivity {
    ListView mListView;
    //TODO : get the position from intent
    //int deckPosition = getIntent.getExtras().getInt("deckPosition");
    int position = 1;

    //Permet d afficher tous les decks en colonne sur l ecran principal via le listView
    public void displayFiches()
    {
        mListView = (ListView) findViewById(R.id.listView);

        /*
        mListView.setClickable(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Object o = mListView.getItemAtPosition(position);
                if(position == 1)
                {
                    Intent intent = new Intent(getApplicationContext(), AddDeck.class);
                    intent.putExtra("deckPosition", position);
                    startActivityForResult(intent, 1);
                }
                /* write you handling code like...
                String st = "sdcard/";
                File f = new File(st+o.toString());
                // do whatever u want to do with 'f' File object

            }
        });
        */

        String[] fiches = Singleton.getInstance().getBDD().mesDecks.get(position).getListFiche();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DeckMenu.this,
                android.R.layout.simple_list_item_1, fiches);
        mListView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.deck_menu);

        //Initialisation de la Base de donnes si jamais initialisee
        //Affichage des decks
        displayFiches();

        /*
        //Button lancant l activity AddDeck
        Button addingDeck = (Button) findViewById(R.id.addDeck);

        //Lors du clic de ce bouton
        addingDeck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddDeck.class);
                startActivityForResult(intent, 1);
            }
        });
        */
    }
}
