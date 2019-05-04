package tutorial.tdd.tutorialTddMocking.bs;

import java.sql.Connection;

import tutorial.tdd.tutorialTddMocking.domain.BookDTO;

public interface IBookBS {
	public void newBook(BookDTO book) throws Exception;
	public void deleteBook(Integer bookId) throws Exception;
	public void editBookEditorial(Integer bookId, String editorial) throws Exception;
	public BookDTO searchBookById(Integer bookId, Connection testConnection) throws Exception;
}

