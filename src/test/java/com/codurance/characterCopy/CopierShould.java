package com.codurance.characterCopy;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CopierShould {

    ISource source = mock(ISource.class);

    IDestination destination = mock(IDestination.class);
    @Test
    void source_GetChar_is_called_when_Copy_is_called() {

        Copier copier = new Copier(source, destination);
        copier.Copy();

        verify(source, atLeastOnce()).GetChar();
    }

    @Test
    void destination_SetChar_is_called_when_Copy_is_called() {
        Copier copier = new Copier(source, destination);
        copier.Copy();

        verify(destination, atLeastOnce()).SetChar(' ');

    }

    @Test
    void have_the_same_char_in_source_and_destination() {
        when(source.GetChar()).thenReturn('n');
        Copier copier = new Copier(source, destination);
        copier.Copy();

        verify(destination, atLeastOnce()).SetChar('n');
    }
}
