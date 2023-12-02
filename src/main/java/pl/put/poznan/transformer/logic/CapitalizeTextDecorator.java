package pl.put.poznan.transformer.logic;

import org.apache.commons.text.WordUtils;

public class CapitalizeTextDecorator extends TextDecorator{
    public CapitalizeTextDecorator(Transformer transformer){
        super(transformer);
    }

    @Override
    public String transform(String text){
        return decorate(super.transform(text));
    }

    public String decorate(String text){
        return WordUtils.capitalize(text);
    }
}
