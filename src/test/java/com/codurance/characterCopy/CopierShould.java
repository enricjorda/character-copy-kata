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

        verify(destination, atLeastOnce()).SetChar(anyChar());

    }

    @Test
    void have_the_same_char_in_source_and_destination() {
        char ANY_CHAR = 'n';

        when(source.GetChar()).thenReturn(ANY_CHAR);
        Copier copier = new Copier(source, destination);
        copier.Copy();

        verify(destination, atLeastOnce()).SetChar(ANY_CHAR);
    }

    @Test
    void destination_not_called_when_source_returns_newline() {
        char NEWLINE = '\n';

        when(source.GetChar()).thenReturn(NEWLINE);
        Copier copier = new Copier(source, destination);
        copier.Copy();

        verify(destination, never()).SetChar(NEWLINE);
    }
}
