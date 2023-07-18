package spring.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.model.bean.Skill;

@Repository
public class SkillDAO {

	private static final String FIND_ALL = "SELECT * FROM skills";
	private static final String INSERT_ONE = "INSERT INTO skills(tenkynang, giatri) VALUES (?,?)";
	private static final String FIND_ONE = "SELECT * FROM skills WHERE id = ?";
	private static final String UPDATE_ONE = "UPDATE skills SET tenkynang=?,giatri=? WHERE id= ?";
	private static final String DELETE_ONE = "DELETE FROM skills WHERE id = ?";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Skill> getRowMapper() {
		return new RowMapper<Skill>() {
			@Override
			public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
				Skill skill = new Skill(rs.getInt("id"), rs.getString("tenkynang"), rs.getInt("giatri"));
				return skill;
			}
		};
	};

	public List<Skill> getItems() {
		return jdbcTemplate.query(FIND_ALL, getRowMapper());
	}

	public int add(Skill skill) {
		return jdbcTemplate.update(INSERT_ONE, skill.getTenkynang(), skill.getGiatri());
	}

	public Skill getItem(int id) {
		return jdbcTemplate.queryForObject(FIND_ONE, getRowMapper(), id);
	}

	public int edit(Skill skill) {
		return jdbcTemplate.update(UPDATE_ONE, skill.getTenkynang(), skill.getGiatri(), skill.getId());
	}

	public int del(int id) {
		return jdbcTemplate.update(DELETE_ONE, id);
	}

}
