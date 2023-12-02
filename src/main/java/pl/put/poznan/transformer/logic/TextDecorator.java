package pl.put.poznan.transformer.logic;

public abstract class TextDecorator implements Transformer {
    private Transformer transformer;
    
    public TextDecorator(Transformer transformer){
        this.transformer = transformer;
    }

    @Override
    public String transform(String text){
        return transformer.transform(text);
    }
}
