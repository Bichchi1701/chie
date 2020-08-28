package tp.kits3.tcn;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tp.kits3.tcn.service.sourceService;
import tp.kits3.tcn.service.categoryservice;
import tp.kits3.tcn.vo.category;
import tp.kits3.tcn.vo.source;

@Controller

public class sourceCotroller {
	private sourceService sourceservice;
	private categoryservice categoryservice;
	
	@RequestMapping(value ="/insertsource", method=RequestMethod.POST)
	public String insertSource(@RequestParam(value = "action", required = false) String action,
			
			@RequestParam(value="sourcename", required = true) String sourcename, 
			@RequestParam(value = "size", required = false) MultipartFile file, 
			@RequestParam(value="contentdetails", required = true) String contentdetails,
			@RequestParam(value="title", required = true) String title,	
			@RequestParam(value="ctgname", required = true) String ctgname,
			@RequestParam(value="price", required = true) Double price,
			@RequestParam(value="avatar", required = true) String avatar,HttpServletRequest request)
			{
			
				if(action.equals("add")) {
					Timestamp date= (Timestamp)java.util.Calendar.getInstance().getTime();  
					System.out.print(date);
					category category = new category(ctgname);
					categoryservice.insertCategory(category);
					if (file != null) {
						byte[] fileContent = null;
						try {
							InputStream inputStream = file.getInputStream();				
							if (inputStream == null)
								System.out.println("File inputstream is null");
											                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
							//load img built path
							String path = request.getSession().getServletContext().getRealPath("/") + "resources/upload/";
							FileUtils.forceMkdir(new File(path));
							File upload = new File (path + file.getOriginalFilename());
							file.transferTo(upload);
							String size = request.getContextPath() + "/resources/upload/" + file.getOriginalFilename();
							//source.setSize(size);
							//request.getSession().setAttribute("source",/ source);
							//IOUtils.closeQuietly(inputStream);
						} catch (IOException ex) {
							System.out.println("Error saving uploaded file");
						}
					}
					
					//source source = new source(date,sourcename,size,contentdetails,title,1,category.getCtgid(),0,avatar,0);
					//sourceservice.insert(source);
					//sourceservice.insert(source);
					return "redirect:/insertsource/list";
				}
				return "";
				
	}
	@RequestMapping(value = "/insertsource/list", method = RequestMethod.GET)
	public String showList(Model model) {
		List<source> listSource = sourceservice.getAll();
		model.addAttribute("listsource",listSource);
		return "success";
	}
	
}

	
	

	


