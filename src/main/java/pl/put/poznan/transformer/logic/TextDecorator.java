package pl.put.poznan.transformer.logic;

public abstract class TextDecorator implements Transformer {
    private Transformer transformer;
    
    public TextDecorator(Transformer transformer){
        this.transformer = transformer;
    }

    @Override
    public String transform(String text){
        String transformed = transformer.transform(text);
        return transformed;
    }

    public abstract String decorate(String text);
}
