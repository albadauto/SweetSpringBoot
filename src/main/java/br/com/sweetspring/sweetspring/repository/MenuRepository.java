package br.com.sweetspring.sweetspring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sweetspring.sweetspring.entity.Menu;
import jakarta.transaction.Transactional;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer>{
    List<Menu> findAll();

    @Modifying
    @Transactional
    @Query( value = "DELETE FROM TMENU", nativeQuery = true)
    void TruncateMenu();
}
