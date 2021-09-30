package net.sudau.samples.jenkins.domain.vos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MathValueTest {

    @Test
    void multiply () {
        assertThat(MathValue.multiply.applyAsDouble(3.0, 1.5)).isEqualTo(4.5);
    }

    @Test
    void divide () {
        assertThat(MathValue.divide.apply(3.0, 1.5)).isEqualTo(2.0);
        assertThat(MathValue.divide.apply(null, 0.0)).isEqualTo(0.0);
        assertThrows(ArithmeticException.class, () -> MathValue.divide.apply(1.0, 0.0));
    }

    @Test
    void add () {
        assertThat(MathValue.add.applyAsDouble(3.0, 1.5)).isEqualTo(4.5);
    }

    @Test
    void substract () {
        assertThat(MathValue.substract.apply(3.0, 1.5)).isEqualTo(1.5);
        assertThat(MathValue.substract.apply(null, 1.5)).isEqualTo(1.5);
    }
}
