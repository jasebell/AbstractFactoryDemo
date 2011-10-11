package uk.co.dataissexy.demo.managers;

import java.util.List;

import uk.co.dataissexy.demo.exceptions.ReadingException;
import uk.co.dataissexy.demo.exceptions.WritingException;
import uk.co.dataissexy.demo.types.Pojotable;

public abstract class PojotableMngr {
	private static PojotableMngr instance = null;

	@SuppressWarnings("unchecked")
	private static synchronized void createInstance() {
		if (instance == null) {
			Class mgr = null;
			PojotableMngr um = null;

			try {
				String classname = "uk.co.dataissexy.demo.dao.PojotableDAO";
				mgr = Thread.currentThread().getContextClassLoader().loadClass(
						classname);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				um = (PojotableMngr) mgr.newInstance();
				instance = um;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	public static PojotableMngr getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}

	protected PojotableMngr() {
	}

	public abstract void create(Pojotable p) throws WritingException;

	public abstract void update(Pojotable p) throws WritingException;

	public abstract void delete(Pojotable p) throws WritingException;

	public abstract Pojotable load(String pid) throws ReadingException;

	public abstract List<Pojotable> loadAll() throws ReadingException;

}
