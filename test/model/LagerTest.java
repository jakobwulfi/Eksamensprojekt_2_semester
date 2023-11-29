package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LagerTest {

    @Test
    void addFad() {
        List<Fad> fade = new ArrayList<>();

        Fad et = new Fad("Italien", "Bourbon", 1, 80.00);
        Fad to = new Fad("Frankrig", "Sherry", 2, 135.00);
        Fad tre = new Fad("Polen", "Vin", 3, 100.00);

        //Arrange
        fade.add(et);
        fade.add(to);
        fade.add(tre);

        //Act
        int resultat = 3;

        //Assert
        int forventetResultat = fade.size();
        assertEquals(forventetResultat, resultat);

    }
}