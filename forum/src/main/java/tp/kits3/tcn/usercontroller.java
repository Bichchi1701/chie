//package tp.kits3.tcn;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.List;
//import java.util.Locale;
//
//import javax.jws.WebParam.Mode;
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//
//
//import tp.kits3.tcn.service.userservice;
///**
// * Handles requests for the application home page.
// */
//@Controller
//public class usercontroller {
//	// Injection: create other object in this class
//	@Autowired
//	private userservice userservice; // ko cần new dể dùng nữa
//
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//
//
//	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
//	public String booking(HttpServletRequest request, @RequestParam(value = "action", required = false) String action,
//			@RequestParam(value = "name", required = true) String bkname,
//			@RequestParam(value = "email", required = true) String bkemail,
//			@RequestParam(value = "phone", required = true) String bkphone,
//			@RequestParam(value = "date", required = true) String bktime,
//			@RequestParam(value = "option", required = true) Integer bknum,
//			@RequestParam(value = "booking", required = true) String booking,
//			@RequestParam(value = "memo", required = true) String bkmemo, Model model) {
//		System.out.println("ADDDDDDDDDD");
//		if (action.equals("add")) {
//			Timestamp bkktime = Timestamp.valueOf(bktime);
//
//			Book newBook = new Book(bkname, bkemail, bkphone, bkktime, bknum, booking, bkmemo);
//			bookService.insertBook(newBook);
//			return "redirect:/reservation/list";
//		} else if (action.equals("back")) {
//			return "redirect:/";
//		}
//		return "";
//	}
//	
//	@RequestMapping(value = "/reservation/list", method = RequestMethod.GET)
//	public String showList(Model model) {
//		List<Book> listBook = bookService.getBookData();
//		model.addAttribute("book",listBook);
//		return "success";
//		
//	}
//
//
//	
//
//}
