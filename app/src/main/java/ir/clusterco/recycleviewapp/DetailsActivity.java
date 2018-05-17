package ir.clusterco.recycleviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
private TextView name,description,rating;
private Bundle extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name=(TextView)findViewById(R.id.nameDet);
        description=(TextView)findViewById(R.id.descDet);
        rating=(TextView)findViewById(R.id.rateDet);

        extra=getIntent().getExtras();

        if (extra!=null)
        {
            name.setText(extra.getString("name"));
            description.setText(extra.getString("description"));
            rating.setText(extra.getString("rating"));
        }
    }
}
