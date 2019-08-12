package com.codurance.characterCopy;

public class Copier {

    private final ISource source;

    public Copier(ISource source, IDestination destination) {
        this.source = source;
    }

    public void Copy() {
        source.GetChar();
    }
}
