/*
 * %W% %E% Evgeniy Shevtsov
 * This web application converts the temperature value from one system to others.
 */
package app.controllers;

import app.degreeConverters.IDegreeConverter;
import app.degreeConverters.impl.CelsiusConverter;
import app.degreeConverters.impl.FahrenheitConverter;
import app.degreeConverters.impl.KelvinConverter;
import app.models.IApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.InvalidParameterException;

/**
 * Class {@code AppController} is a controller in MVC of "task1" app.
 * @author eshevtsov
 */
@Controller
@RequestMapping("/")
public class AppController {
    private IApp app;

    /**
     * The array of converters used to translate degrees from one су certain temperature system to others.
     * To add a new system you need to add its converter-class, which implements
     * {@code IDegreeConverter} interface, to the array.
     */
    private IDegreeConverter[] converters =
            {new CelsiusConverter(), new KelvinConverter(), new FahrenheitConverter()};

    /**
     * Constructs a controller with the specified initial model-class.
     * @param app model-class, which implements {@code IApp} interface and contains the temperature
     *            translation logic
     */
    @Autowired
    public AppController(IApp app) {
        this.app = app;
    }

    /**
     * Handles client "get" request and returns a string with converted temperature values.
     * @param inputDegree string client input, which contains temperature value and sign of a system,
     *                    for example 299K or 299.9K
     * @return a string in json format, which contains values of the same temperature in other systems,
     * and signs of systems
     */
    @GetMapping(produces = "application/json")
    public @ResponseBody String getDegrees(@RequestParam String inputDegree) {
        try{
            String string = app.getResult(inputDegree, converters).toString();
            return string.replace("=", ": ");
        } catch (InvalidParameterException ex){
            return "Invalid input parameter.";
        }
    }
}
