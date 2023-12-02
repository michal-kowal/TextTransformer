package pl.put.poznan.transformer.logic;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinimizeTextDecorator extends TextDecorator {
    private static final Logger logger = LoggerFactory.getLogger(MinimizeTextDecorator.class);

    Map<String, String> minimizeMap = Map.ofEntries(
        Map.entry("na przykład", "np."),
        Map.entry("między innymi", "m.in."),
        Map.entry("i tym podobne", "itp."),
        Map.entry("i tak dalej", "itd.")
    );

    public MinimizeTextDecorator(Transformer transformer){
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
        for (Map.Entry<String, String> entry : minimizeMap.entrySet()) {
            text = text.replaceAll("(?i)" + entry.getKey(), entry.getValue());
        }
        return text;
    }
}
