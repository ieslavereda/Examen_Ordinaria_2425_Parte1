package es.ieslavereda.examen_ordinaria_2425_parte1;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

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

        Mano mano = new Mano();

        baraja = new Baraja();
        baraja.barajar();

        TextView tvPuntuacion = findViewById(R.id.tvPuntuacion);
        TextView tvJugador = findViewById(R.id.tvJugador);
        tvJugador.setText("Jugador 1");

        rvMano = findViewById(R.id.recycler);
        rvMano.setLayoutManager(new LinearLayoutManager(this));
        rvMano.setAdapter(new MyRecyclerViewAdapter(this, mano));

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode()==RESULT_OK){

                        int puntuacion = result.getData().getExtras().getInt("puntuacion");

                        if (puntuacion==mano.getPuntuacion()) finPartida("Ha habido empate");
                        if (puntuacion<mano.getPuntuacion()) finPartida("Ha ganado Jugador 1");
                        if (puntuacion>mano.getPuntuacion()) finPartida("Ha ganado Jugador 2");

                    }else{
                        Toast.makeText(MainActivity.this, "El otro jugador ha abandonado", Toast.LENGTH_SHORT).show();
                        ivBaraja.setEnabled(true);
                    }

                }
        );

        btnPlantarse = findViewById(R.id.btnPlantarse);
        btnPlantarse.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),Activity2.class);
            intent.putExtra("baraja",baraja);
            activityResultLauncher.launch(intent);
        });

        ivBaraja = findViewById(R.id.ivBaraja);
        ivBaraja.setOnClickListener(v -> {
            Carta c = baraja.getCarta();
            mano.add(c);

            rvMano.getAdapter().notifyDataSetChanged();
            tvPuntuacion.setText(String.valueOf(mano.getPuntuacion()));
            ivBaraja.setImageResource(c.getImage());

            if(mano.getPuntuacion()>21)
                finPartida("Has perdido");

        });

        btnReiniciar =findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(v -> {
            mano.clear();
            rvMano.getAdapter().notifyDataSetChanged();
            baraja = new Baraja();
            baraja.barajar();
            ivBaraja.setImageResource(R.mipmap.trasera);
            tvPuntuacion.setText("0");
            btnReiniciar.setVisibility(INVISIBLE);
            btnPlantarse.setEnabled(true);
            ivBaraja.setEnabled(true);
        });
    }

    private void finPartida(String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        ivBaraja.setEnabled(false);
        btnPlantarse.setEnabled(false);
        btnReiniciar.setVisibility(VISIBLE);
    }
}