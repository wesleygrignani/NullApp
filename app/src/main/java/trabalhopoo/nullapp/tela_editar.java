package trabalhopoo.nullapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;

public class tela_editar extends AppCompatActivity {

    BancoDados db = new BancoDados(this);

    EditText ed_nome,ed_quantidade,ed_preco;
    Button bt;
    ImageView imageview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_editar);

        ed_nome = (EditText) findViewById(R.id.edit_text_nome);
        ed_quantidade = (EditText) findViewById(R.id.edit_text_qnt);
        ed_preco = (EditText) findViewById(R.id.edit_text_preco);

        imageview = (ImageView)findViewById(R.id.imageViewt);

        try {
            testeProduto t = db.listaTodosProdutosEditaveis();
            Produto produto = db.selecionarProduto(t.getNome());

            byte[] image = produto.getFoto();
            ByteArrayInputStream imageStream = new ByteArrayInputStream(image);
            Bitmap imageBitmap = BitmapFactory.decodeStream(imageStream);

            ed_nome.setText(produto.getNome());
            ed_preco.setText(String.valueOf(produto.getPreco_unitario()));
            ed_quantidade.setText(String.valueOf(produto.getQuantidade()));
            imageview.setImageBitmap(imageBitmap);
        }catch (Exception e){
            Toast.makeText(tela_editar.this,"Nao foi possivel busca um produto",Toast.LENGTH_LONG).show();
        }
    }


    public void ConfirmarEdicao(View v){

        String nome = ed_nome.getText().toString();
        int preco = Integer.parseInt(ed_preco.getText().toString());
        int quantidade = Integer.parseInt(ed_quantidade.getText().toString());

        testeProduto t = db.listaTodosProdutosEditaveis();

        Produto produto = db.selecionarProduto(t.getNome());

        produto.setNome(nome);
        produto.setPreco_unitario(preco);
        produto.setQuantidade(quantidade);

        db.alterarProduto(produto);

        db.deletarProdutoEditar(t);

        finish();

        Toast.makeText(tela_editar.this,"Edicao Concluida",Toast.LENGTH_LONG).show();

    }

    public void excluirProduto(View v){

        testeProduto t = db.listaTodosProdutosEditaveis();

        Produto produto = db.selecionarProduto(t.getNome());

        db.deletarProduto(produto);

        Toast.makeText(tela_editar.this, "Produto Excluido", Toast.LENGTH_SHORT).show();
        finish();
    }
}
