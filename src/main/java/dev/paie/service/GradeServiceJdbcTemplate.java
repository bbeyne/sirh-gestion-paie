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
			String sql = "INSERT INTO GRADE (id,code,nbHeuresBase,tauxBase) VALUES(?,?,?,?)";
			this.jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(),nouveauGrade.getNbHeuresBase(),nouveauGrade.getTauxBase());

	}

	@Override
	public void mettreAJour(Grade grade) {
		// TODO Auto-generated method stub
		String sql = "UPDATE GRADE SET nbHeuresBase =?, tauxBase=? WHERE code= ?";
		this.jdbcTemplate.update(sql,grade.getNbHeuresBase(),grade.getTauxBase(), grade.getCode());

	}

	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM `grade`";
		return this.jdbcTemplate.query(sql, (rs,rowNum)-> {
			Grade grade = new Grade(rs.getString("CODE"),new BigDecimal(rs.getString("nbHeuresBase")),new BigDecimal(rs.getString("tauxBase")));
			grade.setId(rs.getInt("ID"));
			return grade;
		});
	}
	@Override
	public Grade findbyId(Integer Id){
		return lister().stream().filter(t->t.getId()==Id).findFirst().get();
	}
	
}
