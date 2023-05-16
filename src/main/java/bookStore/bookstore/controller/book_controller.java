package bookStore.bookstore.controller;

import java.util.List;

// import org.hibernate.annotations.common.util.impl.Log_.logger;

// import java.util.Base64;

// import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestPart;
// import org.springframework.web.multipart.MultipartFile;

import bookStore.bookstore.model.Book;
import bookStore.bookstore.repository.Book_repository;
// import bookStore.bookstore.service.bookservice;

@Controller

public class book_controller {
    @Autowired
    public Book_repository repo;

    @GetMapping("/")
    public String Home() {
        return "Home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/bookform")
    public String storebook() {
        return "saveForm";
    }

    @PostMapping(value = "/save")
    public String savetem(Model model, @RequestParam int id, @RequestParam String name, @RequestParam String author,
            @RequestParam String title, @RequestParam String place, @RequestParam String pub,
            @RequestParam String des) {

        Book book = new Book();

        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(des);
        book.setTitle(title);
        book.setPlace(place);
        book.setPublisher(pub);
        repo.save(book);

        return "redirect:/home";
    }

    @GetMapping(value = "/home")
    public String getPage(Model model) {

        model.addAttribute("theBooks", repo.findAll());
        return "Booklist";
    }

    @GetMapping(value = "/getform")
    public String Updatebook(@RequestParam("bookId") int theId, Model themodel) {
        Book theBook = repo.findById(theId);
        themodel.addAttribute("book", theBook);
        return "bookreg";
    }

    @GetMapping("/UpdateBook")
    public String Updatebooks(@RequestParam("bookId") int theId, Model themodel) {
        List<Book> theBook = repo.findAll();
        themodel.addAttribute("book", theBook);
        return "bookreg";
    }

    @GetMapping("/deletebook")
    public String deletebook(@RequestParam("bookId") int theId) {

        repo.deleteById(theId);

        return "redirect:/home";
    }


   


}


   
