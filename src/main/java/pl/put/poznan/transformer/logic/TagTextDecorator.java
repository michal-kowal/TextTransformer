package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TagTextDecorator extends TextDecorator{
    private static final Logger logger = LoggerFactory.getLogger(TagTextDecorator.class);
    public TagTextDecorator(Transformer transformer){super(transformer);}
    public String transform(String text){
        String transformed = super.transform(text);
        String decorated = decorate(transformed);
        logger.debug(String.format("Transformed string %s to %s", text, decorated));
        return decorated;
    }
    @Override
    public String decorate(String text) {
        text = text.replaceAll("-(.*?)-", "<s>$1</s>");
        text = text.replaceAll("!(.*?)!", "<strong>$1</strong>");
        text = text.replaceAll("_(.*?)_", "<u>$1</u>");
        text = text.replaceAll("\\*(.*?)\\*", "<em>$1</em>");
        return text;
    }
}