package protectoandroid.desarrollo.com.proyectoandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import protectoandroid.desarrollo.com.proyectoandroid.Adapters.InspeccionAdapter;
import protectoandroid.desarrollo.com.proyectoandroid.Adapters.OrdenAdapter;
import protectoandroid.desarrollo.com.proyectoandroid.Model.Inspeccion;
import protectoandroid.desarrollo.com.proyectoandroid.Model.Orden;
import protectoandroid.desarrollo.com.proyectoandroid.R;
import protectoandroid.desarrollo.com.proyectoandroid.Utils.ServicesUtil;
import protectoandroid.desarrollo.com.proyectoandroid.Utils.StaticParams;

public class InspectionActivity extends AppCompatActivity {

    private List<Inspeccion> preList = new ArrayList<>();
    private InspeccionAdapter adapter;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection);

        Bundle extras = getIntent().getExtras();
        String nroOrden = null, cliente;
        int id = 0;
        if (extras != null) {
            nroOrden = extras.getString("nroOrden");
            cliente = extras.getString("cliente");
            id = extras.getInt("id");
        }
        List<Inspeccion> inspectList = GetInspectsByOrder(id);
        adapter = new InspeccionAdapter(this, inspectList);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerViewInspect);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private List<Inspeccion> GetInspectsByOrder(int idOrder){
        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET,
                ServicesUtil.INSPECCION_URL + "/" + Integer.toString(idOrder), null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try{
                            for(int i=0; i < response.length(); i++){

                                JSONObject jsonObject = response.getJSONObject(i);
                                int id = jsonObject.getInt("id");
                                String lugar = jsonObject.getString("lugar");
                                int cantidad_muestra = jsonObject.getInt("cantida_muestra");
                                String nroInspect = jsonObject.getString("nro_inspeccion");
                                String fecha = jsonObject.getString("fecha");

                                Inspeccion inspect = new Inspeccion(id, nroInspect, fecha, cantidad_muestra, lugar);
                                preList.add(inspect);
                            }

                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley","Error");
                    }
                }
        ){@Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            HashMap<String, String> headers = new HashMap <String, String> ();
            headers.put("Token", StaticParams.token);
            return headers;
        }
        };
        requestQueue.add(jsonObjectRequest);

        return preList;
    }
}
