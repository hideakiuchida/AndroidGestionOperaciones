package protectoandroid.desarrollo.com.proyectoandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;

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
        List<Orden> ordenList = GetOrders(StaticParams.userId);
        adapter = new OrdenAdapter(this, ordenList);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerViewOrder);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }


   private List<Orden> GetOrders(int idInspector){
       requestQueue = Volley.newRequestQueue(this);

       JsonArrayRequest  jsonObjectRequest = new JsonArrayRequest(Request.Method.GET,
               ServicesUtil.GET_ORDER_URL + "/" + Integer.toString(idInspector), null,
               new Response.Listener<JSONArray>() {
                   @Override
                   public void onResponse(JSONArray response) {

                       try{
                           for(int i=0; i < response.length(); i++){

                               JSONObject jsonObject = response.getJSONObject(i);
                               int id = jsonObject.getInt("id");
                               String descripcion = jsonObject.getString("descripcion");
                               String cliente = jsonObject.getString("cliente");
                               String latitud = jsonObject.getString("latitud");
                               String longitud = jsonObject.getString("longitud");
                               String nroOrden = jsonObject.getString("nroOrden");

                               Orden orden = new Orden(id, descripcion,cliente,latitud,longitud,nroOrden);
                               preOrdenList.add(orden);
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

       return preOrdenList;
   }


}
