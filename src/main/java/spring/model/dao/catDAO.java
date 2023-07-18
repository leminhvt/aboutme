package spring.model.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.model.bean.Category;

@Repository
public class catDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String FIND_ALL_CAT = "SELECT * FROM categories";

	private static final String INSERT_ONE_CAT = "INSERT INTO categories(tendanhmuc) VALUES (?)";

	private static final String DELETE_CAT_ID = "DELETE FROM categories WHERE id = ?";

	private static final String FIND_ONE_CAT = "SELECT * FROM categories WHERE id = ?";

	private static final String UPDATE_ONE_CAT = "UPDATE categories SET tendanhmuc = ? WHERE id = ?";

	public BeanPropertyRowMapper<Category> getRowMapper() {
		return new BeanPropertyRowMapper<Category>(Category.class);
	}

	public List<Category> getItems() {
		return jdbcTemplate.query(FIND_ALL_CAT, getRowMapper());

	}

	public int add(Category category) {
		return jdbcTemplate.update(INSERT_ONE_CAT, category.getTendanhmuc());
	}

	public int delItem(int id) {
		return jdbcTemplate.update(DELETE_CAT_ID, id);
	}

	public Category getItem(int id) {
		return jdbcTemplate.queryForObject(FIND_ONE_CAT, getRowMapper(), id);
	}

	public int editItem( Category category) {
		return jdbcTemplate.update(UPDATE_ONE_CAT,category.getTendanhmuc(),category.getId());
	}

}
