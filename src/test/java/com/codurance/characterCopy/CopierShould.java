package com.codurance.characterCopy;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

public class CopierShould {

    ISource source = mock(ISource.class);

    @Test
    void receive_a_character() {
        when(source.GetChar()).thenReturn('n');
        Copier copier = new Copier(source);
        copier.Copy();

        verify(source, atLeastOnce()).GetChar();
    }
}
