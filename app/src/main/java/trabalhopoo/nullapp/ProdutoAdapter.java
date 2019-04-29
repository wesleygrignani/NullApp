package trabalhopoo.nullapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import trabalhopoo.nullapp.Produto;
import trabalhopoo.nullapp.R;

import java.util.ArrayList;

public class ProdutoAdapter extends ArrayAdapter<Produto> {
    private final Context context;
    private ArrayList<Produto>elementos;

    public ProdutoAdapter(Context context, ArrayList<Produto> elementos){
        super(context, R.layout.linhalistview, elementos);
        this.context=context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linhalistview, parent, false);
        TextView nomeProduto = (TextView) rowView.findViewById(R.id.textproduto);
        TextView descricaoProduto = (TextView) rowView.findViewById(R.id.textvendedor1);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.image1);

        nomeProduto.setText(elementos.get(position).getNome());
        descricaoProduto.setText(elementos.get(position).getDescricao());
//        imagem.setImageResource(elementos.get(position).getImagem());
        return rowView;
    }
}
