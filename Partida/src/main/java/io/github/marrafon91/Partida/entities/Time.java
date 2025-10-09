package io.github.marrafon91.Partida.entities;

public enum Time {
    CORINTHIANS(1),
    PALMEIRAS(2),
    SANTOS(3),
    SAO_PAULO(4),
    FLAMENGO(5),
    VASCO(6),
    BOTAFOGO(7),
    FLUMINENSE(8),
    GREMIO(9);

    private final int codigo;

    Time(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Time codigoTime(int codigo) {
        for (Time time : Time.values()) {
            if (codigo == time.getCodigo()) {
                return time;
            }
        }
        throw new IllegalArgumentException("Time inválido: " + codigo);
    }
}
