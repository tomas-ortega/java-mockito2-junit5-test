package tutorial.tdd.tutorialTddMocking.bs;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import tutorial.tdd.tutorialTddMocking.dao.BookDAO;
import tutorial.tdd.tutorialTddMocking.domain.BookDTO;

import static org.mockito.Mockito.inOrder;



@ExtendWith(MockitoExtension.class)
public class BookSystemBSTest {
	
	@Mock
	private Connection connection;
	
	@Mock
	private ResultSet resultSet;
	
	@Mock
	private PreparedStatement preparedStatement;
	
	@Spy
	@InjectMocks
	private BookBS bookBS;
	
	@Mock
	private BookDAO bookDAO;
	
	private static BookBSTestHelper BSHelper;
	
	private InOrder callOrder;
	
	@BeforeAll
	public static void setUpClass() {
		BSHelper = new BookBSTestHelper();
	}
	
	@BeforeEach
	public void setUpMocks() throws Exception {
		this.bookBS.setDAO(this.bookDAO);
		this.initializeMockSearchBookWithId1();
		
		this.callOrder = inOrder(this.bookBS);
	}
	
	

	@Test
	public void searchBookWithId1() throws Exception {
		BookDTO bookInstance = null;
		Integer bookIdExpected = 1;
		
		this.bookBS.testVerifyInvocationError();
		
		bookInstance = this.bookBS.searchBookById(1, this.connection);
		
		assertTrue(bookInstance.getId().equals(bookIdExpected));
		
		this.callOrder.verify(this.bookBS).testVerifyInvocationError();
		this.callOrder.verify(this.bookBS).searchBookById(1, this.connection);
	}
	
	
	private void initializeMockSearchBookWithId1() throws Exception {
		 when(this.bookDAO.searchBookById(BSHelper.getBookWithId1().getId(), null))
				.thenReturn(BSHelper.getBookWithId1());
	}
}
