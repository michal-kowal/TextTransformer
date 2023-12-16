package pl.put.poznan.transformer.logic;

import java.util.Map;

import org.apache.commons.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpandTextDecorator extends TextDecorator {
    private static final Logger logger = LoggerFactory.getLogger(ExpandTextDecorator.class);

    Map<String, String> expandMap = Map.ofEntries(
            Map.entry("prof.", "profesor"),
            Map.entry("dr", "doktor"),
            Map.entry("np.", "na przykład"),
            Map.entry("itd.", "i tak dalej"),
            Map.entry("itp.", "i tym podobne")
    );

    public ExpandTextDecorator(Transformer transformer){
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
        for (Map.Entry<String, String> entry : expandMap.entrySet()) {
            String lowerKey = entry.getKey();
            String lowerValue = entry.getValue();
            String upperKey = Character.toUpperCase(lowerKey.charAt(0)) + lowerKey.substring(1);
            String upperValue = Character.toUpperCase(lowerValue.charAt(0)) + lowerValue.substring(1);
            String capitalKey = lowerKey.toUpperCase();
            String capitalValue = lowerValue.toUpperCase();
            text = text.replaceAll(lowerKey , lowerValue);
            text = text.replaceAll(upperKey, upperValue);
            text = text.replaceAll(capitalKey, capitalValue);
        }
        return text;
    }
}
