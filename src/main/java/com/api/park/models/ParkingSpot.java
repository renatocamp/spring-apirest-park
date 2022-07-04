/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.park.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARKING_SPOT_TB")
public class ParkingSpot implements Serializable{
    private static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable =false, unique = true, length =10)
    private String parkSpotNumber;
    
    @Column(nullable =false, unique = true, length =7)
    private String licensePlateCar;
    
    @Column(nullable = false, length = 50)
    private String brandCar;
    
    @Column(nullable = false, length = 50)
    private String modelCar;
    
    @Column(nullable = false, length = 25)
    private String colorCar;
    
    @Column(nullable = false)
    private LocalDateTime registrationDate;
    
    @Column(nullable = false, length = 20)
    private String apartament;
    
    @Column(nullable = false, length = 20)
    private String block;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return the parkSpotNumber
     */
    public String getParkSpotNumber() {
        return parkSpotNumber;
    }

    /**
     * @param parkSpotNumber the parkSpotNumber to set
     */
    public void setParkSpotNumber(String parkSpotNumber) {
        this.parkSpotNumber = parkSpotNumber;
    }

    /**
     * @return the licensePlateCar
     */
    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    /**
     * @param licensePlateCar the licensePlateCar to set
     */
    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    /**
     * @return the brandCar
     */
    public String getBrandCar() {
        return brandCar;
    }

    /**
     * @param brandCar the brandCar to set
     */
    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    /**
     * @return the modelCar
     */
    public String getModelCar() {
        return modelCar;
    }

    /**
     * @param modelCar the modelCar to set
     */
    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    /**
     * @return the colorCar
     */
    public String getColorCar() {
        return colorCar;
    }

    /**
     * @param colorCar the colorCar to set
     */
    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    /**
     * @return the registrationDate
     */
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * @return the apartament
     */
    public String getApartament() {
        return apartament;
    }

    /**
     * @param apartament the apartament to set
     */
    public void setApartament(String apartament) {
        this.apartament = apartament;
    }

    /**
     * @return the block
     */
    public String getBlock() {
        return block;
    }

    /**
     * @param block the block to set
     */
    public void setBlock(String block) {
        this.block = block;
    }
    
   
}
