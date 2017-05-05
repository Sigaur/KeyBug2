package com.example.marcgayraud.keybug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by MarcGAYRAUD on 04/05/2017.
 */

//Classe permettant d ajouter un deck
public class AddDeck extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_deck);

        //Bouton confirmation nom du nouveau deck
        Button addingDeck = (Button) findViewById(R.id.addDeck);
        //Case ou l utilisateur entre le nom du deck
        final EditText deckName = (EditText) findViewById(R.id.nameDeck);

        //Lors du clic du bouton de comfirmation
        addingDeck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //on verifie que la case n est pas vide
                //TODO : verifier qu il n y a pas de decks avec le meme nom que celui du nouveau deck
                if(deckName.getText().toString().length() >= 1)
                {
                    Singleton.getInstance().getBDD().addDeck(deckName.getText().toString());
                    setResult(RESULT_OK, null);
                    finish();
                }
            }
        });
    }
}



//MyApplication myApplication = (MyApplication) getApplicationContext();
//myApplication.getBDD().addDeck(deckName.getText().toString());
//name.setText(myApplication.getBDD().getListDeck()[4]);