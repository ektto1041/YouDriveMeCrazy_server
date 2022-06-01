package com.freaky_guys.youdrivemecrazy_server.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freaky_guys.youdrivemecrazy_server.domain.gameuser;
import com.freaky_guys.youdrivemecrazy_server.repository.GameUserRepository;

@RestController
public class GameUserController {
	
	@Autowired
	private GameUserRepository GUrepos;

//	/** Login **/
//    @RequestMapping(value="ymmc/auth/login", method= {RequestMethod.GET, RequestMethod.POST})
//    public String memberLogin(gameuser guser, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
//        
//        HttpSession session = req.getSession();
//        gameuser member = boardService.memberLogin(memberVO);
//        
//        if(member == null) {
//            session.setAttribute("member", null);
//            rttr.addFlashAttribute("msg", false);
//        } else {
//            session.setAttribute("member", member);
//        }
//        
//        return "redirect:/";
//    }
    @GetMapping(value = "ymmc/auth/all",produces = "application/json") 
	public List<gameuser> findall() { 
		return GUrepos.findAll();
	}
//	@GetMapping(value = "ymmc/auth/duplicatecheck/{email}",produces = "application/json" ) 
//	public boolean findbyid(@PathVariable String email) { 
//		return GUrepos.findByEmail(email);
//	}
	 @GetMapping(value = "ymmc/auth/login/{email}/{password}",produces = "application/json" ) 
		public boolean login(@PathVariable  String email, @PathVariable  String password ) { 
			//gameuser member = GUrepos.selectGameuser(email, password);
			gameuser member23 = GUrepos.findByEmail(email);
			if(member23 == null) {
				return false;
			}
			String fetchedPWD = member23.getPassword();
			
			if(fetchedPWD.equals(password)) {
				return true;
				//return "true";
			} else {
				return false;
			}
			
		
			//return false;
			
//	        
//	        if(member == null) {
//	            session.setAttribute("member", null);
//	            rttr.addFlashAttribute("msg", false);
//	        } else {
//	            session.setAttribute("member", member);
//	        }
//	        
//	        return "redirect:/";
			
		}
//	@RequestMapping("/login")
//    public String login(HttpServletRequest request, Map<String, Object> map,HttpSession session) {
//    
//
//        session.setAttribute("id",request.getParameter("id"));
//        String id = session.getAttribute("id").toString();
//        String password = request.getParameter("password");
//
//
//        
//          // If you log in as an ordinary user, look up the ordinary user table 
//           gameuser loggedUser = employeesService.login(id, password);
//            if(loggedUser != null){
//    
//                if (employeesService.findJobById(id).getJob().equals(" Patrol inspectors ")){
//    
//                    System.out.println(" Landing successful ");
//                    return "redirect:/xInfo";
//                }else {
//    
//                    System.out.println(" Landing successful ");
//                    return "redirect:/wInfo";
//                }
//            }else {
//    
//                map.put("msg"," Wrong account or password ");
//                session.removeAttribute("id");
//                return "login";
//            }
//        }
//    
//	@RequestMapping("/getUserInfo")
//    @ResponseBody
//    public String getUserInfo(HttpSession session){
//    
//        System.out.println(" received unity Login request ");
//        // Because after the login failed session In domain id Will be deleted , So the judgment is null Login failed 
//        if(session.getAttribute("id") != null){
//    
//            String id = session.getAttribute("id").toString();
//            System.out.println(" Landing successful ");
//            return id ;
//        }
//        else {
//    
//            System.out.println(" Login failed ");
//            return null;
//        }
//    }
	@PostMapping(value = "ymmc/auth/add", consumes = "application/json") 
	public void addUser(@RequestBody gameuser user) {
		gameuser member2 = GUrepos.findByEmail(user.getEmail());
		if(member2 == null) {
			 GUrepos.save(user);
		}
		 
		}
//	@GetMapping(value = "ymmc/auth/duplicatecheck/{email}",produces = "application/json" ) 
//	public boolean findbyid(@PathVariable String email) { 
//		return GUrepos.findByEmail(email);
//	}
}
