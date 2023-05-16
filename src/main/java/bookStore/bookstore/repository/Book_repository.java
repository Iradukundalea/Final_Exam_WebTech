package bookStore.bookstore.repository;



import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import bookStore.bookstore.model.Book;


// @Repository
public interface Book_repository extends JpaRepository<Book, Integer> {
    Book findById(int id);


}
