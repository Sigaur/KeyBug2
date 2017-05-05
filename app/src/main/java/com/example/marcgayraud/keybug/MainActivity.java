package com.example.marcgayraud.keybug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView mListView;


    //Fonction non utilisee pour l instant
    public void resetBDD(MyApplication myApplication)
    {
        if (myApplication.getBDD().mesDecks.size() == 0)
        {
            myApplication.getBDD().addDeck("DECK1");
            myApplication.getBDD().addDeck("DECK2");
            myApplication.getBDD().mesDecks.get(1).addFiche(new Fiche("Question 1", "1 + 1 = ?", "2"));
            myApplication.getBDD().mesDecks.get(1).addFiche(new Fiche("Question 2", "2 x 3 = ?", "6"));
            myApplication.getBDD().addDeck("DECK3");
            myApplication.getBDD().addDeck("DECK4");
        }
    }


    //Permet d afficher tous les decks en colonne sur l ecran principal via le listView
    public void displayDecks()
    {
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setClickable(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Object o = mListView.getItemAtPosition(position);
                //if(position == 1)
                {
                    Intent intent = new Intent(getApplicationContext(), DeckMenu.class);
                    intent.putExtra("deckPosition", position);
                    startActivityForResult(intent, 1);
                }
                /* write you handling code like...
                String st = "sdcard/";
                File f = new File(st+o.toString());
                // do whatever u want to do with 'f' File object
                */
            }
        });

        String[] decks = Singleton.getInstance().getBDD().getListDeck();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, decks);
        mListView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //Initialisation de la Base de donnes si jamais initialisee
        Singleton.getInstance();
        //Affichage des decks
        displayDecks();

        //Button lancant l activity AddDeck
        Button addingDeck = (Button) findViewById(R.id.addDeck);

        //Lors du clic de ce bouton
        addingDeck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddDeck.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    //Au retour de AddDeck on refresh cette activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}

//Code plus ou moins utile
/*
//mListView = (ListView) findViewById(R.id.listView);

        //MyApplication myApplication = (MyApplication) getApplicationContext();
        //myApplication.setBDD(new BDD());
        //resetBDD(myApplication);
        //displayDecks(myApplication);
//final EditText numberText = (EditText) findViewById(R.id.numberDeck);
        //numberText.setText(MyApplication.getInstance().getBDD().mesDecks.size());
        //recuperation de la liste des Decks


        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

        //Affichage de la liste des Decks

        //Initialisation du bouton AddDeck

                //setContentView(R.layout.add_deck);

                //Intent intent = new Intent(MainActivity.this, AddDeck.class);
                //intent.putExtra("BDD", (Serializable) myBDD);
*/