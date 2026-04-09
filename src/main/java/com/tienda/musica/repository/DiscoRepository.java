package com.tienda.musica.repository;

import com.tienda.musica.model.Disco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscoRepository extends JpaRepository<Disco, String> {
}
