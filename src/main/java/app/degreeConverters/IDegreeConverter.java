package app.degreeConverters;

import java.security.InvalidParameterException;

/**
 * Interface of converters used to translate degrees from one су certain temperature system to others.
 * @author eshevtsov
 */
public interface IDegreeConverter {

    /**
     * Fetches numeric temperature value form string and translate temperature value to Celsius from other
     * certain system.
     * @param inputDegree a string, which contains temperature value and sign of a system
     * @return temperature value in Celsius
     * @throws InvalidParameterException if {@code inputDegree} has invalid format (is empty, not contains
     *                                   sign of any temperature system specified in app, not contains right
     *                                   value etc.)
     */
    default double convertToCelsius(String inputDegree) throws InvalidParameterException {
        double degree;
        String substring = inputDegree.substring(0, inputDegree.length() - getType().length());
        try {
            degree = Double.parseDouble(substring);
        } catch (NumberFormatException ex) {
            throw new InvalidParameterException();
        }
        return calculateCelsiusDegree(degree);
    }

    /**
     * Calculate temperature value to Celsius from other certain system.
     * @param degree temperature value
     * @return temperature value in Celsius
     */
    double calculateCelsiusDegree(double degree);

    /**
     * Translates temperature value from Celsius to other certain system.
     * @param celsiusDegree temperature value in Celsius
     * @return temperature value in other certain system
     */
    long convertFromCelsius(double celsiusDegree);

    /**
     * @return sign of the certain temperature system
     */
    String getType();
}
