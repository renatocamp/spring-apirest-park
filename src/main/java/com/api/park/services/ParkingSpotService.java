/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.park.services;

import com.api.park.models.ParkingSpot;
import com.api.park.repositories.ParkingSpotRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {
    
    final ParkingSpotRepository parkingSpotRepository;
    
    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }
    
    @Transactional
    public ParkingSpot save(ParkingSpot parkingSpot){
        return parkingSpotRepository.save(parkingSpot);
    }

    public boolean existsByLicencePlateCar(String licensePlateCar) {
        
        return parkingSpotRepository.existsByLicencePlateCar(licensePlateCar);
    }

    public boolean existsByParkSpotNumber(String parkSpotNumber) {
       
        return parkingSpotRepository.existsByParkSpotNumber(parkSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartament, String block) {
        
        return parkingSpotRepository.existsByApartmentAndBlock(apartament, block);
    }
    
    public List<ParkingSpot> findAll(){
        return parkingSpotRepository.findAll();
    }

    public Optional<ParkingSpot> findById(UUID id) {
       return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpot parkingSpot) {
        parkingSpotRepository.delete(parkingSpot);
    }

}
