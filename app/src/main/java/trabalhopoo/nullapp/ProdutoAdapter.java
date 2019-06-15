package trabalhopoo.nullapp;

import trabalhopoo.nullapp.tela_login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.ByteArrayInputStream;
import java.util.ArrayList;


public class ProdutoAdapter extends ArrayAdapter<Produto> {

    BancoDados db = new BancoDados(getContext());

    private final Context context;
    private ArrayList<Produto>elementos;

    ClienteLogado p;

    public ProdutoAdapter(Context context, ArrayList<Produto> elementos, ClienteLogado h){
        super(context, R.layout.linhalistview, elementos);
        p=h;
        this.context=context;
        this.elementos = elementos;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linhalistview, parent, false);
        TextView nomeProduto = (TextView) rowView.findViewById(R.id.nomeproduto);
        TextView qntProduto = (TextView) rowView.findViewById(R.id.qntproduto);
        TextView precoProduto = (TextView) rowView.findViewById(R.id.precoproduto);
        Button butao = (Button) rowView.findViewById(R.id.botaocomprar);
        if(elementos.get(position).getCpf().contains(p.getCpf())){
            butao.setText("Editar");
            butao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { // Retorno do click Editar na listview
                    testeProduto t = new testeProduto();
                    t.setCodigo(200);
                    t.setNome(elementos.get(position).getNome());
                    db.addProdutoEditar(t);

                    Toast.makeText(getContext(),"Volte ao menu para edita-lo",Toast.LENGTH_LONG).show();
                }
            });
        }else {
            butao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){ // Retorno do click Comprar na listview

                    db.addProdutoSacola(elementos.get(position).getCodigo(),elementos.get(position).getNome(),elementos.get(position).getPreco_unitario(),
                            1,elementos.get(position).getCpf(),elementos.get(position).getFoto());

                    Toast.makeText(getContext(),"Adicionado a Sacola",Toast.LENGTH_LONG).show();

                    Produto p = db.selecionarProduto(elementos.get(position).getNome());

                    p.setQuantidade(p.getQuantidade()-1);

                    if(p.getQuantidade()==0){
                        db.deletarProduto(p);
                    }else{
                        db.alterarProduto(p);
                    }
                }
            });
        }

        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagelist);
        nomeProduto.setText(elementos.get(position).getNome());
        qntProduto.setText(String.valueOf(elementos.get(position).getQuantidade()));
        precoProduto.setText(String.valueOf(elementos.get(position).getPreco_unitario()));
        byte[] image = elementos.get(position).getFoto();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(image);
        Bitmap imageBitmap = BitmapFactory.decodeStream(imageStream);
        imagem.setImageBitmap(imageBitmap);
        return rowView;
    }

}


