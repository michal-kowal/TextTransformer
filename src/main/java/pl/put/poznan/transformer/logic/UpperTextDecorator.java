package pl.put.poznan.transformer.logic;

public class UpperTextDecorator extends TextDecorator {
    public UpperTextDecorator(Transformer transformer){
        super(transformer);
    }

    @Override
    public String transform(String text){
        return decorate(super.transform(text));
    }

    public String decorate(String text){
        return text.toUpperCase();
    }
}
