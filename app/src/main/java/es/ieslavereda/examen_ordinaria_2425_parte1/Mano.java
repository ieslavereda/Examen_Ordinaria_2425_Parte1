package es.ieslavereda.examen_ordinaria_2425_parte1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Mano {
    private List<Carta> cartas;

    public Mano() {
        this.cartas = new ArrayList<>();
    }

    public void add(Carta c){
        cartas.add(0,c);
    }

    public int size(){
        return cartas.size();
    }

    public int getPuntuacion(){
        return cartas.stream().mapToInt(Carta::getValue).sum();
    }

    public Carta get(int position){
        return new ArrayList<>(cartas).get(position);
    }
    public void clear(){
        cartas.clear();
    }

}
