package pl.put.poznan.transformer.logic;

public class LowerTextDecorator extends TextDecorator{
    public LowerTextDecorator(Transformer transformer){
        super(transformer);
    }

    @Override
    public String transform(String text){
        return decorate(super.transform(text));
    }

    public String decorate(String text){
        return text.toLowerCase();
    }
}
