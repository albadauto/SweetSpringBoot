package br.com.sweetspring.sweetspring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sweetspring.sweetspring.entity.Menu;
import br.com.sweetspring.sweetspring.entity.ResponseHttpAPI;
import br.com.sweetspring.sweetspring.repository.MenuRepository;

@RestController
@RequestMapping("/Menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @PostMapping("/CreateMenu")
    public Menu CreateMenu(@RequestBody Menu menu){
        return this.menuRepository.save(menu);
    }


    @GetMapping("/GetAllMenu")
    public ResponseEntity<?> GetAllMenu(){
        var finded = this.menuRepository.findAll();
        if(finded.size() > 0){
            return ResponseEntity.ok().body(new ResponseHttpAPI<List<Menu>>(){{
                success = true;
                data = finded;
                message = "Registros encontrados com sucesso";
            }});
        }else{
            return ResponseEntity.badRequest().body(new ResponseHttpAPI<List<Menu>>(){{
                success = false;
                data = null;
                message = "Não há registros";
            }});
        }
    }


    @DeleteMapping("/DeleteAllMenu")
    public ResponseEntity<?> DeleteAllMenu(){
        this.menuRepository.TruncateMenu();
        return ResponseEntity.ok().body(new ResponseHttpAPI<>() {{
            success = true;
            data = null; 
            message = "Registros apagados com sucesso";
        }});
    }



}