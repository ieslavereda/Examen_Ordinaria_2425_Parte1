package es.ieslavereda.examen_ordinaria_2425_parte1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {


    private LayoutInflater inflater;
    private Context context;
    private Mano mano;

    public MyRecyclerViewAdapter(@NonNull Context context,Mano mano) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mano = mano;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {

        Carta c = mano.get(position);

        holder.image.setImageResource(c.getImage());
        holder.value.setText(String.valueOf(c.getValue()));

    }

    @Override
    public int getItemCount() {
        return mano.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView value;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivCarta);
            value = itemView.findViewById(R.id.tvValue);
        }
    }
}
