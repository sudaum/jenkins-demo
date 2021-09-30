package net.sudau.samples.jenkins.domain.dtos;

import java.util.Collection;

import lombok.Value;
import net.sudau.samples.jenkins.domain.vos.Operations;

@Value
public class MathParameter {
    Operations operation;
    Collection<Double> values;
}
