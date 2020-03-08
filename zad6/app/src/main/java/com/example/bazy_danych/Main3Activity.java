package com.example.bazy_danych;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.TimingLogger;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    public static final String EXTRA_ANIMAL="animalNO";
    TextView txt;
    Button btn;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TimingLogger timings = new TimingLogger("TAG", "MethodA");
        timings.reset();
        Log.isLoggable("TAG", Log.VERBOSE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txt = (TextView) findViewById(R.id.output);
        btn = (Button) findViewById(R.id.btn);
        btn.setText("Start 1");
        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(0);
                switch (view.getId()) {
                    case R.id.btn:
                        new UpdateAnimalTask().execute(1000);
                        break;
                }
            }
        };
        btn.setOnClickListener(listener);
        timings.addSplit("work A");
        int animalNo=(Integer)getIntent().getExtras().get(EXTRA_ANIMAL);
        try {
            SQLiteOpenHelper animalDatabeseHelper = new AnimalDatebaseHelper(this);
            SQLiteDatabase db = animalDatabeseHelper.getWritableDatabase();
            Cursor cursor = db.query("ANIMAL",
                    new String[]{"NAME", "AGE", "IMAGE_URL","FAVORITE"},
                    "_id=?", new String[]{Integer.toString(animalNo)},
                    null, null, null);
            if (cursor.moveToFirst()) {
                String nameText = cursor.getString(0);
                String age = cursor.getString(1);
                int imageUrl = cursor.getInt(2);
                boolean isFavorite=(cursor.getInt(3)==1);

                ImageView photo = findViewById(R.id.photo);
                photo.setImageResource(imageUrl);
                photo.setContentDescription(nameText);
                TextView name = findViewById(R.id.name);
                name.setText(nameText);
                TextView description = findViewById(R.id.description);
                description.setText("Jest to " + nameText + ". Ma on " + age + " lat.");
                CheckBox favorite=findViewById(R.id.checkBox);
                favorite.setChecked(isFavorite);
            }
            cursor.close();
        } catch (SQLiteException e){
            Toast toast=Toast.makeText(this,"BAZA DANYCH JEST NIEDOSTEPNA",Toast.LENGTH_SHORT);
            toast.show();
        }
        timings.addSplit("work B");
        timings.reset();
        timings.dumpToLog();
    }
    public  void onFavoriteClicked(View view){
        TimingLogger timings = new TimingLogger("TAG", "methodA");
        int animalNo=(Integer) getIntent().getExtras().get(EXTRA_ANIMAL);
        new UpdateAnimalTask().execute(animalNo);
        timings.addSplit("work onClicked");
        timings.reset();
        timings.dumpToLog();
    }

    private class UpdateAnimalTask extends AsyncTask<Integer,Void,Boolean>{
        ContentValues animalValues;
        protected void onPreExecute(){
            CheckBox favorite=findViewById(R.id.checkBox);
            animalValues=new ContentValues();
            animalValues.put("FAVORITE",favorite.isChecked());
        }
        @Override
        protected Boolean doInBackground(Integer... animals) {
            int animalNo=animals[0];
            SQLiteOpenHelper animalDatabaseHelper=new AnimalDatebaseHelper(Main3Activity.this);
            try{
                SQLiteDatabase db=animalDatabaseHelper.getWritableDatabase();
                db.update("ANIMAL",animalValues,"_id=?",new String[]{Integer.toString(animalNo)});
                db.close();
                return  true;
            } catch (SQLiteException e){
                return  false;
            }
        }
        protected  void onPostExecute(Boolean succes){
            if(!succes){
                Toast toast=Toast.makeText(Main3Activity.this,"BAZA DANYCH JEST NIEDOSTEPNA",Toast.LENGTH_SHORT);
                toast.show();
            }
         progressBar.setVisibility(View.GONE);

        }

       protected void onProgressUpdate (Integer ...values){
            txt.setText("Running..."+ values[0]);
           progressBar.setProgress(values[0]);

       }




    }
}
