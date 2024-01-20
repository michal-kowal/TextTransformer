package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HourTextDecorator extends TextDecorator{
    private static final Logger logger = LoggerFactory.getLogger(ExpandTextDecorator.class);

    public HourTextDecorator(Transformer transformer){
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
        String timePattern = "\\b([01]?[0-9]|2[0-3]):[0-5][0-9]\\b";
        Pattern pattern = Pattern.compile(timePattern);
        Matcher matcher = pattern.matcher(text);
        StringBuilder newText = new StringBuilder();

        while (matcher.find()) {
            String matchedTime = matcher.group();
            String[] timeParts = matchedTime.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);

            int newHours = hours % 12;
            if (newHours == 0) {
                newHours = 12;
            }

            String AMorPM = (hours >= 12) ? "PM" : "AM";
            String replacement = String.format("%d:%02d %s", newHours, minutes, AMorPM);
            matcher.appendReplacement(newText, replacement);
        }

        // Append the remaining part of the original string
        matcher.appendTail(newText);
        text = newText.toString();
        text = text.replaceAll("AM AM", "AM");
        text = text.replaceAll("AM PM", "PM");
        text = text.replaceAll("PM AM", "AM");
        return text;
    }
}
