package es.ieslavereda.examen_ordinaria_2425_parte1;

import androidx.annotation.Nullable;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Carta implements Serializable {

    private int value;
    private int image;

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj==null ) return false;
        if(!(obj instanceof Carta)) return false;
        Carta c = (Carta) obj;
        return c.value==value && c.image==image;
    }
}
