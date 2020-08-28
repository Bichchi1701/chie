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
import tp.kits3.tcn.vo.source;

@Repository // means this class DAO
public class sourceDao{
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

	public List<source> findAll() {
		// connection DB -> make sql -> send .executeQuery() -> get data
		// your choice get return factory
		SqlSession session = getInstance().openSession(); // connection DB
		return session.selectList("mappers.sourceMapper.selectAll");

	}

	public category findOne(int sourceid) {
		SqlSession session = getInstance().openSession(); // connection DB
		return session.selectOne("mappers.sourceMapper.selectOne", sourceid);
		

	}

	public void add(source source) {

		SqlSession session = getInstance().openSession(true);
		session.insert("mappers.sourceMapper.insert", source);
		session.close();
	}

	public void update(source source) {

		SqlSession session = getInstance().openSession();
		session.update("mappers.sourceMapper.update", source);
		session.commit();
		

	}

	public void delete(int sourceid) {

		SqlSession session = getInstance().openSession();
		session.delete("mappers.sourceMapper.delete", sourceid);
		session.commit();

	}

}
