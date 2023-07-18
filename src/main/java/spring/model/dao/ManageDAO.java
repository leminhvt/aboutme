package spring.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.model.bean.Manage;

@Repository
public class ManageDAO {

	private static final String FIND_ALL = "SELECT * FROM information_manage";
	private static final String INSERT_ONE = "INSERT INTO information_manage(ten, thoigian, phanloai) VALUES (?,?,?)";
	private static final String FIND_ONE = "SELECT * FROM information_manage WHERE id = ?";
	private static final String UPDATE_ONE = "UPDATE information_manage SET ten=?,thoigian=?,phanloai=? WHERE id=?";
	private static final String DELETE_ONE = "DELETE FROM information_manage WHERE id = ?";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Manage> getRowMapper() {
		return new RowMapper<Manage>() {
			@Override
			public Manage mapRow(ResultSet rs, int rowNum) throws SQLException {
				Manage manage = new Manage(rs.getInt("id"), rs.getString("ten"), rs.getString("thoigian"),
						rs.getString("phanloai"));
				return manage;
			}
		};
	}

	public List<Manage> getItems() {
		return jdbcTemplate.query(FIND_ALL, getRowMapper());
	}

	public int add(Manage manage) {
		return jdbcTemplate.update(INSERT_ONE, manage.getTen(), manage.getThoigian(), manage.getPhanloai());
	}

	public Manage getItem(int id) {
		return jdbcTemplate.queryForObject(FIND_ONE, getRowMapper(), id);
	}

	public int edit(Manage manage) {
		return jdbcTemplate.update(UPDATE_ONE, manage.getTen(), manage.getThoigian(), manage.getPhanloai(),
				manage.getId());
	}

	public int del(int id) {
		return jdbcTemplate.update(DELETE_ONE, id);
	}

}
