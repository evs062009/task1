package app.degreeConverters.impl;

import app.degreeConverters.IDegreeConverter;

public class KelvinConverter implements IDegreeConverter {

    @Override
    public double calculateCelsiusDegree(double degree) {
        return degree - 273.15;
    }

    @Override
    public long convertFromCelsius(double celsiusDegree) {
        return Math.round(celsiusDegree + 273.15);
    }

    @Override
    public String getType() {
        return "K";
    }
}
