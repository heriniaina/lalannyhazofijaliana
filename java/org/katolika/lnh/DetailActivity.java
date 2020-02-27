package org.katolika.lnh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private int id;
    TextView textFijanonana, textIntro, textTitre, textVavaka;
    ImageButton btnNext, btnPrev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        id = getIntent().getIntExtra("EXTRA_FIJANONANA_ID", 0);

        Fijanonana fijanonana = new Fijanonana();
        int title_id = getResources().getIdentifier("titre_" + (id + 1) , "string", getPackageName());
        int intro_id = getResources().getIdentifier("intro_" + (id+1) , "string", getPackageName());
        int vavaka_id = getResources().getIdentifier("vavaka_" + (id+1) , "string", getPackageName());

        fijanonana.setId(id);
        fijanonana.setFampidirana(getString(intro_id));
        fijanonana.setLohateny(getString(title_id));
        fijanonana.setVavaka(getString(vavaka_id));

        textFijanonana = findViewById(R.id.textFijanonana);
        textIntro = findViewById(R.id.textIntro);
        textTitre = findViewById(R.id.textTitre);
        textVavaka = findViewById(R.id.textVavaka);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);




        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id == 13)
                {
                    Intent intent = new Intent(DetailActivity.this, ConclusionActivity.class);
                    startActivity(intent);
                }
                else {
                    finish();
                    getIntent().putExtra("EXTRA_FIJANONANA_ID", id + 1);
                    startActivity(getIntent());
                }
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id == 0)
                {
                    onBackPressed();
                }
                else {
                    finish();
                    getIntent().putExtra("EXTRA_FIJANONANA_ID", id - 1);
                    startActivity(getIntent());
                }
            }
        });

        textTitre.setText(fijanonana.getLohateny());
        textFijanonana.setText(String.format(getString(R.string.fijanonana), Util.toRoman(id + 1)));
        textIntro.setText(fijanonana.getFampidirana());
        textVavaka.setText(fijanonana.getVavaka());
    }
}
