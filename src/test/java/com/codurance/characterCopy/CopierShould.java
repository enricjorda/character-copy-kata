package com.codurance.characterCopy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CopierShould {

    ISource source;
    IDestination destination;
    private Copier copier;

    @BeforeEach
    void setUp() {
        source = mock(ISource.class);
        destination = mock(IDestination.class);
        copier = new Copier(source, destination);
    }

    @Test
    void source_GetChar_is_called_when_Copy_is_called() {

        copier = new Copier(source, destination);
        copier.Copy();

        verify(source, atLeastOnce()).GetChar(); //MOCK
    }

    @Test
    void destination_SetChar_is_called_when_Copy_is_called() {
        copier.Copy();

        verify(destination, atLeastOnce()).SetChar(anyChar()); //MOCK

    }

    @Test
    void have_the_same_char_in_source_and_destination() {
        char ANY_CHAR = 'n';

        when(source.GetChar()).thenReturn(ANY_CHAR); //STUB
        copier.Copy();

        verify(destination, atLeastOnce()).SetChar(ANY_CHAR); //MOCK
    }

    @Test
    void destination_not_called_when_source_returns_newline() {
        char NEWLINE = '\n';

        when(source.GetChar()).thenReturn(NEWLINE); //STUB
        copier.Copy();

        verify(destination, never()).SetChar(NEWLINE); //MOCK
    }
}
