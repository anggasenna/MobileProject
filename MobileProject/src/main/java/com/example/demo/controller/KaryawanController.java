package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.hibernate.boot.jaxb.hbm.spi.Adapter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KaryawanController {
    @Autowired
    VenueService venueService;
    @Autowired
    JabatanService jabatanService;
    @Autowired
    TeamServices teamServices;
    @Autowired
    TipeKaryawanService tipeKaryawanService;
    @Autowired
    AkunBankService akunBankService;
    @Autowired
    RoleLoginService roleLoginService;
    @Autowired
    KaryawanService karyawanService;
    @Autowired
    DataLoginService dataLoginService;
 
    @RequestMapping(value = "/insertkaryawan",method = RequestMethod.POST,headers = "Accept=application/json")
    public void insertKaryawan(@ModelAttribute("DataLogin") DataLogin dl,@ModelAttribute("Karayawan")Karyawan k,
                                  @RequestParam("first_name")String first_name,@RequestParam("last_name")String last_name,
                                  @RequestParam("kode_karyawan")String kode_karyawan,@RequestParam("no_rekening")String no_rekening,
                                  @RequestParam("nama_rekening")String nama_rekening,@RequestParam("idakunbank")long idakunbank,
                                  @RequestParam("idjabatan")long idjabatan,@RequestParam("idteam")long idteam,
                                  @RequestParam("idtipekarya")long idtipekarya,@RequestParam("idvenue")long idvenue,
                                  @RequestParam("email")String email,@RequestParam("password")String password,
                                  @RequestParam("idrolelogin")long idrolelogin){

        k.setFirst_name(first_name);
        k.setLast_name(last_name);
        k.setKode_karyawan(kode_karyawan);
        k.setNo_rekening(no_rekening);
        k.setNama_rekening(nama_rekening);
        k.setAkunBank(akunBankService.getById(idakunbank));
        k.setJabatan(jabatanService.getById(idjabatan));
        k.setTeam(teamServices.getById(idteam));
        k.setTipeKaryawan(tipeKaryawanService.getById(idtipekarya));
        k.setVenue(venueService.getById(idvenue));
        k = karyawanService.SaveOrUpdate(k);
        dl.setKaryawan(k);
        dl.setEmail(email);
        dl.setPassword(password);
        dl.setRoleLogin(roleLoginService.getById(idrolelogin));
        dataLoginService.SaveOrUpdate(dl);
    }
    @RequestMapping(value = "/updatekaryawan",method = RequestMethod.POST,headers = "Accept=application/json")
    public void updatetKaryawan(@ModelAttribute("DataLogin") DataLogin dl,@ModelAttribute("Karayawan")Karyawan k,
                               @RequestParam("first_name")String first_name,@RequestParam("last_name")String last_name,
                               @RequestParam("kode_karyawan")String kode_karyawan,@RequestParam("no_rekening")String no_rekening,
                               @RequestParam("nama_rekening")String nama_rekening,@RequestParam("idakunbank")long idakunbank,
                               @RequestParam("idjabatan")long idjabatan,@RequestParam("idteam")long idteam,
                               @RequestParam("idtipekarya")long idtipekarya,@RequestParam("idvenue")long idvenue,
                               @RequestParam("email")String email,@RequestParam("password")String password,
                               @RequestParam("idrolelogin")long idrolelogin,@RequestParam("idkaryawan")long idkaryawan){
        Karyawan karyawan = karyawanService.getById(idkaryawan);
        karyawan.setFirst_name(first_name);
        karyawan.setLast_name(last_name);
        karyawan.setKode_karyawan(kode_karyawan);
        karyawan.setNo_rekening(no_rekening);
        karyawan.setNama_rekening(nama_rekening);
        karyawan.setAkunBank(akunBankService.getById(idakunbank));
        karyawan.setJabatan(jabatanService.getById(idjabatan));
        karyawan.setTeam(teamServices.getById(idteam));
        karyawan.setTipeKaryawan(tipeKaryawanService.getById(idtipekarya));
        karyawan.setVenue(venueService.getById(idvenue));
        k = karyawanService.SaveOrUpdate(karyawan);
        dl.setKaryawan(k);
        dl.setEmail(email);
        dl.setPassword(password);
        dl.setRoleLogin(roleLoginService.getById(idrolelogin));
        dataLoginService.SaveOrUpdate(dl);
    }

}
