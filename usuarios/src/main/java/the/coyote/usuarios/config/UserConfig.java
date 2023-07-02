package the.coyote.usuarios.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import the.coyote.usuarios.entities.UsuarioEntity;

public class UserConfig implements UserDetails {
    
    private String nome;
    private String senha;
    private Collection<? extends GrantedAuthority> autorizacoes = new ArrayList<>();

    public UserConfig(UsuarioEntity usuario) {

        System.out.println(usuario);

        List<SimpleGrantedAuthority> permissoes = usuario.getPermissoesEntity().stream().map(item -> {
            return new SimpleGrantedAuthority("ROLE_".concat(item.getPermissoesEnum().getDescricao()));
            }).collect(Collectors.toList());


        if (permissoes.isEmpty()) return;

        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
        this.autorizacoes = permissoes;
    }

    public static UserConfig criar(UsuarioEntity usuarioEntidade) {
        return new UserConfig(usuarioEntidade);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autorizacoes;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
