package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeService {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
	super();
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		// TODO Auto-generated method stub
			String sql = "INSERT INTO GRADE (id,code,nbHeureBase,tauxBase) VALUES(?,?,?,?)";
			this.jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(),nouveauGrade.getNbHeuresBase(),nouveauGrade.getTauxBase());

	}

	@Override
	public void mettreAJour(Grade grade) {
		// TODO Auto-generated method stub
		String sql = "UPDATE GRADE SET code = ?, nbHeureBase =?, tauxBase=? WHERE ID = ?";
		this.jdbcTemplate.update(sql, grade.getCode(),grade.getNbHeuresBase(),grade.getTauxBase(),grade.getId());

	}

	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM GRADE";
		return this.jdbcTemplate.query(sql, (rs,rowNum)-> {
			Grade grade = new Grade();
			grade.setId(rs.getInt("ID"));
			grade.setCode(rs.getString("CODE"));
			grade.setNbHeuresBase(new BigDecimal(rs.getString("nbHeureBase")));
			grade.setTauxBase(new BigDecimal(rs.getString("tauxBase")));
			return grade;
		});
	}
}
