package org.katolika.lnh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ConclusionActivity extends AppCompatActivity {

    TextView textConclusion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusion);

        setTitle("Vavaka famaranana");
        textConclusion = findViewById(R.id.textConclusion);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textConclusion.setText(Html.fromHtml(getString(R.string.conclusion_text), Html.FROM_HTML_MODE_COMPACT));
        } else {
            textConclusion.setText(Html.fromHtml(getString(R.string.conclusion_text)));
        }

    }
}
