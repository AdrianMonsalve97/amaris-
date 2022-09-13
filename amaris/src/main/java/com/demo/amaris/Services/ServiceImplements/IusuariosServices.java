package com.demo.amaris.Services.ServiceImplements;

import java.util.List;
import com.demo.amaris.Models.Usuario;

public interface IusuariosServices {

    public Usuario save(Usuario usuarioActual);

    List<Usuario> findByNumeroIdentidad(Long numeroIdentidad);

    Usuario findFirstById(Long id);

    boolean existsByNumeroIdentidad(String numeroIdentidad);

}
