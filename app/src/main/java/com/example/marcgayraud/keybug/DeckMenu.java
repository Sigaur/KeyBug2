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

import static android.R.attr.data;

/**
 * Created by MarcGAYRAUD on 05/05/2017.
 */

public class DeckMenu extends AppCompatActivity {
    ListView mListView;

    //Permet d afficher tous les decks en colonne sur l ecran principal via le listView
    public void displayFiches(int deckPosition)
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
        System.out.println("Trace NombreFiches : " + Singleton.getInstance().getBDD().mesDecks.get(deckPosition).mesFiches.size());
        String[] fiches = Singleton.getInstance().getBDD().mesDecks.get(deckPosition).getListFiche();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DeckMenu.this,
                android.R.layout.simple_list_item_1, fiches);
        mListView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.deck_menu);

        final int deckPosition = getIntent().getExtras().getInt("deckPosition");
        System.out.println("Trace PositionDeck : " + deckPosition);
        //Initialisation de la Base de donnes si jamais initialisee
        //Affichage des decks
        displayFiches(deckPosition);


        //Button pour ajouter une fiche le Deck
        Button addFiche = (Button) findViewById(R.id.addFiche);

        //Lors du clic de ce bouton
        addFiche.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AddFiche.class);
                intent.putExtra("deckPosition", deckPosition);
                startActivityForResult(intent, 2);

            }
        });

        //Button pour supprimer le Deck
        Button supprDeck = (Button) findViewById(R.id.supprDeck);

        //Lors du clic de ce bouton
        supprDeck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO : Suppresion of Decks
                /*
                Intent intent = new Intent(getApplicationContext(), AddDeck.class);
                startActivityForResult(intent, 1);
                */
            }
        });

        //Au retour de AddFiche on refresh cette activity


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Intent refresh = new Intent(this, DeckMenu.class);
            //int deckPosition = data.getData();
            startActivity(refresh);
            this.finish();
        }
    }

}
