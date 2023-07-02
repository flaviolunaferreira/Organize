package the.coyote.usuarios.uteis;

public enum PermissoesEnum {
    
    ADMINISTRADOR("ADMINISTRADOR"),
    GERENTE("GERENTE"),
    USUARIO("USUARIO");

    private final String descricao;

    PermissoesEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
