package spring.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.model.bean.Project;
import spring.model.bean.Skill;

@Repository
public class ProjectDAO {

	private static final String FIND_ALL = "SELECT * FROM projects";
	private static final String INSERT_ONE = "INSERT INTO projects(tenduan, link, hinhanh) VALUES (?,?,?)";
	private static final String FIND_ONE = "SELECT * FROM projects WHERE id = ?";
	private static final String UPDATE_ONE = "UPDATE projects SET tenduan=?,link= ?,hinhanh= ? WHERE id = ?";
	private static final String DELETE_ONE = "DELETE FROM projects WHERE id = ?";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Project> getRowMapper() {
		return new RowMapper<Project>() {
			@Override
			public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
				Project project = new Project(rs.getInt("id"), rs.getString("tenduan"), rs.getString("link"),
						rs.getString("hinhanh"));
				return project;
			}
		};
	}

	public List<Project> getItems() {
		return jdbcTemplate.query(FIND_ALL, getRowMapper());
	}

	public int add(Project project) {
		return jdbcTemplate.update(INSERT_ONE, project.getTenduan(), project.getLink(), project.getHinhanh());
	}

	public Project getItem(int id) {
		return jdbcTemplate.queryForObject(FIND_ONE, getRowMapper(), id);
	}

	public int edit(Project project) {
		return jdbcTemplate.update(UPDATE_ONE, project.getTenduan(), project.getLink(), project.getHinhanh(),
				project.getId());
	}

	public int del(int id) {
		return jdbcTemplate.update(DELETE_ONE, id);
	}

}
