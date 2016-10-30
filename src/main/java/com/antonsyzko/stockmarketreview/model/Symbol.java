package com.antonsyzko.stockmarketreview.model;

/**
 * Created by Admin on 24.07.2016.
 * @author Anton Syzko
 */
public class Symbol {

    private String code;
    private String description;

    public Symbol(String code, String description) {
        super();
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }
    public String getDescription() {
        return this.description;
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        Symbol symbol;
        if ((o instanceof Symbol)) {
            symbol = (Symbol) o;
        } else {
            return false;
        }
        return this.code.equals(symbol.getCode());
    }
}

