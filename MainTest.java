import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void sumaValoresPositivos() {
        assertEquals(104, Main.sumar(46, 58));
    }

    @Test
    void sumaValoresNegativos() {
        assertEquals(-16, Main.sumar(-7, -9));
    }

    @Test
    void sumaValoresDeSignosDistintos() {
        assertEquals(7, Main.sumar(12, -5));
    }

    @Test
    void sumaConCero() {
        assertEquals(-14, Main.sumar(-14, 0));
    }

    @Test
    void restaResultadoPositivo() {
        assertEquals(9, Main.restar(15, 6));
    }

    @Test
    void restaResultadoNegativo() {
        assertEquals(-9, Main.restar(6, 15));
    }

    @Test
    void restaValoresIguales() {
        assertEquals(0, Main.restar(8, 8));
    }

    @Test
    void restaUnNumeroNegativo() {
        assertEquals(14, Main.restar(10, -4));
    }

    @Test
    void multiplicacionPositivos() {
        assertEquals(56, Main.multiplicar(7, 8));
    }

    @Test
    void multiplicacionSignosDistintos() {
        assertEquals(-56, Main.multiplicar(7, -8));
    }

    @Test
    void multiplicacionDosNegativos() {
        assertEquals(56, Main.multiplicar(-7, -8));
    }

    @Test
    void multiplicacionPorCero() {
        assertEquals(0, Main.multiplicar(999, 0));
    }

    @Test
    void divisionExacta() {
        assertEquals(5.0, Main.dividir(25, 5), 0.000001);
    }

    @Test
    void divisionConResultadoDecimal() {
        assertEquals(3.5, Main.dividir(7, 2), 0.000001);
    }

    @Test
    void divisionConDividendoNegativo() {
        assertEquals(-3.0, Main.dividir(-9, 3), 0.000001);
    }

    @Test
    void divisionConDivisorNegativo() {
        assertEquals(-3.0, Main.dividir(9, -3), 0.000001);
    }

    @Test
    void divisionDosNegativos() {
        assertEquals(4.0, Main.dividir(-12, -3), 0.000001);
    }

    @Test
    void divisionConDividendoCero() {
        assertEquals(0.0, Main.dividir(0, 7), 0.000001);
    }

    @Test
    void divisionPorCeroLanzaExcepcionConMensaje() {
        ArithmeticException error = assertThrows(
            ArithmeticException.class,
            () -> Main.dividir(23, 0)
        );
        assertEquals("No se puede dividir entre cero.", error.getMessage());
    }

    @Test
    void sumaConEnteroMaximoYUnoPresentaDesbordamientoDeInt() {
        assertEquals(Integer.MIN_VALUE, Main.sumar(Integer.MAX_VALUE, 1));
    }

    @Test
    void multiplicacionConDesbordamientoDeInt() {
        assertEquals(-1794967296, Main.multiplicar(50000, 50000));
    }
}
