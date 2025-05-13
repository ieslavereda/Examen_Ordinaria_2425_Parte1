package es.ieslavereda.examen_ordinaria_2425_parte1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Mano {
    private Set<Carta> cartas;

    public Mano() {
        this.cartas = new LinkedHashSet<>();
    }

    public void add(Carta c){
        List<Carta> aux = new ArrayList<>(cartas);
        aux.add(0,c);
        cartas = new LinkedHashSet<>(aux);
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
