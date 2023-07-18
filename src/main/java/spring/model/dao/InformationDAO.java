package spring.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.model.bean.Contact;
import spring.model.bean.Information;

@Repository
public class InformationDAO {

	private static final String FIND_ALL = "SELECT * FROM informations";
	private static final String INSERT_ONE = "INSERT INTO informations(name, ngaysinh, email, diachi, sdt, noidung) VALUES (?,?,?,?,?,?)";
	private static final String FIND_ONE = "SELECT * FROM informations WHERE id = ?";
	private static final String UPDATE_ONE = "UPDATE informations SET name=?,ngaysinh=?,email=?,diachi=?,sdt=?,noidung=? WHERE id = ?";
	private static final String DELETE_ONE = "DELETE FROM informations WHERE id = ?";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Information> getRowMapper() {
		return new RowMapper<Information>() {
			@Override
			public Information mapRow(ResultSet rs, int rowNum) throws SQLException {
				Information information = new Information(rs.getInt("id"), rs.getString("name"),
						rs.getString("ngaysinh"), rs.getString("email"), rs.getString("diachi"), rs.getString("sdt"),
						rs.getString("noidung"));
				return information;
			}
		};
	}

	public List<Information> getItems() {
		return jdbcTemplate.query(FIND_ALL, getRowMapper());
	}

	public int add(Information information) {
		return jdbcTemplate.update(INSERT_ONE, information.getName(), information.getNgaysinh(), information.getEmail(),
				information.getDiachi(), information.getSdt(), information.getNoidung());
	}

	public Information getItem(int id) {
		return jdbcTemplate.queryForObject(FIND_ONE, getRowMapper(), id);
	}

	public int edit(Information information) {
		return jdbcTemplate.update(UPDATE_ONE, information.getName(), information.getNgaysinh(), information.getEmail(),
				information.getDiachi(), information.getSdt(), information.getNoidung(), information.getId());
	}

	public int del(int id) {
		return jdbcTemplate.update(DELETE_ONE, id);
	};

}
