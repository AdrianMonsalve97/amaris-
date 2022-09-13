package com.demo.amaris.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.demo.amaris.Models.Usuario;

@EnableJpaRepositories
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNumeroIdentidad(String numeroIdentidad);

    boolean existsByNumeroIdentidad(String numeroIdentidad);

    Usuario findFirstById(Long id);

}