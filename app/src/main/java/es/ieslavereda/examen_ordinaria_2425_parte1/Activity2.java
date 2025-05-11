package es.ieslavereda.examen_ordinaria_2425_parte1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Activity2 extends AppCompatActivity {

    private RecyclerView rvMano;
    private Baraja baraja;
    private Button btnPlantarse;
    private Button btnReiniciar;
    private ImageView ivBaraja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Baraja baraja = (Baraja) getIntent().getExtras().getSerializable("baraja");

        Mano mano = new Mano();

        TextView tvPuntuacion = findViewById(R.id.tvPuntuacion);
        TextView tvJugador = findViewById(R.id.tvJugador);
        tvJugador.setText("Jugador 2");

        rvMano = findViewById(R.id.recycler);
        rvMano.setLayoutManager(new LinearLayoutManager(this));
        rvMano.setAdapter(new MyRecyclerViewAdapter(this, mano));

        btnPlantarse = findViewById(R.id.btnPlantarse);
        btnPlantarse.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("puntuacion",mano.getPuntuacion());
            setResult(RESULT_OK,intent);
            finish();
        });

        ivBaraja = findViewById(R.id.ivBaraja);
        ivBaraja.setOnClickListener(v -> {
            Carta c = baraja.getCarta();
            mano.add(c);
            rvMano.getAdapter().notifyDataSetChanged();
            tvPuntuacion.setText(String.valueOf(mano.getPuntuacion()));
            ivBaraja.setImageResource(c.getImage());

            if(mano.getPuntuacion()>21){
                Intent intent = new Intent();
                intent.putExtra("puntuacion",-1);
                setResult(RESULT_OK,intent);
                finish();
            }

        });


    }
}