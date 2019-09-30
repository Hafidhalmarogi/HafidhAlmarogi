package HafidhAlmarogiProjectSpringBoot.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HafidhAlmarogiProjectSpringBoot.Model.TabunganModel;
import HafidhAlmarogiProjectSpringBoot.Repository.TabunganRepository;

@Service
public class TabunganDao {
	@Autowired
	TabunganRepository tabunganRes;
	
	public TabunganModel save(TabunganModel tabu) {
		TabunganModel tabTamp= tabu;
		TabunganModel TampSaldo=tabunganRes.findSaldo(tabu.getNik());
		if(TampSaldo==null) {
			tabTamp.setSaldo(0+tabTamp.getKredit()-tabTamp.getDebet());
			return tabunganRes.save(tabTamp);
		}else {
			tabTamp.setSaldo(TampSaldo.getSaldo()+tabTamp.getKredit()-tabTamp.getDebet());
			return tabunganRes.save(tabTamp);
		}
	}
	
	public List<TabunganModel> findAll(){
		return tabunganRes.findAll();
		
	}
	
	public TabunganModel getFindOne(Long id) {
		return tabunganRes.findOne(id);
		
	}
	
	public List<TabunganModel> findByNik(String nik){
		return tabunganRes.findTabunganByNik(nik);
	}
	
	public TabunganModel getFindSaldo(String nik) {
		return tabunganRes.findSaldo(nik);
	}
	
	//delete
		public void deleteTabungan(Long id) {
			TabunganModel tampNik=tabunganRes.findOne(id);
			List<TabunganModel> dataList=tabunganRes.findTabunganByNik(tampNik.getNik());
			for (TabunganModel data : dataList) {
				if(data.getId() > id) {
					TabunganModel tamp1=tabunganRes.findOne(data.getId());
					tamp1.setSaldo(tamp1.getSaldo()-tampNik.getKredit()+tampNik.getDebet());
					tabunganRes.save(tamp1);					
				}
			}
			tabunganRes.delete(id);
		}
	//Upddate
		public TabunganModel Update(TabunganModel tabu) {
			TabunganModel tabTamp= tabu;
			TabunganModel tampSaldo=tabunganRes.findOne(tabTamp.getId());
			tampSaldo.setSaldo(tampSaldo.getSaldo()+tabTamp.getKredit()-tabTamp.getDebet());
			tampSaldo.setDebet(tabTamp.getDebet());
			tampSaldo.setKredit(tabTamp.getKredit());
			int tamp=tampSaldo.getSaldo();
			List<TabunganModel> dataList=tabunganRes.findTabunganByNik(tabTamp.getNik());
			for (TabunganModel data : dataList) {
				if(data.getId() > tabTamp.getId()) {
					TabunganModel tamp1=tabunganRes.findOne(data.getId());
					tamp1.setSaldo(tamp+tamp1.getKredit()-tamp1.getDebet());
					tabunganRes.save(tamp1);
					tamp=tamp1.getSaldo();
				}
			}
			return tabunganRes.save(tampSaldo);
		}
}
