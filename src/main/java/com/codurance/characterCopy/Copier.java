package com.codurance.characterCopy;

public class Copier {

    private final ISource source;
    private final IDestination destination;

    public Copier(ISource source, IDestination destination) {
        this.source = source;
        this.destination = destination;
    }

    public void Copy() {
        char Char = source.GetChar();
        destination.SetChar(Char);
    }
}
