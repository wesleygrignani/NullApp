package trabalhopoo.nullapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class tela_comprar extends AppCompatActivity {

    BancoDados db = new BancoDados(this);
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_comprar);

        ArrayList<Produto> produto = db.listaTodosProdutos();


       ListView lista = (ListView) findViewById(R.id.list);
        ArrayAdapter adapter = new ProdutoAdapter(this, produto);
        lista.setAdapter(adapter);
    }



//    private ArrayList<Produto> adicionarProduto() {
//        ArrayList<Produto> produtos = new ArrayList<Produto>();
//        Produto e = new Produto("Escravo",
//                2, 4);
//                produtos.add(e);
//        e = new Produto("mae do stofella",
//                2, 4);
//        produtos.add(e);
//
//        return produtos;
//    }



}
