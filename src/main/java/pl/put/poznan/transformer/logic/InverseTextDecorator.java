package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static java.lang.Character.isUpperCase;

public class InverseTextDecorator extends TextDecorator{
    private static final Logger logger = LoggerFactory.getLogger(InverseTextDecorator.class);
    public InverseTextDecorator(Transformer transformer) {
        super(transformer);
    }

    public String transform(String text){
        String transformed = super.transform(text);
        String decorated = decorate(transformed);
        logger.debug(String.format("Transformed string %s to %s", text, decorated));
        return decorated;
    }
    @Override
    public String decorate(String text) {
        ArrayList<Integer> upperIndices = new ArrayList<>();
        for(int i = 0; i < text.length(); i++){
            if(isUpperCase(text.charAt(i))){
                upperIndices.add(i);
            }
        }
        String res = new StringBuilder(text.toLowerCase()).reverse().toString();
        char[] charArray = res.toCharArray();

        for (int index : upperIndices){
            charArray[index] = Character.toUpperCase(charArray[index]);
        }
        return new String(charArray);
    }
}
