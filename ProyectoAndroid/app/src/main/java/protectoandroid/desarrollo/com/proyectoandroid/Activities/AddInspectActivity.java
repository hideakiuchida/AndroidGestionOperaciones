package protectoandroid.desarrollo.com.proyectoandroid.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import protectoandroid.desarrollo.com.proyectoandroid.R;

public class AddInspectActivity extends AppCompatActivity {
    TextInputEditText nroInspectTextInputEditText, fechaTextInputEditText, cantidadMuestraTextInputEditText, lugarTextInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inspect);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nroInspectTextInputEditText = (TextInputEditText)
                findViewById(R.id.nroInspectTextInputEditText);
        fechaTextInputEditText = (TextInputEditText)
                findViewById(R.id.fechaTextInputEditText);
        cantidadMuestraTextInputEditText = (TextInputEditText)
                findViewById(R.id.cantidadMuestraTextInputEditText);
        lugarTextInputEditText = (TextInputEditText)
                findViewById(R.id.lugarTextInputEditText);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String message = "Success";
                if (getService().addQuote(
                        phraseTextInputEditText.getText().toString(),
                        authorTextInputEditText.getText().toString(),
                        Integer.toString(R.mipmap.ic_default)
                )) finish();
                else message = "The quote phrase already exists";
                Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
