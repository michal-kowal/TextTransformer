package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EliminateTextDecorator extends TextDecorator{
    private static final Logger logger = LoggerFactory.getLogger(EliminateTextDecorator.class);
    public EliminateTextDecorator(Transformer transformer) {
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
        String[] words = text.split("\\s+");
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (i == 0 || !currentWord.equals(words[i - 1])) {
                res.append(currentWord).append(" ");
            }
        }
        return res.toString().trim();
    }
}
