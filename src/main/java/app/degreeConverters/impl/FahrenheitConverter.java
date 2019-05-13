package app.degreeConverters.impl;

import app.degreeConverters.IDegreeConverter;

public class FahrenheitConverter implements IDegreeConverter {

    @Override
    public double calculateCelsiusDegree(double degree) {
        return (degree - 32)* 5 / 9;
    }

    @Override
    public long convertFromCelsius(double celsiusDegree) {
        return Math.round(celsiusDegree * 9 / 5 + 32);
    }

    @Override
    public String getType() {
        return "F";
    }
}
