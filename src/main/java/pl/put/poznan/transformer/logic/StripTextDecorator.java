package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StripTextDecorator extends TextDecorator {
    private static final Logger logger = LoggerFactory.getLogger(StripTextDecorator.class);

    public StripTextDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        String transformed = super.transform(text);
        String decorated = decorate(transformed);
        logger.debug(String.format("Transformed string %s to %s", text, decorated));
        return decorated;
    }

    public String decorate(String text) {
        return text.strip();
    }
}