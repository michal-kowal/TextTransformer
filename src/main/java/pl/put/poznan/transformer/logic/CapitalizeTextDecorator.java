package pl.put.poznan.transformer.logic;

import org.apache.commons.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A decorator class that extends the TextDecorator class.
 * It provides a functionality to capitalize text.
 * @author Kacper Majorkowski
 * @version 1.0
 */
public class CapitalizeTextDecorator extends TextDecorator {

    private static final Logger logger = LoggerFactory.getLogger(CapitalizeTextDecorator.class);

    /**
     * Constructor for the CapitalizeTextDecorator class.
     *
     * @param transformer Object implementing Transformer interface.
     */
    public CapitalizeTextDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the input text by first applying the transformation of the base transformer
     * and then capitalizing the result through the decorate method.
     *
     * @param text The input text to be transformed.
     * @return The transformed and decorated text.
     */
    @Override
    public String transform(String text) {
        String transformed = super.transform(text);
        String decorated = decorate(transformed);
        logger.debug(String.format("Transformed string %s to %s", text, decorated));
        return decorated;
    }

    /**
     * Capitalizes the input text using WordUtils.capitalize method.
     *
     * @param text The text to be capitalized.
     * @return The capitalized text.
     */
    public String decorate(String text) {
        return WordUtils.capitalize(text);
    }
}