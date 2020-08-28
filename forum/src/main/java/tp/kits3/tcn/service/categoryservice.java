package tp.kits3.tcn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.kits3.tcn.dao.categorydao;
import tp.kits3.tcn.vo.category;
import tp.kits3.tcn.vo.user;

@Service
public class categoryservice {

	@Autowired
	private categorydao categorydao;

	
	private static final Logger logger = LoggerFactory.getLogger(userservice.class);

	public categoryservice() {
		logger.info("{}", "init");
	}

	// have to
//	public void getModelData() {
//		logger.info("{}", " get data");
//	}

	// Book data
	public List<category> getCategoryData() {		
		List<category> listcategory= categorydao.findAll();
		return listcategory;
	}
	public List<category> getBycategory () {		
		List<category> listcategory= categorydao.findbyCategogy();
		return listcategory;
	}
	
		public void insertCategory(category category) {
		categorydao.add(category);
			
	}
//	public void updateUser(user user) {
//		userdao.update(user);
//			
//	}
//	
//	public user findOne(int userid) {
//	  return userdao.findOne(userid);
//	}
//	public void deleteUser(int userid)
//	{
//		userdao.delete(userid);
//	}
}
