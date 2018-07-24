package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TipePengajuan;
import com.example.demo.service.TipePengajuanService;

@RestController
public class TipePengajuanCrudController {
	@Autowired
    TipePengajuanService tipePengajuanService;
    @RequestMapping(value = "/inserttipePengajuan",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean insertTipePengajuan(@RequestParam("jenis_pengajuan") String jenis_pengajuan){
        TipePengajuan tipePengajuan= new TipePengajuan();
        tipePengajuan.setJenisPengajuan(jenis_pengajuan);
        tipePengajuanService.SaveOrUpdate(tipePengajuan);
        return true;
    }
    @RequestMapping(value = "/updatetipePengajuan",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean updateTipePengajuan(@RequestParam("id")long id,@RequestParam("jenis_pengajuan") String jenis_pengajuan){
        TipePengajuan tipePengajuan= tipePengajuanService.getById(id);
        tipePengajuan.setId(id);
        tipePengajuan.setJenisPengajuan(jenis_pengajuan);;
        tipePengajuanService.SaveOrUpdate(tipePengajuan);
        return true;
    }
    @RequestMapping(value = "/deletetipePengajuan",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean deleteTipePengajuan(@RequestParam("id")long id){
        TipePengajuan tipePengajuan= tipePengajuanService.getById(id);
        tipePengajuanService.deleteTipePengajuan(tipePengajuan);
        return true;
    }
    @RequestMapping(value = "/disabletipePengajuan",method = RequestMethod.POST,headers="Accept=application/json")
    public boolean disableTipePengajuan(@RequestParam("id")long id){
        TipePengajuan tipePengajuan= tipePengajuanService.getById(id);
        tipePengajuan.setStatus("disable");
        tipePengajuanService.SaveOrUpdate(tipePengajuan);
        return true;
    }
}