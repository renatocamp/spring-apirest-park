/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.park.repositories;

import com.api.park.models.ParkingSpot;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, UUID>{
    
    boolean existsByLicencePlateCar(String licensePlateCar);
    boolean existsByParkSpotNumber(String parkingSpotNumber);
    boolean existsByApartmentAndBlock(String apartmentBlock, String block);
}
