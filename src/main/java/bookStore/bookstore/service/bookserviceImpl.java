package bookStore.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookStore.bookstore.model.Book;
import bookStore.bookstore.repository.Book_repository;


@Service
public class bookserviceImpl implements bookservice {
    public Book_repository bookRepository;
    
    @Autowired
    public bookserviceImpl(Book_repository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }

   
   
    
}
