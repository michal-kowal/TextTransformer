package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpandTextDecoratorTest {

    @Test
    void testDecorateProf() {
        ExpandTextDecorator decorator = new ExpandTextDecorator(null);

        String result = decorator.decorate("prof.");

        assertEquals("profesor", result);
    }

    @Test
    void testDecorateDr() {
        ExpandTextDecorator decorator = new ExpandTextDecorator(null);

        String result = decorator.decorate("dr");

        assertEquals("doktor", result);
    }

    @Test
    void testDecorateNp() {
        ExpandTextDecorator decorator = new ExpandTextDecorator(null);

        String result = decorator.decorate("np.");

        assertEquals("na przykład", result);
    }

    @Test
    void testDecorateItd() {
        ExpandTextDecorator decorator = new ExpandTextDecorator(null);

        String result = decorator.decorate("itd.");

        assertEquals("i tak dalej", result);
    }

    @Test
    void testDecorateItp() {
        ExpandTextDecorator decorator = new ExpandTextDecorator(null);

        String result = decorator.decorate("itp.");

        assertEquals("i tym podobne", result);
    }

    @Test
    void testDecorateCapitalized() {
        ExpandTextDecorator decorator = new ExpandTextDecorator(null);

        String result = decorator.decorate("Itp. Itd. Dr");

        assertEquals("I tym podobne I tak dalej Doktor", result);
    }

    @Test
    void testDecorateUpper() {
        ExpandTextDecorator decorator = new ExpandTextDecorator(null);

        String result = decorator.decorate("PROF. DR NP.");

        assertEquals("PROFESOR DOKTOR NA PRZYKŁAD", result);
    }

    @Test
    void testDecorateMixed() {
        ExpandTextDecorator decorator = new ExpandTextDecorator(null);

        String result = decorator.decorate("PROF. prof. Prof.");

        assertEquals("PROFESOR profesor Profesor", result);
    }

    @Test
    void testDecorateNoDot() {
        ExpandTextDecorator decorator = new ExpandTextDecorator(null);

        String result = decorator.decorate("prof");

        assertEquals("prof", result);
    }
    @Test
    void testDecorateWithDot() {
        ExpandTextDecorator decorator = new ExpandTextDecorator(null);

        String result = decorator.decorate("dr.");

        assertEquals("doktor.", result);
    }
}