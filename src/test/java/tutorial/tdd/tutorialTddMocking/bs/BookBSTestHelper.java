package tutorial.tdd.tutorialTddMocking.bs;

import tutorial.tdd.tutorialTddMocking.domain.BookDTO;

public class BookBSTestHelper {
	private BookDTO bookWithId1;
	private BookDTO bookNotFound;
	
	public BookBSTestHelper() {
		this.bookWithId1 = null;
		this.bookNotFound = null;
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
	
	public BookDTO getBookNotFound() {
		return this.bookNotFound;
	}
}
