package spring.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.model.bean.Comment;
import spring.model.bean.New;

@Repository
public class CommentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String FIND_ALL_COMMENT = "SELECT comments.*,news.tentin FROM comments INNER JOIN news ON comments.id_tin = news.id_tin ORDER BY comments.id_cmt DESC ";

	private static final String DELETE_ONE_COMMENT = "DELETE FROM comments WHERE id_cmt = ?";

	private static final String FIND_NEW = "SELECT comments.*,news.tentin FROM comments INNER JOIN news ON comments.id_tin = news.id_tin  WHERE comments.id_tin = ? ORDER BY comments.id_cmt DESC";

	private static final String INSERT_ONE = "INSERT INTO comments(noidung, user,id_tin) VALUES (?,?,?)";

	private static final String FIND_ONE = "SELECT comments.*,news.tentin FROM comments INNER JOIN news ON comments.id_tin = news.id_tin  WHERE comments.id_tin = ? ORDER BY comments.id_cmt DESC";

	private RowMapper<Comment> getRowMapper() {
		return new RowMapper<Comment>() {
			@Override
			public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Comment comment = new Comment(rs.getInt("id_cmt"), new New(rs.getInt("id_tin"), rs.getString("tentin")),
						rs.getString("noidung"), rs.getTimestamp("ngayBL"), rs.getString("user"));
				return comment;
			}
		};
	};

	public List<Comment> getItems() {
		return jdbcTemplate.query(FIND_ALL_COMMENT, getRowMapper());
	}

	public int del(int id) {
		return jdbcTemplate.update(DELETE_ONE_COMMENT, id);
	}

	public List<Comment> getItems(int id) {
		return jdbcTemplate.query(FIND_NEW, getRowMapper(), id);
	}

	public void add(int id_tin, String user, String noidung) {
		jdbcTemplate.update(INSERT_ONE, noidung, user, id_tin);

	}

	public Comment getItemById(int id_tin) {
		return jdbcTemplate.queryForObject(FIND_ONE, getRowMapper(), id_tin);
	}

}
