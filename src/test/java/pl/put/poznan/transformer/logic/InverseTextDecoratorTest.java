package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InverseTextDecoratorTest {
    @Test
    void testDecorateWithUpperCase() {
        InverseTextDecorator decorator = new InverseTextDecorator(null);

        String result = decorator.decorate("Hello");

        assertEquals("Olleh", result);
    }

    @Test
    void testDecorateWithMixedCase() {
        InverseTextDecorator decorator = new InverseTextDecorator(null);

        String result = decorator.decorate("JavaProGram");

        assertEquals("MargOrpAvaj", result);
    }

    @Test
    void testDecorateWithLowerCase() {
        InverseTextDecorator decorator = new InverseTextDecorator(null);

        String result = decorator.decorate("world");

        assertEquals("dlrow", result);
    }

    @Test
    void testDecorateWithEmptyInput() {
        InverseTextDecorator decorator = new InverseTextDecorator(null);

        String result = decorator.decorate("");

        assertEquals("", result);
    }
}
