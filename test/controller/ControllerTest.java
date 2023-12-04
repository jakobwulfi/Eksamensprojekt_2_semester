package controller;

import model.Destillat;
import model.DestillatTilPåfyldning;
import model.Fad;
import model.Påfyldning;
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
    //-------------------------------------------------
    @Test
    void beregnProcentAlkohol() {
        Fad f = Controller.opretFad("Frankrig", "Sherry", 1, 100);
        Destillat nm1 = Controller.opretDestillat("Blended", "Bygsort", "Lars", 40, null, "Nice", "nm1",
                LocalDate.of(2023,12,1), LocalDate.of(2026,12,2), 10);
        Destillat nm2 = Controller.opretDestillat("Blended", "Bygsort", "Lars", 60, null, "Nice", "nm2",
                LocalDate.of(2023, 12, 1), LocalDate.of(2026, 12, 2), 15);
        DestillatTilPåfyldning d1 = Controller.opretDestillatTilPåfyldning(nm1, 10);
        DestillatTilPåfyldning d2 = Controller.opretDestillatTilPåfyldning(nm2, 15);

        Påfyldning påfyldning = Controller.opretPåfyldning(List.of(d1, d2), f, LocalDate.of(2023, 12, 06), "Lars",
                LocalDate.of(2026, 12, 04));

        assertEquals(52, påfyldning.getAlkoholProcent());
    }
}