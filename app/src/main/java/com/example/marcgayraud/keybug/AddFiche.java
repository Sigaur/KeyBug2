package com.example.marcgayraud.keybug;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by MarcGAYRAUD on 04/05/2017.
 */

//Classe permettant d ajouter une fiche
public class AddFiche extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_fiche);



        //Bouton confirmation nom de la nouvelle fiche
        Button addingFiche = (Button) findViewById(R.id.addFiche);
        //Case ou l utilisateur entre le nom du deck
        final EditText ficheName = (EditText) findViewById(R.id.nameFiche);
        final EditText question = (EditText) findViewById(R.id.question);
        final EditText reponse = (EditText) findViewById(R.id.reponse);


        //Lors du clic du bouton de comfirmation
        addingFiche.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int deckPosition = getIntent().getExtras().getInt("deckPosition");
                //on verifie que la case n est pas vide
                //TODO : verifier qu il n y a pas de fiches avec le meme nom que celui de la nouvelle fiche
                if(ficheName.getText().toString().length() >= 1 &&
                        question.getText().toString().length() >= 1 &&
                        reponse.getText().toString().length() >= 1)
                {
                    Singleton.getInstance().getBDD().mesDecks.get(deckPosition).addFiche(
                            ficheName.getText().toString(), question.getText().toString(), reponse.getText().toString());
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