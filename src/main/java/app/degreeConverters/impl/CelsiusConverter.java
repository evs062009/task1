package app.degreeConverters.impl;

import app.degreeConverters.IDegreeConverter;

public class CelsiusConverter implements IDegreeConverter {

    @Override
    public double calculateCelsiusDegree(double degree) {
        return degree;
    }

    @Override
    public long convertFromCelsius(double celsiusDegree) {
        return Math.round(celsiusDegree);
    }

    @Override
    public String getType() {
        return "C";
    }
}
