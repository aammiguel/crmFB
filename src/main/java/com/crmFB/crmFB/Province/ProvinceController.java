package com.crmFB.crmFB.Province;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Province")
public class ProvinceController {

    /**
     * Injection
     */
    private ProvinceService provinceService;

    /**
     * getAll provinces uses provinceService method to retrieve all provinces in a list
     * @return list of all provinces
     */
    @GetMapping
    public List<Province> getAllProvinces(){
        return provinceService.getAllProvinces();
    }

    /**
     * registerProvince save a new province
     * @param province takes a province to be saved
     */
    @PostMapping
    public void registerProvince(@RequestBody Province province){
        provinceService.addNewProvince(province);
    }

    /**
     * deleteProvince uses province service methods to find a province with id and delete it
     * @param provinceId takes a province id to find a province you want to delete
     */
    @DeleteMapping(path = "{provinceId}")
    public void deleteProvince(@PathVariable("provinceId") Long provinceId){
        provinceService.deleteProvince(provinceId);
    }

    /**
     * updates a province
     * @param provinceId takes an id
     * @param provinceName takes a province name
     * @param visit indicates if the province was visited or not
     */
    @PutMapping(path = "{provinceId}")
    public void updateProvince(@PathVariable("provinceId") Long provinceId,
                               @RequestBody(required = false) String provinceName,
                               @RequestBody(required = false) boolean visit){
        provinceService.updateProvince(provinceId, provinceName, visit);
    }
}
