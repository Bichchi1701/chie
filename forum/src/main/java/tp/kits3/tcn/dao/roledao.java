package tp.kits3.tcn.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import tp.kits3.tcn.vo.role;



@Repository // means this class DAO
public class roledao{
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

	public List<role> findAll() {
		// connection DB -> make sql -> send .executeQuery() -> get data
		// your choice get return factory
		SqlSession session = getInstance().openSession(); // connection DB
		return session.selectList("mappers.roleMapper.selectAll");

	}

	public role findOne(int id) {
		SqlSession session = getInstance().openSession(); // connection DB
		return session.selectOne("mappers.roleMapper.selectOne", id);
		

	}

	public void add(role param) {

		SqlSession session = getInstance().openSession(true);
		session.insert("mappers.roleMapper.insert", param);
		session.close();
	}

	public void update(role param) {

		SqlSession session = getInstance().openSession();
		session.update("mappers.roleMapper.update", param);
		session.commit();
		

	}

	public void delete(int id) {

		SqlSession session = getInstance().openSession();
		session.delete("mappers.roleMapper.delete", id);
		session.commit();

	}

}
