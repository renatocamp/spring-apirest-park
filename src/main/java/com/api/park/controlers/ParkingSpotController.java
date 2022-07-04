/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.park.controlers;

import com.api.park.dtos.ParkingSpotDtos;
import com.api.park.models.ParkingSpot;
import com.api.park.services.ParkingSpotService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    
    final ParkingSpotService  parkingSpotService;
    
    public ParkingSpotController(ParkingSpotService parkingSpotService){
        this.parkingSpotService = parkingSpotService;
    }
    
    @PostMapping
    public ResponseEntity<Object> saveParkingSpot
        (@RequestBody @Valid ParkingSpotDtos parkingSpotDtos){
        
        if(parkingSpotService.existsByLicencePlateCar(parkingSpotDtos.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict:"
                    + "Esta licensa já está em uso");
        }
        if(parkingSpotService.existsByParkSpotNumber(parkingSpotDtos.getParkSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict:"
                    + "Esta vaga já está em uso!");
        }
        if(parkingSpotService.existsByApartmentAndBlock(parkingSpotDtos
                .getApartament(),parkingSpotDtos.getBlock()))
                {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict:"
                    + "Esta vaga já está reservada para o apartamento/block!");
        }
               
        var parkSpotModel = new ParkingSpot();
        BeanUtils.copyProperties(parkingSpotDtos, parkSpotModel);
        parkSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UCT")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService
        .save(parkSpotModel));
                
    }
        
    @GetMapping
    public ResponseEntity<List<ParkingSpot>> getAllParkingSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSpot(@PathVariable(value = "id")UUID id){
        Optional<ParkingSpot> parkingSpotOptinal = parkingSpotService.findById(id);
        if(!parkingSpotOptinal.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotOptinal.get());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkSpot(@PathVariable(value = "id")UUID id){
        Optional<ParkingSpot> parkOptional = parkingSpotService.findById(id);
        if(!parkOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada");
        }
        parkingSpotService.delete(parkOptional.get());
        ResponseEntity.status(HttpStatus.OK).body(parkOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Delete realizado com sucesso");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id")UUID id,
            @RequestBody @Valid ParkingSpotDtos parkingSpotDtos){
        Optional<ParkingSpot> parkOptional = parkingSpotService.findById(id);
        if(!parkOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
        }
    var parkingSpotModel = new ParkingSpot();
    BeanUtils.copyProperties(parkingSpotDtos, parkingSpotModel);
    parkingSpotModel.setId(parkOptional.get().getId());
    parkingSpotModel.setRegistrationDate(parkOptional.get().getRegistrationDate());
    return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
    
    }
}
