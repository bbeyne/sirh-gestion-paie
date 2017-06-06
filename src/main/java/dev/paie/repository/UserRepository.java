package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur, Integer>{

}
