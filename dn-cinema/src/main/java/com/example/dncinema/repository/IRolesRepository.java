package com.example.dncinema.repository;

import com.example.dncinema.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Integer> {
    @Query(value = "select * from roles where name_roles like :name", nativeQuery = true)
    Roles findRolesByName(String name);
}
