package org.katolika.lnh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fijanonana> fijanonanaList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fijanonanaList = new ArrayList<>();

        for(int i = 0; i < 14; i++)
        {
            Fijanonana fijanonana = new Fijanonana();
            int title_id = getResources().getIdentifier("titre_" + (i+1) , "string", getPackageName());
            int intro_id = getResources().getIdentifier("intro_" + (i+1) , "string", getPackageName());
            int vavaka_id = getResources().getIdentifier("vavaka_" + (i+1) , "string", getPackageName());

            fijanonana.setId(i);
            fijanonana.setFampidirana(getString(intro_id));
            fijanonana.setLohateny(getString(title_id));
            fijanonana.setVavaka(getString(vavaka_id));

            fijanonanaList.add(fijanonana);
        }

        FijanonanaAdapter fijanonanaAdapter = new FijanonanaAdapter();
        fijanonanaAdapter.submitList(fijanonanaList);

        fijanonanaAdapter.setOnRowClickListener(new OnRowClickListener() {
            @Override
            public void onClick(Fijanonana fijanonana) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("EXTRA_FIJANONANA_ID", fijanonana.getId());
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(fijanonanaAdapter);


    }
}
