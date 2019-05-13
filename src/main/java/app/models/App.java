package app.models;

import app.degreeConverters.IDegreeConverter;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

@Service
public class App implements IApp {

    @Override
    public Map<String, Long> getResult(String inputDegree, IDegreeConverter[] converters)
            throws InvalidParameterException {
        IntermediateResult intermediateResult = convertToCelsius(inputDegree, converters);
        return createResult(intermediateResult, converters);
    }

    private IntermediateResult convertToCelsius(String inputDegree, IDegreeConverter[] converters)
            throws InvalidParameterException {
        for (IDegreeConverter converter : converters) {
            String degreeType = converter.getType();
            if (inputDegree.endsWith(degreeType)) {
                return new IntermediateResult(degreeType, converter.convertToCelsius(inputDegree));
            }
        }
        throw new InvalidParameterException();
    }

    private Map<String, Long> createResult(IntermediateResult intermediateResult, IDegreeConverter[] converters) {
        Map<String, Long> result = new HashMap<>(converters.length - 1);
        String degreeType;
        for (IDegreeConverter converter : converters) {
            degreeType = converter.getType();
            if (!degreeType.equals(intermediateResult.degreeType)) {
                result.put(degreeType, converter.convertFromCelsius(intermediateResult.degreeVal));
            }
        }
        return result;
    }

    private class IntermediateResult {
        private String degreeType;
        private double degreeVal;

        private IntermediateResult(String degreeType, double degreeVal) {
            this.degreeType = degreeType;
            this.degreeVal = degreeVal;
        }
    }
}
