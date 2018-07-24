package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import com.example.demo.service.*;

import de.odysseus.el.tree.impl.Parser.ParseException;

import java.sql.Time;
import java.util.List;
@RestController
public class PengingatController {
	 @Autowired
	 PengingatService pengingatService;

	 
//========================================== CRUD PENGINGAT=================================================
	
	 //Select All Pengingat
	 @RequestMapping(value = "/pengingat")
	 public List<Pengingat> pengingatList(){
	     return pengingatService.getAllPengingat();
	 }
	 
	 //Insert Pengingat
	 @RequestMapping(value = "/insertpengingat/",method = RequestMethod.POST,headers="Accept=application/json")
	    public boolean insertPengingat(@RequestParam(value = "nama_pengingat",required = false) String nama_pengingat,
	                                      @RequestParam (value = "waktu_pengingat", required = false) @DateTimeFormat(pattern="HH:mm:ss") Time waktu_pengingat,
	                                     @RequestParam(value = "deskripsi_pengingat", required = false) String deskripsi_pengingat
	                                    
	    ){
	        Pengingat pengingat = new Pengingat();

	        pengingat.setNama_pengingat(nama_pengingat);
	        pengingat.setWaktu_pengingat(waktu_pengingat);
	        pengingat.setDeskripsi_pengingat(deskripsi_pengingat);
	        pengingatService.SaveOrUpdate(pengingat);
	        return true;
	    }
	 
	 //Update Pengingat
	 @RequestMapping(value = "/updatepengingat/",method = RequestMethod.POST,headers="Accept=application/json")
	    public boolean updatePengingat(@RequestParam(value = "id",required = false)  Long id,
							    		@RequestParam(value = "nama_pengingat",required = false) String nama_pengingat,
						                @RequestParam (value = "waktu_pengingat", required = false) @DateTimeFormat(pattern="HH:mm:ss") Time waktu_pengingat,
						               @RequestParam(value = "deskripsi_pengingat", required = false) String deskripsi_pengingat
	    )throws ParseException {
		 	Pengingat pengingat = pengingatService.getById(id);
		 	
	        pengingat.setNama_pengingat(nama_pengingat);
	        pengingat.setWaktu_pengingat(waktu_pengingat);
	        pengingat.setDeskripsi_pengingat(deskripsi_pengingat);
	        pengingatService.SaveOrUpdate(pengingat);
	        return true;
	    }
	 
	 //Delete Pengingat
	 @RequestMapping(value = "/deletepengingat/",method = RequestMethod.POST,headers="Accept=application/json")
	    public boolean deletePengingat(@RequestParam(value = "id",required = false)  Long id)throws ParseException {
		 Pengingat pengingat = pengingatService.getById(id);
		 pengingatService.deletePengingat(pengingat);
		 return true;
	    }
	@RequestMapping(value = "/disablepengingat/",method = RequestMethod.POST,headers="Accept=application/json")
	public boolean disablePengingat(@RequestParam(value = "id",required = false)  Long id)throws ParseException {
		Pengingat pengingat = pengingatService.getById(id);
		pengingat.setStatus("Disable");
		pengingatService.SaveOrUpdate(pengingat);
		return true;
	}
}
