package protectoandroid.desarrollo.com.proyectoandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import protectoandroid.desarrollo.com.proyectoandroid.Adapters.OrdenAdapter;
import protectoandroid.desarrollo.com.proyectoandroid.Model.Orden;
import protectoandroid.desarrollo.com.proyectoandroid.R;

public class MainActivity extends AppCompatActivity {

    private List<Orden> ordenList;
    private OrdenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ordenList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Orden orden = new Orden("Descripcion " + i, "Cliente","-34.342432432", "-34.342432432", "Pendiente");
            ordenList.add(orden);
        }

        adapter = new OrdenAdapter(this, ordenList);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
