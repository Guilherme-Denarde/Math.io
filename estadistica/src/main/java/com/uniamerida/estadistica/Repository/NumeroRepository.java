package com.uniamerida.estadistica.Repository;

import com.uniamerida.estadistica.Entity.NumeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumeroRepository extends JpaRepository<NumeroEntity, Long> {
}
