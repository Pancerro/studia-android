package com.example.widoki_list_adaptery_paski_aplikacji;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ShareActionProvider;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterView.OnItemClickListener itemClickListener= new AdapterView.OnItemClickListener() {
            public  void  onItemClick(AdapterView<?> listView, View v,int position,long id){
                if(position==0){
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView=findViewById(R.id._dynamic);
       listView.setOnItemClickListener(itemClickListener);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_create_order:
                Intent intent=new Intent(this,OrderActivity.class);
                startActivity(intent);
                return  true;
            case  R.id.action_settings:
                return  true;
            case R.id.action_share:
                setIntent();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private ShareActionProvider shareActionProvider;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        //MenuItem menuItem=menu.findItem(R.id.action_share);
       //shareActionProvider= (ShareActionProvider) menuItem.getActionProvider();
       // setIntent();

        return super.onCreateOptionsMenu(menu);
    }

    private void setIntent() {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"text");
        shareActionProvider.setShareIntent(intent);
    }

}
