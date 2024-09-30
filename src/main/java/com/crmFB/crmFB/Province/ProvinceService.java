package com.crmFB.crmFB.Province;

import java.util.List;

public class ProvinceService {

    private ProvinceRepository provinceRepository;
    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    public void addNewProvince(Province province) {
        provinceRepository.save(province);
    }


    public void deleteProvince(Long provinceId) {
        boolean exist = provinceRepository.existsById(provinceId);
        if(!exist){
            throw new IllegalStateException("This province does not exist");
        }
        provinceRepository.deleteById(provinceId);
    }


    public void updateProvince(Long provinceId, String provinceName, boolean visit) {
        Province province = provinceRepository.findById(provinceId).orElseThrow(() -> new IllegalStateException("Province id does not existe"));
        if(provinceName != null && provinceName.length() > 0 ){
            province.setProvinceName(provinceName);
        }
        province.setVisit(visit);
    }
}
