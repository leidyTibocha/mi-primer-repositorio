package modelo;

public enum Generos {
    FANTASIA("Fantasía"),
    CIENCIA_FICCION("Ciencia ficción"),
    DISTOPIA("Distopía"),
    AVENTURA("Aventura"),
    ROMANCE("Romance"),
    MISTERIO("Misterio"),
    THRILLER("Thriller / Suspenso"),
    TERROR("Terror"),
    HISTORICO("Histórico"),
    POLICIACO("Policíaco"),
    LITERARIA("Ficción literaria"),
    REALISMO_MAGICO("Realismo mágico"),
    NOVELA_GRAFICA("Novela gráfica"),
    CUENTO("Cuento"),
    POESIA("Poesía"),
    DRAMA("Drama / Teatro"),
    JUVENIL("Juvenil"),
    INFANTIL("Infantil"),
    BIOGRAFIA("Biografía"),
    ENSAYO("Ensayo"),
    DIVULGACION("Divulgación");

    private final String nameGenero;

    Generos (String nameGenero) {
        this.nameGenero = nameGenero;
    }

    
    @Override
    public String toString() {
        return nameGenero;

    }

}
