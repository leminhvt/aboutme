package spring.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.model.bean.Contact;
import spring.model.bean.User;

@Repository
public class ContactDAO {

	private static final String FIND_ALL_CONTACT = "SELECT * FROM contacts";
	private static final String DELETE_ONE_CONTACT = "DELETE FROM contacts WHERE id = ?";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Contact> getRowMapper() {
		return new RowMapper<Contact>() {
			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact contact = new Contact(rs.getInt("id"), rs.getString("name"), rs.getString("diachi"),
						rs.getString("email"), rs.getString("sdt"), rs.getString("noidung"));
				return contact;
			}
		};
	};

	public List<Contact> getItems() {
		return jdbcTemplate.query(FIND_ALL_CONTACT, getRowMapper());
	}

	public int del(int id) {
		return jdbcTemplate.update(DELETE_ONE_CONTACT,id);
	}

}
