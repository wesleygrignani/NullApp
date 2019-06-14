package trabalhopoo.nullapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;



public class endereco extends AppCompatActivity {

   private EditText etCep,etlogradouro, etnumero, etbairro, etcomplemento, etcidade, etuf;
   private String Cep,logradouro,numero,bairro, complemento, cidade, uf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

    }

    public void buscarCEP (View view){

        etCep = (EditText) findViewById(R.id.cep);
        etlogradouro = (EditText) findViewById(R.id.logradouro);
        etbairro = (EditText) findViewById(R.id.bairro);
        etcomplemento = (EditText) findViewById(R.id.complemento);
        etcidade = (EditText) findViewById(R.id.localidade);
        etuf = (EditText) findViewById(R.id.uf);

        Cep = etCep.getText().toString();



        String URL = "http://viacep.com.br/ws/"+Cep+"/json/";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            etlogradouro.setText(response.getString("logradouro"));
                            etbairro.setText(response.getString("bairro"));
                            etcidade.setText(response.getString("localidade"));
                            etuf.setText(response.getString("uf"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("ViaCep Response", error.toString());
                    }
                }
        );
        requestQueue.add(objectRequest);

    }
}