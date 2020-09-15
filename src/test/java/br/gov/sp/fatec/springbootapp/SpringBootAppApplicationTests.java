package br.gov.sp.fatec.springbootapp;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Usuario;
import br.gov.sp.fatec.springbootapp.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired    
    private UsuarioRepository usuarioRepo;

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
}
