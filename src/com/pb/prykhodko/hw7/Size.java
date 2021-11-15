package com.pb.prykhodko.hw7;

public enum Size {
    XXS,
    XS,
    S,
    M,
    L;

     String description;
     int euroSize;

    Size() {
    }

     Size(String description, int euroSize) {
        this.description = description;
        this.euroSize = euroSize;
    }

    public String getDescription(Size size) {
        if (size == XXS) {
            description = "Детский размер";
        } else description = "Взрослый размер";
        return description;
    }

    int getEuroSize(Size size) {
        switch (size) {
            case XXS:
                euroSize = 32;
                break;
            case XS:
                euroSize = 34;
                break;
            case S:
                euroSize = 36;
                break;
            case M:
                euroSize = 38;
                break;
            case L:
                euroSize = 40;
                break;
        }return euroSize;

    }

}
