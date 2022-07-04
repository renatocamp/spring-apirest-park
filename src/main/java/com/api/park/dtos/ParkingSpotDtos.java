/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.park.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class ParkingSpotDtos {
    
    @NotBlank
    private String parkSpotNumber;
    
    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;
    
    @NotBlank
    private String brandCar;
    
    @NotBlank
    private String modelCar;
    
    @NotBlank
    private String colorCar;
    
    @NotBlank
    private String reponsibleName;
    
    @NotBlank
    private String apartament;
    
    @NotBlank
    private String block;

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
     * @return the reponsibleName
     */
    public String getReponsibleName() {
        return reponsibleName;
    }

    /**
     * @param reponsibleName the reponsibleName to set
     */
    public void setReponsibleName(String reponsibleName) {
        this.reponsibleName = reponsibleName;
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
