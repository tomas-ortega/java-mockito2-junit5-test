package tutorial.tdd.tutorialTddMocking.dao;

import tutorial.tdd.tutorialTddMocking.domain.BookDTO;

public class BookDAOTestHelper {
	private BookDTO bookWithId1;
	
	public BookDAOTestHelper() {
		this.bookWithId1 = null;
		this.initData();
	}
	
	private void initData() {
		this.initBookWithId1();
	}
	
	private void initBookWithId1() {
		this.bookWithId1 = new BookDTO();
		this.bookWithId1.setId(1);
		this.bookWithId1.setTitle("Los pilares de la tierra");
		this.bookWithId1.setAuthor("Ken Follet");
		this.bookWithId1.setPages(498);
	}
	
	public BookDTO getBookWithId1() {
		return this.bookWithId1;
	}
}
