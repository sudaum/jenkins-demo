package net.sudau.samples.jenkins.domain.services;

import java.time.LocalDateTime;

import net.sudau.samples.jenkins.domain.dtos.MathParameter;
import net.sudau.samples.jenkins.domain.vos.MathValue;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    public LocalDateTime now () {
        return LocalDateTime.now();
    }

    public double calculate (MathParameter params) {

        switch (params.getOperation()) {
            case ADD:
                return params.getValues().stream()
                             .reduce(0.0, MathValue.add::applyAsDouble);
            case SUBSTRACT:
                return params.getValues().stream()
                             .reduce(null, MathValue.substract);
            case MULTIPLY:
                return params.getValues().stream()
                             .reduce(1.0, MathValue.multiply::applyAsDouble);
            case DIVIDE:
                return params.getValues().stream()
                             .reduce(null, MathValue.divide);
            default:
                throw new UnsupportedOperationException(String.format("The Operation %s is not supported!",
                        params.getOperation().name()));
        }
    }
}
