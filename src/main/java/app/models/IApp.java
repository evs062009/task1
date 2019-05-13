package app.models;

import app.degreeConverters.IDegreeConverter;

import java.security.InvalidParameterException;
import java.util.Map;

/**
 * Interface of model-classes in MVC of "task1" app.
 * @author eshevtsov
 */
public interface IApp {

    /**
     * Contains the main logic of temperature translation and returns a map of
     * converted temperature values (sign of system, value).
     * @param inputDegree   a string, which contains temperature value and sign of a system
     * @param converters    the array of converters used to translate degrees from one су certain temperature
     *                      system to others.
     * @return a map of converted temperature values (sign of system, value)
     * @throws InvalidParameterException if {@code inputDegree} has invalid format (is empty, not contains
     *                                   sign of any temperature system specified in app, not contains right
     *                                   value etc.)
     */
    Map<String, Long> getResult(String inputDegree, IDegreeConverter[] converters) throws InvalidParameterException;
}
