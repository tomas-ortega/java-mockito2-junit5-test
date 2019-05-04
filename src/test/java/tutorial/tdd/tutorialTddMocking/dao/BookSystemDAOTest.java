package tutorial.tdd.tutorialTddMocking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tutorial.tdd.tutorialTddMocking.domain.BookDTO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class BookSystemDAOTest {
	
	@Mock
	private Connection connection;
	
	@Mock
	private ResultSet resultSet;
	
	@Mock
	private PreparedStatement preparedStatement;
	
	@InjectMocks
	private BookDAO bookDAO;
	
	private static BookDAOTestHelper DAOHelper;
	
	@BeforeAll
	public static void setUpClass() {
		DAOHelper = new BookDAOTestHelper();
	}
	
	@BeforeEach
	public void setUpMocks() throws Exception {
		this.initializeMockSearchBookWithId1();
	}

	@Test
	public void searchBookWithId1() throws SQLException {
		BookDTO bookInstance = null;
		Integer bookIdExpected = 1;
		
		bookInstance = this.bookDAO.searchBookById(1, this.connection);
		
		assertTrue(bookInstance.getId().equals(bookIdExpected));
	}
	
	private void initializeMockSearchBookWithId1() throws Exception {
		 StringBuilder selectSql = new StringBuilder();
		 
         selectSql.append("SELECT id, title, author, editorial, pages FROM book WHERE id = ?");
         
         /**Mocking preparedStatement*/
         when(this.connection.prepareStatement(selectSql.toString()))
         	.thenReturn(this.preparedStatement);
         
         /** Mocking the executionQuery
          */
         when(this.preparedStatement.executeQuery())
                 .thenReturn(this.resultSet);
         
         /** Mocking the resultSet Iterator
          */
         when(this.resultSet.next())
                 .thenReturn(true)
                     .thenReturn(false);
         
         /** Mocking the resultSet parameters
          */
         when(this.resultSet.getInt("id"))
                 .thenReturn(DAOHelper.getBookWithId1().getId());
         
         when(this.resultSet.getString("title"))
                 .thenReturn(DAOHelper.getBookWithId1().getTitle());
         
         when(this.resultSet.getString("author"))
                 .thenReturn(DAOHelper.getBookWithId1().getAuthor());
         
         when(this.resultSet.getString("editorial"))
         		.thenReturn(DAOHelper.getBookWithId1().getEditorial());
         
         when(this.resultSet.getInt("pages"))
         		.thenReturn(DAOHelper.getBookWithId1().getPages());
	}
}
