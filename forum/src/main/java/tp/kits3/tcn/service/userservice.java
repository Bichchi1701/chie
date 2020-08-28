package tp.kits3.tcn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.kits3.tcn.dao.userdao;
import tp.kits3.tcn.vo.user;

@Service
public class userservice {

	@Autowired
	private userdao userdao;

	
	private static final Logger logger = LoggerFactory.getLogger(userservice.class);

	public userservice() {
		logger.info("{}", "init");
	}

	// have to
//	public void getModelData() {
//		logger.info("{}", " get data");
//	}

	// Book data
	public List<user> getUserData () {		
		List<user> listUser= userdao.findAll();
		return listUser;
	}
	public void insertUser(user user) {
		userdao.add(user);
			
	}
	public void updateUser(user user) {
		userdao.update(user);
			
	}
	
	public user findOne(int userid) {
	  return userdao.findOne(userid);
	}
	public void deleteUser(int userid)
	{
		userdao.delete(userid);
	}
}
