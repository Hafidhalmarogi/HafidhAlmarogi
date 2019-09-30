package HafidhAlmarogiProjectSpringBoot.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HafidhAlmarogiProjectSpringBoot.Dao.TabunganDao;
import HafidhAlmarogiProjectSpringBoot.Model.TabunganModel;

@RestController
@RequestMapping("/bank")
public class TabunganController {
	@Autowired
	TabunganDao tabDao;
	
	@PostMapping("/SaveTabungan")
	public TabunganModel SaveTabungan(@Valid @RequestBody TabunganModel tab) {
		return tabDao.save(tab);
		
	}
	
	@GetMapping("/getAlltabungan")
	public List<TabunganModel> getAllTabungan(){
		return tabDao.findAll();
	}
	
	@GetMapping("/getTabunganById/{id}")
	public ResponseEntity<TabunganModel> getTabunganById(@PathVariable(value="id") Long id) {
		TabunganModel b=tabDao.getFindOne(id);
		if(b==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(b);
		}
	}
	
	@GetMapping("getTabunganByNik/{nik}")
	public List<TabunganModel> getTabunganByNik(@PathVariable(value="nik") String nik){
		return tabDao.findByNik(nik);	
	}
	@GetMapping("/saldo/{nik}")
	public ResponseEntity<TabunganModel> getTabungan(@PathVariable(value="nik") String nik) {
		TabunganModel b=tabDao.getFindSaldo(nik);
		if(b==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(b);
		}
	}
	
	@DeleteMapping("DeleteTabungan/{id}")
	public ResponseEntity<TabunganModel> deleteBuku(@PathVariable(value="id")Long id){
		TabunganModel b=tabDao.getFindOne(id);
		if(b==null) {
			return ResponseEntity.notFound().build();
		}else {
			tabDao.deleteTabungan(id);;
			return  ResponseEntity.ok().build();
		}
	}
	
	@PutMapping("UpdateTabungan/{id}")
	public ResponseEntity<TabunganModel> updateSaldo (@PathVariable(value="id") Long id,@Valid @RequestBody TabunganModel tabungan){
		TabunganModel b=tabDao.getFindOne(id);
		if(b==null) {
			return ResponseEntity.notFound().build();
		}else {
			b.setSaldo(b.getSaldo()-b.getKredit()+b.getDebet());
			b.setKredit(tabungan.getKredit());
			b.setDebet(tabungan.getDebet());
		
			
			TabunganModel bResult=tabDao.Update(b);
			return ResponseEntity.ok().body(bResult);
		}

	}
}
