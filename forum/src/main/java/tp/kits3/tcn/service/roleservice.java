package tp.kits3.tcn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.kits3.tcn.dao.roledao;
import tp.kits3.tcn.vo.role;

@Service
public class roleservice {

	@Autowired
	private roledao roledao;

	
	private static final Logger logger = LoggerFactory.getLogger(userservice.class);

	public roleservice() {
		logger.info("{}", "init");
	}

	// have to
//	public void getModelData() {
//		logger.info("{}", " get data");
//	}

	// Book data
	public List<role> getRoleData () {		
		List<role> listRole= roledao.findAll();
		return listRole;
	}
	public void insertRole(role role) {
		roledao.add(role);
			
	}
	public void updateRole(role role) {
		roledao.update(role);
			
	}
	
	public role findOne(int roleid) {
	  return roledao.findOne(roleid);
	}
	public void deleteRole(int roleid)
	{
		roledao.delete(roleid);
	}
}
