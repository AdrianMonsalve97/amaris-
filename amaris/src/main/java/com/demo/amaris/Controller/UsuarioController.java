package com.demo.amaris.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.maven.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.amaris.Dto.Mensaje;
import com.demo.amaris.Dto.UsuarioDto;
import com.demo.amaris.Models.Usuario;
import com.demo.amaris.Models.Enums.tipoDocumento;
import com.demo.amaris.Services.UsuarioService;

@Controller
@RequestMapping("amaris")

public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    // @GetMapping("/lista")
    // public ResponseEntity<List<Usuario>> list() {
    //     List<Usuario> list = usuarioService.list();
    //     return new ResponseEntity(list, HttpStatus.OK);
    // }
    // @RequestMapping(value="submitForm.html", method=RequestMethod.POST)
    // public ModelAndView submitForm(@RequestParam Map<String, String> reqParam) {
    //     String name  = reqParam.get("tipoDocumento");
    //     String email = reqParam.get("numeroIdentidad");     
    //     ModelAndView model = new ModelAndView("AdmissionSuccess");
    //     model.addObject("msg", "Details submitted by you::Name: " + name
    //                                                 + ", Email: " + email );
    // }

    @GetMapping(value = "/editar/{numeroIdentidad}")
public String mostrarDatos(@PathVariable String numeroIdentidad, Model model) {
    model.addAttribute("usuario", usuarioService.findByNumeroIdentidad(numeroIdentidad));
    return "usuario/editar_usuario";
}

    @PostMapping("/Usercreated")
    public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto) {
        if (StringUtils.isBlank(usuarioDto.getNumeroIdentidad()))
            return new ResponseEntity(new Mensaje("el apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        else if (usuarioService.existsByNumeroIdentidad(usuarioDto.getNumeroIdentidad()))
            return new ResponseEntity(new Mensaje("nombre ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario(usuarioDto.getId(), usuarioDto.getPrimernombre(), usuarioDto.getSegundonombre(),
                usuarioDto.getPrimerapellido(), usuarioDto.getSegundoapellido(), usuarioDto.getNumeroIdentidad(),
                usuarioDto.getTelefono(), usuarioDto.getDireccion(), usuarioDto.getCiudad());
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("cliente creado"), HttpStatus.OK);
    }

    // @PostMapping("/crearusuario")
    // private Usuario save(@RequestBody Usuario usuario) {
    // usuarioService.save(usuario);
    // return usuario;
    // }

    @DeleteMapping("/deletcluser/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        usuarioService.delete(id);
        response.put("mensaje", "usuario eliminado con exito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
