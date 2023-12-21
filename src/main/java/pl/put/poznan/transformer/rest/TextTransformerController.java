package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import pl.put.poznan.transformer.logic.ExpandTextDecorator;
import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.rest.response.TextTransformerResponse;

import java.util.Arrays;
import java.util.Map;


@RestController
@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    Map<String, String> mapOfClassNames = Map.ofEntries(
        Map.entry("upper", "UpperTextDecorator"),
        Map.entry("lower", "LowerTextDecorator"),
        Map.entry("capitalize", "CapitalizeTextDecorator"),
        Map.entry("inverse", "InverseTextDecorator"),
        Map.entry("eliminate", "EliminateTextDecorator"),
        Map.entry("minimize", "MinimizeTextDecorator"),
        Map.entry("expand", "ExpandTextDecorator"),
        Map.entry("latex", "LatexTextDecorator"),
        Map.entry("strip", "StripTextDecorator"),
        Map.entry("tag", "TagTextDecorator")
    );

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        Transformer transformer = new TextTransformer();
        Gson gson = new Gson();

        for (String transformation : transforms){

            String className;
            className = mapOfClassNames.get(transformation);
            if (className == null){
                return "Nie istnieje tranformacja " + transformation; //TODO obsługa błędów
            }

            try {
                Class<?> decoratorClass = Class.forName("pl.put.poznan.transformer.logic."+className);
                transformer = (TextDecorator) decoratorClass.getDeclaredConstructor(Transformer.class).newInstance(transformer);
            }catch (ClassNotFoundException e){
                TextTransformerResponse res = new TextTransformerResponse("Nie istnieje tranformacja " + transformation);
                return gson.toJson(res); //TODO obsługa błędów
            }catch (Exception e){
                TextTransformerResponse res = new TextTransformerResponse("Transformacja nie powiodła się "+ e);
                return gson.toJson(res); // TODO obsługa błędów
            }
            
        }

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformerResponse res = new TextTransformerResponse(transformer.transform(text));
        return gson.toJson(res);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        Transformer transformer = new TextTransformer();
        return transformer.transform(text);
    }



}


