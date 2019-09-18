package br.com.caelum.twittelum.controller;

import br.com.caelum.twittelum.dao.TweetDao;
import br.com.caelum.twittelum.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reseta")
public class ResetaController {

    private TweetDao tweetDao;
    private UsuarioDao usuarioDao;

    @Autowired
    public ResetaController(TweetDao tweetDao, UsuarioDao usuarioDao) {
        this.tweetDao = tweetDao;
        this.usuarioDao = usuarioDao;
    }


    @GetMapping(value = "/deleta-tudo-da-vida")
    public ResponseEntity deletaTudo() {
        tweetDao.deleteAll();
        usuarioDao.deleteAll();

        return ResponseEntity.ok().body("Todos os tweets e usuários foram apagados");
    }
}
