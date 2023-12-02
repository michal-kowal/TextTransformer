package pl.put.poznan.transformer.logic;

import org.apache.commons.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CapitalizeTextDecorator extends TextDecorator{
    private static final Logger logger = LoggerFactory.getLogger(CapitalizeTextDecorator.class);

    public CapitalizeTextDecorator(Transformer transformer){
        super(transformer);
    }

    @Override
    public String transform(String text){
        String transformed = super.transform(text);
        String decorated = decorate(transformed);
        logger.debug(String.format("Transformed string %s to %s", text, decorated));
        return decorated;
    }

    public String decorate(String text){
        return WordUtils.capitalize(text);
    }
}
