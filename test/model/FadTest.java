package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FadTest {

    @Test
    void updateVolumen() {
        Fad et = new Fad("Italien", "Bourbon", 1, 1, 80.00);

        //Arrange
        et.updateVolumen(50);

        //Act
        double resultat = 50;

        //Assert
        double forventetResultat = et.getNuværendeMængdeLiter();
        assertEquals(forventetResultat, resultat);
    }
}