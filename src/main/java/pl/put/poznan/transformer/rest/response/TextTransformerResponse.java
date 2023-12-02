package pl.put.poznan.transformer.rest.response;

public class TextTransformerResponse {
    private String text;

    public TextTransformerResponse(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}
