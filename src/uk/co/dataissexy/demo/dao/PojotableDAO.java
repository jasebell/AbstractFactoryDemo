package uk.co.dataissexy.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import uk.co.dataissexy.demo.exceptions.ReadingException;
import uk.co.dataissexy.demo.exceptions.WritingException;
import uk.co.dataissexy.demo.managers.PojotableMngr;
import uk.co.dataissexy.demo.types.Pojotable;

public class PojotableDAO extends PojotableMngr {

	@Override
	public void create(Pojotable p) throws WritingException {
		PreparedStatement pstmt = null;

		Context ctx = null;
		DataSource ds = null;
		Connection c = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myjdniname");
			c = ds.getConnection();
			pstmt = c
					.prepareStatement("INSERT INTO pojotable VALUES(null, ?,?,?,?)");
			pstmt.clearParameters();
			pstmt.setString(1, p.getPid());
			pstmt.setString(2, p.getFirstname());
			pstmt.setString(3, p.getLastname());
			pstmt.setLong(4, p.getDeleteflag());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(Pojotable p) throws WritingException {
		PreparedStatement pstmt = null;

		Context ctx = null;
		DataSource ds = null;
		Connection c = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myjdniname");
			c = ds.getConnection();
			pstmt = c
					.prepareStatement("UPDATE pojotable SET deleteflag=UNIX_TIMESTAMP() WHERE pid=?");
			pstmt.clearParameters();
			pstmt.setString(1, p.getPid());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Pojotable load(String pid) throws ReadingException {
		Pojotable p = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Context ctx = null;
		DataSource ds = null;
		Connection c = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myjdniname");
			c = ds.getConnection();

			pstmt = c
					.prepareStatement("SELECT id, pid, firstname, lastname, deleteflag FROM pojotable WHERE pid=?");
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				p = new Pojotable();
				p.setId(rs.getInt("id"));
				p.setPid(rs.getString("pid"));
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				p.setDeleteflag(rs.getLong("deleteflag"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	@Override
	public List<Pojotable> loadAll() throws ReadingException {
		List<Pojotable> items = new ArrayList<Pojotable>();
		Pojotable p = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Context ctx = null;
		DataSource ds = null;
		Connection c = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myjdniname");
			c = ds.getConnection();

			pstmt = c
					.prepareStatement("SELECT * FROM barcodetype ORDER BY id ASC");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				p = new Pojotable();
				p.setId(rs.getInt("id"));
				p.setPid(rs.getString("pid"));
				p.setFirstname(rs.getString("firstname"));
				p.setLastname(rs.getString("lastname"));
				p.setDeleteflag(rs.getLong("deleteflag"));
				items.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	@Override
	public void update(Pojotable p) throws WritingException {
		PreparedStatement pstmt = null;

		Context ctx = null;
		DataSource ds = null;
		Connection c = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myjdniname");
			c = ds.getConnection();
			pstmt = c
					.prepareStatement("UPDATE pojotable SET firstname=?, lastname=?, deleteflag=? WHERE pid=? AND id=?");
			pstmt.clearParameters();
			pstmt.setString(1, p.getFirstname());
			pstmt.setString(2, p.getLastname());
			pstmt.setLong(3, p.getDeleteflag());
			pstmt.setString(4, p.getPid());
			pstmt.setInt(5, p.getId());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
