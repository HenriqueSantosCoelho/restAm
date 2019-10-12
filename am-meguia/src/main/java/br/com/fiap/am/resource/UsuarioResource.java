package br.com.fiap.am.resource;

import br.com.fiap.am.model.Usuario;
import br.com.fiap.am.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="usuario",method = RequestMethod.OPTIONS)
public class UsuarioResource {
    @Autowired
    private UsuarioRepository rep;

    @CrossOrigin
    @GetMapping("listar")
    public List<Usuario> listar(){
        return rep.findAll();
    }

    @CrossOrigin
    @GetMapping("usuarioporemail")
    public Usuario buscarPorEmail(@RequestParam String email){
        return rep.findByEmail(email);
    }

    @CrossOrigin
    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrar(@RequestBody Usuario usuario){
        LocalDate a = LocalDate.now();
        usuario.setData(a);
        return rep.save(usuario);
    }




}
