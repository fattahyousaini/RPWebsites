package sg.edu.rp.c346.id18016553.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spn1, spn2;
    Button btnGo;
    ArrayList<String> alDisplay;
    ArrayAdapter<String> aaDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGo);

        alDisplay = new ArrayList<>();
        aaDisplay = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alDisplay);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        alDisplay.clear();
                        String[] strDisplay = getResources().getStringArray(R.array.subCat1);
                        alDisplay.addAll(Arrays.asList(strDisplay));
                        break;
                    case 1:
                        alDisplay.clear();
                        String[] strDisplay1 = getResources().getStringArray(R.array.subCat2);
                        alDisplay.addAll(Arrays.asList(strDisplay1));
                        break;
                }
                spn2.setAdapter(aaDisplay);
                aaDisplay.notifyDataSetChanged();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] sites =
                        {{"https://www.rp.edu.sg/", "https://www.rp.edu.sg/student-life"},
                                {"https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                        "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"}};
                String url = sites[spn1.getSelectedItemPosition()][spn2.getSelectedItemPosition()];

                Intent intent = new Intent(MainActivity.this, WebPage.class);
                intent.putExtra("URL", url);
                startActivity(intent);
            }
        });

    }
}
