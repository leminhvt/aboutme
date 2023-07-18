package spring.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.constant.Defines;
import spring.model.bean.Category;
import spring.model.bean.New;

@Repository
public class landDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String FIND_ALL_NEW = "SELECT l.*,c.tendanhmuc FROM news AS l INNER JOIN categories AS c ON l.id = c.id ";

	private static final String INSERT_ONE_NEW = "INSERT INTO news(tentin, id, hinhanh, noidung) VALUES (?,?,?,?)";

	private static final String FIND_ONE_NEW = "SELECT l.*,c.tendanhmuc FROM news AS l INNER JOIN categories AS c ON l.id = c.id WHERE l.id_tin = ?";

	private static final String UPDATE_ONE_NEW = "UPDATE news SET tentin=?, id=?, hinhanh=?, noidung=? WHERE id_tin = ?";

	private static final String DELETE_ONE_NEW = "DELETE FROM news WHERE id_tin = ?";

	private static final String COUT_ITEMS = "SELECT COUNT(*) FROM news AS l INNER JOIN categories AS c ON l.id = c.id";

	private static final String FIND_PAGINATION = "SELECT l.*,c.tendanhmuc FROM news AS l INNER JOIN categories AS c ON l.id = c.id LIMIT ?,?";

	private static final String FIND_ALL_SEARCH = "SELECT l.*,c.tendanhmuc FROM news AS l INNER JOIN categories AS c ON l.id = c.id WHERE l.tentin LIKE ?";

	private static final String DELETE_CAT_ID = "DELETE FROM news WHERE id = ?";

	private static final String FIND_THREE_NEW = "SELECT l.*,c.tendanhmuc FROM news AS l INNER JOIN categories AS c ON l.id = c.id ORDER BY l.cout DESC LIMIT ? ";

	private static final String FIND_OTHER_CAT = "SELECT l.*,c.tendanhmuc FROM news AS l INNER JOIN categories AS c ON l.id = c.id WHERE l.id_tin != ? && l.id = c.id ORDER BY l.id_tin LIMIT ?";

	private static final String FIND_ALL_CAT = "SELECT l.*,c.tendanhmuc FROM news AS l INNER JOIN categories AS c ON l.id = c.id WHERE l.id = ?";

	private static final String COUT_ITEMS_VIEW = "UPDATE news SET cout = cout + 1 WHERE id_tin = ?";

	private static final String UDATE_STATUS_ZEZO = "UPDATE news SET trangthai = ? WHERE id_tin = ?";

	private static final String UDATE_STATUS_ONE = "UPDATE news SET trangthai = ? WHERE id_tin = ?";

	private static final String FIND_STATUS = "SELECT trangthai FROM news AS l INNER JOIN categories AS c ON l.id = c.id WHERE l.id_tin = ?";

	private RowMapper<New> getRowMapper() {
		return new RowMapper<New>() {
			@Override
			public New mapRow(ResultSet rs, int rowNum) throws SQLException {
				New new1 = new New(rs.getInt("id_tin"), rs.getString("tentin"),
						new Category(rs.getInt("id"), rs.getString("tendanhmuc")), rs.getString("hinhanh"),
						rs.getInt("trangthai"), rs.getInt("cout"), rs.getString("noidung"));
				return new1;
			}
		};
	};

	public List<New> getItems() {
		return jdbcTemplate.query(FIND_ALL_NEW, getRowMapper());
	}

	public int add(New new1) {
		return jdbcTemplate.update(INSERT_ONE_NEW, new1.getTentin(), new1.getCategory().getId(), new1.getHinhanh(),
				new1.getNoidung());
	}

	public New getItem(int id) {
		return jdbcTemplate.queryForObject(FIND_ONE_NEW, getRowMapper(), id);
	}

	public int edit(New land) {
		return jdbcTemplate.update(UPDATE_ONE_NEW, land.getTentin(), land.getCategory().getId(), land.getHinhanh(),
				land.getNoidung(), land.getId_tin());
	}

	public int del(int id) {
		return jdbcTemplate.update(DELETE_ONE_NEW, id);
	}

	public int coutItems() {
		return jdbcTemplate.queryForObject(COUT_ITEMS, Integer.class);
	}

	public List<New> getItemsPagination(int offset) {
		return jdbcTemplate.query(FIND_PAGINATION, getRowMapper(), offset, Defines.ROW_COUNT);
	}

	public ArrayList<New> getItemSearch(String search) {
		try {
			return (ArrayList<New>) jdbcTemplate.query(FIND_ALL_SEARCH, getRowMapper(), "%" + search + "%");
		} catch (TransientDataAccessResourceException e) {
			return new ArrayList<New>();
		}
	}

	public void delCatId(int id) {
		jdbcTemplate.update(DELETE_CAT_ID, id);
	}

	public List<New> getItemsMore(int i) {
		return jdbcTemplate.query(FIND_THREE_NEW, getRowMapper(), i);
	}

	public List<New> getItemOther(New newnew, int three) {
		return jdbcTemplate.query(FIND_OTHER_CAT, getRowMapper(), newnew.getId_tin(), three);
	}

	public List<New> getItems(int id) {
		return jdbcTemplate.query(FIND_ALL_CAT, getRowMapper(), id);
	}

	public void increaseviews(int id) {
		jdbcTemplate.update(COUT_ITEMS_VIEW, id);
	}

	public void updateStatusZezo(int aid, int trangthai) {
		jdbcTemplate.update(UDATE_STATUS_ZEZO, trangthai, aid);
	}

	public void updateStatusOne(int aid, int trangthai) {
		jdbcTemplate.update(UDATE_STATUS_ONE, trangthai, aid);
	}

	public int getItemStatus(int aid) {
		return jdbcTemplate.queryForObject(FIND_STATUS, Integer.class, aid);
	}
}
