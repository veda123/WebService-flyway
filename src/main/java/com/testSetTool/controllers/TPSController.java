package com.testSetTool.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.testSetTool.entities.RepairCapability;
import com.testSetTool.entities.TPS;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.RepairCapabilityRepository;
import com.testSetTool.repositories.TPSRepository;

@RestController
@RequestMapping("/api")
public class TPSController {
	@Autowired
	private RepairCapabilityRepository capabilityRepository;
	@Autowired
	private TPSRepository tpsRepository;
	
	@GetMapping("/tps")
	public List<TPS> getTPS(){	
		return tpsRepository.findAll();
	}
	
	@GetMapping("/tps/{id}")
	public TPS getTPSById(@PathVariable("id") Integer id) {
		return tpsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TPS Id " + id + " not found"));
	}
	
	@PostMapping("/tps/{capabilityId}")
	public Optional<Object> createTPS(@PathVariable("capabilityId") Integer capabilityId,
			                          @Valid @RequestBody TPS tps) {
		return capabilityRepository.findById(capabilityId).map(repairCapability-> {
			tps.setRepairCapability(repairCapability);
			return tpsRepository.save(tps);	
        });
	}
	
	@PutMapping("/tps/{id}")
	public Optional<Object> updateTPS(@PathVariable (value="id")Integer id,
		      								  @Valid @RequestBody TPS tpsReq) {
		if(!tpsRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
        return tpsRepository.findById(id).map(tps -> {
        	tps.setChecksum(tpsReq.getChecksum());
        	tps.setChecksumType(tpsReq.getChecksumType());
        	tps.setComments(tpsReq.getComments());
        	tps.setReleaseDate(tpsReq.getReleaseDate());
        	tps.setReleaseNotes(tpsReq.getReleaseNotes());
        	tps.setTpsPart(tpsReq.getTpsPart());
        	tps.setVersion(tpsReq.getVersion());
        	return tpsRepository.save(tps);	       
        });
    }
	
	@DeleteMapping("/tps/{id}")
	public Optional<Object> deleteTPS(@PathVariable (value="id")Integer id) {
		if(!tpsRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
		return tpsRepository.findById(id).map(tps -> {
			tpsRepository.delete(tps);
            return ResponseEntity.ok().build();
        });
    }
	

}
