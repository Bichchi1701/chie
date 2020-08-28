package tp.kits3.tcn.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tp.kits3.tcn.vo.stateproduct;

public class stateDao {
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
	} // en
	public void add(stateproduct stateproduct) {

		SqlSession session = getInstance().openSession(true);
		session.insert("mappers.stateproductMapper.insert", stateproduct);
		session.close();
	}


}
