package io.github.com.campeonato.entities.enums;

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

    public static Time fromCodigo(int codigo) {
        for (Time t : Time.values()) {
            if (t.codigo == codigo) {
                return t;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
