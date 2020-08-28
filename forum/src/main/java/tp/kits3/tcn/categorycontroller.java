package tp.kits3.tcn;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp.kits3.tcn.service.categoryservice;
import tp.kits3.tcn.vo.category;
@Controller
public class categorycontroller {
	// Injection: create other object in this class
	@Autowired
	private categoryservice categoryservice; // ko cần new dể dùng nữ
	private static final Logger logger = LoggerFactory.getLogger(categorycontroller.class);

	

	@RequestMapping(value = "category", method = RequestMethod.GET)
	public String indexPage(Model model) {
		// xuất lỗi
		// show category
		List<category> listCategory = categoryservice.getCategoryData();
		
		//List<category> listCate = categoryservice.getBycategory(parentid);
		model.addAttribute("listCategory", listCategory);
	
		return "category"; // .jsp
	}
}