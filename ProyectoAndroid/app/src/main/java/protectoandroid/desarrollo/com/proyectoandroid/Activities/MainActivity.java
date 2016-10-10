package protectoandroid.desarrollo.com.proyectoandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Window;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import protectoandroid.desarrollo.com.proyectoandroid.Adapters.OrdenAdapter;
import protectoandroid.desarrollo.com.proyectoandroid.Model.Orden;
import protectoandroid.desarrollo.com.proyectoandroid.R;
import protectoandroid.desarrollo.com.proyectoandroid.Services.OrdenServices;
import protectoandroid.desarrollo.com.proyectoandroid.Utils.ServicesUtil;
import protectoandroid.desarrollo.com.proyectoandroid.Utils.StaticParams;

public class MainActivity extends AppCompatActivity {

    private List<Orden> preOrdenList = new ArrayList<>();
    private OrdenAdapter adapter;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Orden> ordenList = new OrdenServices(this).GetOrders(StaticParams.userId);
        adapter = new OrdenAdapter(this, ordenList);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerViewOrder);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }





}
