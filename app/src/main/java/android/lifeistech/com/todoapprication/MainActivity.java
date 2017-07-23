package android.lifeistech.com.todoapprication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        editText = (EditText) findViewById(R.id.editText);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int postion, long id) {
                ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();

                Toast.makeText(getApplicationContext(), "Touch", Toast.LENGTH_SHORT).show();

                String item = (String)adapter.getItem(postion);
                adapter.remove(item);
                adapter.add(item);


            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,int postion, long id) {
                ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();

                String item = (String)adapter.getItem(postion);
                adapter.remove(item);

                return false;
            }
        });


    }

    public void add (View v) {
        String text;
        text = editText.getText().toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

        adapter.add(text);


    }



}
