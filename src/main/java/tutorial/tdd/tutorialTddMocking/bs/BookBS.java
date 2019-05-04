package tutorial.tdd.tutorialTddMocking.bs;

import java.sql.Connection;

import tutorial.tdd.tutorialTddMocking.dao.BookDAO;
import tutorial.tdd.tutorialTddMocking.dao.FactoryBookDAO;
import tutorial.tdd.tutorialTddMocking.dao.IBookDAO;
import tutorial.tdd.tutorialTddMocking.domain.BookDTO;



public class BookBS implements IBookBS {

	private IBookDAO libroDao = FactoryBookDAO.getBookDAO();
	
	public void setDAO(BookDAO bookDAO) {
		this.libroDao = bookDAO;
	}
	
	public void newBook(BookDTO book) throws Exception {
        try {
            Connection connectionReference = DbConnection.getDbConnection();
            libroDao.newBook(book, connectionReference);
        } catch(Exception ex) {
            System.out.println(ex);
            throw ex;
        }
	}

	public void deleteBook(Integer bookId) throws Exception {
        try {
            Connection connectionReference = DbConnection.getDbConnection();
            libroDao.deleteBook(bookId, connectionReference);
        } catch(Exception ex) {
            System.out.println(ex);
            throw ex;
        }
	}

	public void editBookEditorial(Integer bookId, String editorial) throws Exception {
            try {
                Connection connectionReference = DbConnection.getDbConnection();
                libroDao.modifyEditorialBook(bookId, editorial, connectionReference);
            } catch(Exception ex) {
                System.out.println(ex);
                throw ex;
            }
	}

	public BookDTO searchBookById(Integer idLibro, Connection testConnection) throws Exception {
            Connection connectionReference = null;
                     
            try {
            	if (testConnection == null) {
            		connectionReference = DbConnection.getDbConnection();
            	}
                return libroDao.searchBookById(idLibro, connectionReference);
            } catch(Exception ex) {
                System.out.println(ex);
                throw ex;
            } finally {
                DbConnection.closeConnection(connectionReference);
            }
	}
	
	public String testVerifyInvocationError() {
		return "Some String";
	}
}