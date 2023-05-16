package bookStore.bookstore.controller;

import java.util.List;

//  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bookStore.bookstore.model.Admin;
import bookStore.bookstore.repository.Adminrepository;

@Controller
@RequestMapping("/admins")
public class Admincontroller {
    
    private Adminrepository adminRepository;

  
    public Admincontroller(Adminrepository adminRepository) {
        this.adminRepository = adminRepository;
    }

   

    @GetMapping("/SignUp")
    public String signUp(Model theModel) {
        // create Model attribute to bind form data
        Admin admin = new Admin();
        theModel.addAttribute("admin", admin);
        return "AdminSignUp.html";
    }

    @GetMapping("/login")
    public String login(Model theModel) {
    
        Admin admin = new Admin();
        theModel.addAttribute("admin", admin);
        return "login.html";
    }

    @PostMapping("/save")
    public String saveAdmin(@ModelAttribute("admin") Admin theAdmin) {
        // save the Admin
        adminRepository.save(theAdmin);
        return "redirect:/admins/login";
    }

    @PostMapping("/authenticate")
    // @ResponseBody
    public String AuthenticateAdmin(@ModelAttribute("admin") Admin theAdmin) {
        // Find the Admin
        List<Admin> authAdmin = adminRepository.findByEmail(theAdmin.getEmail());
        if (!authAdmin.isEmpty()) {
            return "redirect:/bookform";
        }
        return "redirect:/admins/SignUp";
    }

}
