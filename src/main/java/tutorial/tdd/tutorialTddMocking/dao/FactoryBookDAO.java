package tutorial.tdd.tutorialTddMocking.dao;

public class FactoryBookDAO {
	private FactoryBookDAO(){
		//Private to prevent create object from FactoryBookDAO
	}
	
	public static IBookDAO getBookDAO(){
		return new BookDAO();
	}
}
