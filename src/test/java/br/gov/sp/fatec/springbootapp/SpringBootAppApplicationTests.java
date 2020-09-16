package br.gov.sp.fatec.springbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Autorizacao;
import br.gov.sp.fatec.springbootapp.entity.Usuario;
import br.gov.sp.fatec.springbootapp.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springbootapp.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired    
    private UsuarioRepository usuarioRepo;

    @Autowired    
    private AutorizacaoRepository autRepo;

	@Test
	void contextLoads() {
    }

    @Test
    void testaInsercao(){
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario");
        usuario.setSenha("SenhaMuit0");
        usuarioRepo.save(usuario);
        assertNotNull(usuario.getId());
    }  

    @Test
    void testaAutorizacao(){
        Usuario usuario = usuarioRepo.findById(1L).get();
        assertEquals("ROLE_ADMIN", usuario.getAutorizacoes().iterator().next().getNome());
    }
    
    @Test
    void testaUsuario(){
        Autorizacao aut = autRepo.findById(1L).get();
        assertEquals("Caique", aut.getUsuarios().iterator().next().getNome());
    }
}
