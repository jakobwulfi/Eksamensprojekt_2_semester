package controller;

import model.Destillat;
import model.Fad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.ListStorage;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    @BeforeEach
    public void setup() {
        Controller.setStorage(new ListStorage());
    }

    @Test
    void opretDestillat() {

        //Arrange
        Controller.opretDestillat("Blended", "Bygsort", "Lars", 0, null, "Nice", "nm1", LocalDate.of(2023, 12, 1), LocalDate.of(2026, 12, 2), 130);

        //Act
        double resultat = 1;

        //Assert
        assertEquals(resultat, Controller.getDestillater().size());
    }

    //---------------------------------------------------------------------

    @Test
    void opretFad() {

        //Arrange
        Controller.opretFad("Italien", "Bourbon", 1, 80.00);

        //Act
        double resultat = 1;

        //Assert
        assertEquals(resultat, Controller.getFade().size());
    }
}