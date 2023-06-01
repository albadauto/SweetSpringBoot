package br.com.sweetspring.sweetspring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sweetspring.sweetspring.entity.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer>{
    List<Menu> findAll();

    @Query( value = "DELETE u FROM u.MENU", nativeQuery = true)
    void TruncateMenu();
}
