package pl.put.poznan.transformer.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextDecoratorTest {

    private Transformer mockTransformer;
    private TextDecorator textDecorator;

    @BeforeEach
    void setUp() {
        mockTransformer = mock(Transformer.class);

        textDecorator = new TextDecorator(mockTransformer) {
            @Override
            public String decorate(String text) {
                return null;
            }
        };
    }

    @Test
    void testTransform() {
        String inputText = "Hello, World!";
        String transformedText = "Transformed Text";

        when(mockTransformer.transform(inputText)).thenReturn(transformedText);

        String result = textDecorator.transform(inputText);

        assertEquals(transformedText, result);

        verify(mockTransformer, times(1)).transform(inputText);
    }
}