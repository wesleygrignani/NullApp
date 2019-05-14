package trabalhopoo.nullapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import trabalhopoo.nullapp.Produto;
import trabalhopoo.nullapp.R;

import java.io.ByteArrayInputStream;
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
        TextView nomeProduto = (TextView) rowView.findViewById(R.id.nomeproduto);
        TextView qntProduto = (TextView) rowView.findViewById(R.id.qntproduto);
        TextView precoProduto = (TextView) rowView.findViewById(R.id.precoproduto);
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
