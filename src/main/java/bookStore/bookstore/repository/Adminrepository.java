package bookStore.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookStore.bookstore.model.Admin;

public interface Adminrepository extends JpaRepository<Admin, Integer> {
   List<Admin> findByEmail(String email); 
}
