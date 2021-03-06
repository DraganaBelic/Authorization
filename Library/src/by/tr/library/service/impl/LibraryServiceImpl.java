package by.tr.library.service.impl;

import java.util.List;

import by.tr.library.bean.Book;
import by.tr.library.dao.AdminDao;
import by.tr.library.dao.DAOFactory;
import by.tr.library.dao.UserDao;
import by.tr.library.dao.exception.DAOException;
import by.tr.library.service.LibraryService;
import by.tr.library.service.exception.ServiceException;

public class LibraryServiceImpl implements LibraryService{

	@Override
	public Book findByAuthor(String author) {
		// stub
		return null;
	}

	@Override
	public Book findByTitle(String title) {
		// stub
		return null;
	}

	@Override
	public boolean addBook(String titile, String author) throws ServiceException {
		// validation
		
		Book book = new Book();
		
		DAOFactory factory = DAOFactory.getInstance();
		AdminDao adminDAo = factory.getAdminDao();
		
		try {
			adminDAo.addNewBook(book);
		} catch (DAOException e) {
			throw new ServiceException("service message", e);
		}
		
		return false;
	}

	@Override
	public List<Book> getCatalog() throws ServiceException {
		
		DAOFactory factory = DAOFactory.getInstance();
		UserDao userDao = factory.getUserDao();
		
		List<Book> listBook;
		try {
			listBook = userDao.getCatalog();
		} catch (DAOException e) {
			throw new ServiceException("service message", e);
		}
		
		return listBook;
	}

}

















