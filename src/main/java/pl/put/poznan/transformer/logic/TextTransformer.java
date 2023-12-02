package pl.put.poznan.transformer.logic;

import java.util.Map;


/**
 * This is just an example to show that the logic should be outside the REST service.
 */

public class TextTransformer implements Transformer {

    public TextTransformer(){
    }

    public String transform(String text){
        return text;
    }
}