package es.ieslavereda.examen_ordinaria_2425_parte1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Baraja implements Serializable {

    public static Map<String, List<Integer>> imagenes = Map.of(
            "club", List.of(R.mipmap.club_a, R.mipmap.club_2, R.mipmap.club_3, R.mipmap.club_4, R.mipmap.club_5, R.mipmap.club_6, R.mipmap.club_7, R.mipmap.club_8, R.mipmap.club_9, R.mipmap.club_10, R.mipmap.club_j, R.mipmap.club_q, R.mipmap.club_k),
            "diamond", List.of(R.mipmap.diamond_a, R.mipmap.diamond_2, R.mipmap.diamond_3, R.mipmap.diamond_4, R.mipmap.diamond_5, R.mipmap.diamond_6, R.mipmap.diamond_7, R.mipmap.diamond_8, R.mipmap.diamond_9, R.mipmap.diamond_10, R.mipmap.diamond_j, R.mipmap.diamond_q, R.mipmap.diamond_k),
            "heart", List.of(R.mipmap.heart_a, R.mipmap.heart_2, R.mipmap.heart_3, R.mipmap.heart_4, R.mipmap.heart_5, R.mipmap.heart_6, R.mipmap.heart_7, R.mipmap.heart_8, R.mipmap.heart_9, R.mipmap.heart_10, R.mipmap.heart_j, R.mipmap.heart_q, R.mipmap.heart_k),
            "spade", List.of(R.mipmap.spade_a, R.mipmap.spade_2, R.mipmap.spade_3, R.mipmap.spade_4, R.mipmap.spade_5, R.mipmap.spade_6, R.mipmap.spade_7, R.mipmap.spade_8, R.mipmap.spade_9, R.mipmap.spade_10, R.mipmap.spade_j, R.mipmap.spade_q, R.mipmap.spade_k)
    );

    private List<Carta> cartas;

    public Baraja(){

        Set<Carta> cartasSet = new LinkedHashSet<>();

        for(String k : imagenes.keySet()){
            int i=1;
            for(int image : imagenes.get(k))
                cartasSet.add(new Carta(Math.min(i++,10),image));
        }

        cartas = new ArrayList<>(cartasSet);
    }

    public Carta getCarta(){
        return cartas.remove(0);
    }

    public void barajar(){
        Collections.shuffle(cartas);
    }


}
