package com.project.registration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.print.attribute.standard.DateTimeAtCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.registration.dao.AddressDao;
import com.project.registration.dao.ProfileDao;
import com.project.registration.dao.UserDao;
import com.project.registration.entity.Address;
import com.project.registration.entity.Profile;
import com.project.registration.entity.User;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {
	
	@Autowired
	private ProfileDao pDao;
	@Autowired
	private UserDao uDao;
	@Autowired
	private AddressDao aDao;
	
	private String pwd;
	private String cpwd;
	
	private static final String UPLOAD_DIRECTORY = "C:\\Users\\SPACE\\Documents\\workspace-sts-3.9.1.RELEASE\\registration\\src\\main\\webapp\\resources\\photo\\";
	
	@GetMapping
	public String getRegistration(){
		System.out.println("Fuck this photo...");
		return "register";
	}
	
	@PostMapping
	public String postRegistration(@RequestParam("myphoto") CommonsMultipartFile file, @RequestParam("cpassword") String cpassword, @ModelAttribute User u, @ModelAttribute Address a, @ModelAttribute Profile p, Model model) throws IOException{
		System.out.println("Fuck this photo...");
		
		this.cpwd = cpassword;
		pwd = u.getPassword();
		
		if(pwd.equals(cpwd)){
			String encPass = UUID.nameUUIDFromBytes(u.getPassword().getBytes()).toString();
			u.setPassword(encPass);
			u.setCreatedAt(new Date());
			u.setStatus(true);
			if(!uDao.isExit(u.getUsername())){
//				insert here to auto login after registraion i.e. uDao.login(u.getUsername, u.getPassword);
				uDao.addUser(u);
			}else{
				model.addAttribute("error", "Username Already Exist...!");
				model.addAttribute("u", u);
				model.addAttribute("a", a);
				model.addAttribute("p", p);
				return "register";
			}
			
			
			a.setCreatedAt(new Date());
			a.setStatus(true);
			aDao.addAddress(a);
			
			String filename = file.getOriginalFilename();
			
			System.out.println("Photo Name: "+filename);
			
		    byte[] bytes = file.getBytes();  
		    FileOutputStream stream = new FileOutputStream(UPLOAD_DIRECTORY+filename); 
		    stream.write(bytes);  
		    stream.flush();  
		    stream.close(); 

		    p.setPhoto(filename);
		    p.setUser(u);
		    p.setAddress(a);
		    p.setCreatedAt(new Date());
		    p.setStatus(true);
		    pDao.addProfile(p);
		    
			return "redirect:/login";
		}else{
			model.addAttribute("error", "Password Do Not Match !!!");
			model.addAttribute("u", u);
			model.addAttribute("a", a);
			model.addAttribute("p", p);
			return "register";
		}
		
	}

}
