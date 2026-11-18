package test;

import mattress.ProductCalculations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductCalculationsTest {
    private final ProductCalculations calc = new ProductCalculations(3500);

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        assertEquals(525.0, calc.GetVat(), 0.001);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        assertEquals(4200.0, calc.GetTotal(), 0.001);
    }
}
