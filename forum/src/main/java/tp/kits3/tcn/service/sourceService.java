package tp.kits3.tcn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import tp.kits3.tcn.dao.sourceDao;
import tp.kits3.tcn.vo.category;
import tp.kits3.tcn.vo.source;

public class sourceService {
	@Autowired
	private sourceDao sourceDao;
	private static final Logger logger = LoggerFactory.getLogger(userservice.class);
	public List<source> getAll(){
		List<source> listSource = sourceDao.findAll();
		return listSource;
	}
	public void insert(source source) {
		sourceDao.add(source);
	}
	public void update(source source) {
		sourceDao.update(source);
	}
	
}
