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

public class tela_comprar extends AppCompatActivity {

    BancoDados db = new BancoDados(this);
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_comprar);
        ImageView imagem = findViewById(R.id.imageVieww);

        Produto p = db.selecionarProduto(1);

        byte[] image = p.getFoto();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(image);
        Bitmap imageBitmap = BitmapFactory.decodeStream(imageStream);

        imagem.setImageBitmap(imageBitmap);

        /*
        ListView lista = (ListView) findViewById(R.id.lvProduto);
        ArrayAdapter adapter = new ProdutoAdapter(this, adicionarProduto());
        lista.setAdapter(adapter);*/
    }



    /*
    private ArrayList<Produto> adicionarProduto() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto e = new Produto("Escravo",
                "mae do Stofella");
                produtos.add(e);
        e = new Produto("Meu cu",
                "Ta sujo");
        produtos.add(e);
        e = new Produto("sem ideia irmao",
                "meu dls");
        produtos.add(e);
        e = new Produto("aff",
                "tem mais ainda");
        produtos.add(e);
        return produtos;
    }*/


}
