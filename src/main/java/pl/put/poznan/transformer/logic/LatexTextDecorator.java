package pl.put.poznan.transformer.logic;

import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LatexTextDecorator extends TextDecorator {
    private static final Logger logger = LoggerFactory.getLogger(LatexTextDecorator.class);
    public LatexTextDecorator(Transformer transformer){
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
        text = text.replaceAll("&", "\\\\&");
        text = text.replaceAll("\\$", "\\\\\\$");
        return text;
    }
}
