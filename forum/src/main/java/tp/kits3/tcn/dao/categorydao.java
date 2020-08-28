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
import tp.kits3.tcn.vo.category;

@Repository // means this class DAO
public class categorydao{
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

	public List<category> findAll() {
		// connection DB -> make sql -> send .executeQuery() -> get data
		// your choice get return factory
		SqlSession session = getInstance().openSession(); // connection DB
		return session.selectList("mappers.categoryMapper.selectAll");

	}

	
	public  List<category> findbyCategogy() {
		SqlSession session = getInstance().openSession(); // connection DB

		return session.selectList("mappers.categoryMapper.selectbyCategory");

	}


	public category findOne(int id) {
		SqlSession session = getInstance().openSession(); // connection DB
		return session.selectOne("mappers.categoryMapper.selectOne", id);
		

	}

	public void add(category param) {

		SqlSession session = getInstance().openSession(true);
		session.insert("mappers.categoryMapper.insert", param);
		session.close();
	}

	public void update(category param) {

		SqlSession session = getInstance().openSession();
		session.update("mappers.categoryMapper.update", param);
		session.commit();
		

	}

	public void delete(int id) {

		SqlSession session = getInstance().openSession();
		session.delete("mappers.categoryMapper.delete", id);
		session.commit();

	}

}
