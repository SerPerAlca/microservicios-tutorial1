package com.carro.service.servicio;

import com.carro.service.entity.Carro;
import com.carro.service.repositorio.CarroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepositorio carroRepositorio;

    public List<Carro> getAll(){
        return carroRepositorio.findAll();
    }

    public Carro getCarroById( int id){
        return carroRepositorio.findById(id).orElse(null);
    }

    public Carro save(Carro carro){
        Carro newCarro = carroRepositorio.save(carro);
        return newCarro;
    }

    public List<Carro> byUsuarioId(int usuarioId){

        return carroRepositorio.findByUsuarioId(usuarioId);
    }
}
