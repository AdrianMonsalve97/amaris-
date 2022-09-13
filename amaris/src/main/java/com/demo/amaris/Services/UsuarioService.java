package com.demo.amaris.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.amaris.Models.Usuario;
import com.demo.amaris.Respository.UsuarioRepository;
import com.demo.amaris.Services.ServiceImplements.IusuariosServices;

@Service
public class UsuarioService implements IusuariosServices {

    @Autowired

    UsuarioRepository usuarioRepository;

    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }

     @Override
    public List<Usuario> findByNumeroIdentidad(Long numeroidentidad) {
     return usuarioRepository.findByNumeroIdentidad(numeroidentidad);
    }

    @Override
    public Usuario findFirstById(Long id) {
        return usuarioRepository.findFirstById(id);
    }

    // @Override

     public boolean existsByNumeroIdentidad(String numeroidentidad) {
     return usuarioRepository.existsByNumeroIdentidad(numeroidentidad);
    }

}
