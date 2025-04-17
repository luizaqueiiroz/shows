package com.gerenciamentoDeShow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamentoDeShow.Entities.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

}
