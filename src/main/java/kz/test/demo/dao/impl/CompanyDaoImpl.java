package kz.test.demo.dao.impl;

import kz.test.demo.dao.BaseDao;
import kz.test.demo.dao.CompanyDao;
import kz.test.demo.model.entity.Company;
import kz.test.demo.model.mapper.CompanyMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDaoImpl extends BaseDao implements CompanyDao {

    @Override
    public List<Company> selectAllCompany() {
       final String sql = "Select id,name from c_company";
       return jdbcTemplate.query(sql, new CompanyMapper());
    }

    @Override
    public void renameCompanyById(long id, String name) {
        final String sql = String.format("update c_company set name='%s' where id='%s'",name,id);
        jdbcTemplate.update(sql);
    }

    @Override
    public void insertNewCompany(Company company) {
        if(company.getName() == null )
        {
            return;
        }

        final String sql = String.format("Insert Into c_company (name) values ('%s')",company.getName()) ;
        jdbcTemplate.update(sql);
    }

    @Override
    public void deleteCompanyById(long id) {
        final String sql = String.format("DELETE FROM c_company Where id='%s'" ,id );
        jdbcTemplate.update(sql);
    }

    @Override
    public Company selectCompanyById(long id) {
        final String sql = "Select id,name from c_company where id = "+ id;

        try {
            return jdbcTemplate.queryForObject(sql, new CompanyMapper());
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }
}

