package tp.kits3.tcn.dao;
/*
use Mybatis lib
SqlSessionFactory <- db connection info (mybatis-config.xml)
SqlSession open -> send sql statement DB (mapper.xml)
*/

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import tp.kits3.tcn.vo.user;

@Repository // means this class DAO
public class userdao{
	private static SqlSessionFactory factory = null;

	// need static method to factory field
	public static SqlSessionFactory getInstance() {
		if (factory == null) {
			// create
			try {
				// Reader text read from file xml
				Reader resource = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
				factory = new SqlSessionFactoryBuilder().build(resource);

				resource.close(); // close file()

			} catch (Exception e) {
				// if failed
				e.printStackTrace();
			}
		}

		return factory;
	} // end getInstance

	public List<user> findAll() {
		// connection DB -> make sql -> send .executeQuery() -> get data
		// your choice get return factory
		SqlSession session = getInstance().openSession(); // connection DB
		return session.selectList("mappers.userMapper.selectAll");

	}

	public user findOne(int id) {
		SqlSession session = getInstance().openSession(); // connection DB
		return session.selectOne("mappers.userMapper.selectOne", id);
		

	}

	public void add(user param) {

		SqlSession session = getInstance().openSession(true);
		session.insert("mappers.userMapper.insert", param);
		session.close();
	}

	public void update(user param) {

		SqlSession session = getInstance().openSession();
		session.update("mappers.userMapper.update", param);
		session.commit();
		

	}

	public void delete(int id) {

		SqlSession session = getInstance().openSession();
		session.delete("mappers.userMapper.delete", id);
		session.commit();

	}

}
