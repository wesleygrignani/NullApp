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


public class ProdutoAdapter2 extends ArrayAdapter<Produto> {

    BancoDados db = new BancoDados(getContext());

    private final Context context;
    private ArrayList<Produto>elementos;

    ClienteLogado p;

    public ProdutoAdapter2(Context context, ArrayList<Produto> elementos, ClienteLogado h){
        super(context, R.layout.linhalistview, elementos);
        p=h;
        this.context=context;
        this.elementos = elementos;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linhalistview2, parent, false);
        TextView nomeProduto = (TextView) rowView.findViewById(R.id.nomeproduto);
        TextView nomeVendedor = (TextView) rowView.findViewById(R.id.nome_vendedor);
        TextView precoProduto = (TextView) rowView.findViewById(R.id.precoproduto);
        //Button butao = (Button) rowView.findViewById(R.id.botaocomprar);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagelist);

        String cpf = elementos.get(position).getCpf();
        Cliente t = db.selecionarCLiente(cpf);

        nomeVendedor.setText(t.getNome());
        nomeProduto.setText(elementos.get(position).getNome());
        precoProduto.setText("Preço R$ " + String.valueOf(elementos.get(position).getPreco_unitario()));
        byte[] image = elementos.get(position).getFoto();
        ByteArrayInputStream imageStream = new ByteArrayInputStream(image);
        Bitmap imageBitmap = BitmapFactory.decodeStream(imageStream);
        imagem.setImageBitmap(imageBitmap);
        return rowView;
    }

}
