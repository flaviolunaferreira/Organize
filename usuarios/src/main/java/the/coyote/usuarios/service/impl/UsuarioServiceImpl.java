package the.coyote.usuarios.service.impl;

@Service
public class UsuarioServiceImpl {

        private final UsuarioRepositorio usuarioRepositorio;
    private final PermissaoService permissaoService;

    private BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    private final Cpf cpf;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepositorio usuarioRepositorio, PermissaoService permissaoService, Cpf cpf) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.permissaoService = permissaoService;
        this.cpf = cpf;
    }


    /**
     * @param usuarioDtoRequisicao
     * @return
     */
    @Override
    public UsuarioDtoResposta salvarNovoUsuario(UsuarioDtoRequisicao usuarioDtoRequisicao) throws ValorDuplicado {
        // encriptando a senha do usuário.
        usuarioDtoRequisicao.setSenha(encoder().encode(usuarioDtoRequisicao.getSenha()));

        UsuarioEntidade procurarPorCpf = usuarioRepositorio.findUsuarioByCpf(
                cpf.formataCpf(usuarioDtoRequisicao.getCpf()));
        if (procurarPorCpf == null)
            return new UsuarioDtoResposta(usuarioRepositorio.save(usuarioDtoRequisicao.novoUsuario()));
        throw new ValorDuplicado("Sinto Muito... Cpf Já cadastrado!");
    }

    /**
     * @param usuario 
     * @param senha
     * @return
     */
    @Override
    public Boolean validarUsuario(String usuario, String senha) {
        // procurando o usuario pelo nome
        Optional<UsuarioEntidade> opUsuario = usuarioRepositorio.findByNome(usuario);
        // se não existir já retorna falso
        if (opUsuario.isEmpty()) return false;

        // se o usuario existir vou pegar o cadastro dele
        UsuarioEntidade usuarioEntidade = opUsuario.get();

        // agora validando a senha
        return encoder().matches(senha, usuarioEntidade.getSenha());

    }


    @Override
    public UsuarioEntidade buscarUsuarioPorId(Long usuario) throws NaoEncontrado {
        return usuarioRepositorio.findById(usuario)
                .orElseThrow(() ->  new NaoEncontrado("Desculpe, mas não encontrei o usuário com o id: " + usuario));
    }


    /**
     * @return
     */
    @Override
    public List<UsuarioDtoResposta> listarTodosUsuarios(int pagina, int itens) {

        if(itens > 50) itens = 50;

        PageRequest page = PageRequest.of(pagina, itens);

        Page<UsuarioEntidade> lista = usuarioRepositorio.findAll(page);

        return lista.stream().map(UsuarioDtoResposta::new).collect(Collectors.toList());

    }
    
}