package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FadTest {

    @Test
    void updateVolumen() {
        Fad et = new Fad("Italien", "Bourbon", 1, 80.00);
        Fad to = new Fad("Frankrig", "Sherry", 2, 135.00);

        //Arrange
        et.updateVolumen(50);

        //Act
        double resultat = 50;

        //Assert

        /**
         * T1
         */
        double forventetResultat = et.getNuværendeMængdeLiter();
        assertEquals(forventetResultat, resultat);

        /**
         * T2
         */
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            to.updateVolumen(140);
        });

        assertEquals("Mængden er større end fad størrelse", exception.getMessage());
    }
}