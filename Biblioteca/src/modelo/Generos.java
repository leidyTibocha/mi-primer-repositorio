package modelo;


public enum Generos {
    FANTASIA(1, "Fantasía"),
    CIENCIA_FICCION(2, "Ciencia ficción"),
    DISTOPIA(3, "Distopía"),
    AVENTURA(4, "Aventura"),
    ROMANCE(5, "Romance"),
    MISTERIO(6, "Misterio"),
    THRILLER(7, "Thriller / Suspenso"),
    TERROR(8, "Terror"),
    HISTORICO(9, "Histórico"),
    POLICIACO(10, "Policíaco"),
    LITERARIA(11, "Ficción literaria"),
    REALISMO_MAGICO(12, "Realismo mágico"),
    NOVELA_GRAFICA(13, "Novela gráfica"),
    CUENTO(14, "Cuento"),
    POESIA(15, "Poesía"),
    DRAMA(16, "Drama / Teatro"),
    JUVENIL(17, "Juvenil"),
    INFANTIL(18, "Infantil"),
    BIOGRAFIA(19, "Biografía"),
    ENSAYO(20, "Ensayo"),
    DIVULGACION(21, "Divulgación");

    private final int codigo;
    private final String descripcion;

    Generos(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }


}


