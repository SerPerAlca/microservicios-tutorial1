package com.moto.service.controller;


import com.moto.service.entity.Moto;
import com.moto.service.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> listarMotos(){
        List<Moto> motoList = motoService.getAll();
        if(motoList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motoList);
    }

    @PostMapping
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){
        Moto newMoto = motoService.save(moto);
        return ResponseEntity.ok(newMoto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id){
        Moto moto = motoService.getMotoById(id);
        if(null == moto){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotosPorUsuarioId(@PathVariable("usuarioId") int id){
        List<Moto> motos = motoService.byUsuarioId(id);
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }


}
