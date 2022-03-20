package kz.test.demo.dao.impl;

import kz.test.demo.dao.BaseDao;
import kz.test.demo.dao.PanelDao;
import kz.test.demo.model.entity.Panel;
import kz.test.demo.model.mapper.PanelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PanelDaoImlp extends BaseDao implements PanelDao {

    @Override
    public List<Panel> selectAllPanels() {
        final String sql = "select id,company_id,code,mac,name,description Where c_panel  ";
        return jdbcTemplate.query(sql, new PanelMapper());
    }



    @Override
    public Panel selectPanelById(long id) {
        final String sql = "select id,company_id,code,mac,name,description Where c_panel  Where id = '" + id + "'";
        try {
            return jdbcTemplate.queryForObject(sql, new PanelMapper());
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Panel> selectAllPanelsByCompanyId(long company_id) {
        final String sql = "select id,company_id,code,mac,name,description Where c_panel  Where company_id = '" + company_id + "'";
        try {
            return jdbcTemplate.query(sql, new PanelMapper());
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertNewPanel(Panel panel) {
        final String sql = String.format("Insert Into c_panel (company_id,code,mac,name,description) values ('%s','%s','%s','%s','%s')",
                panel.getCompanyId(), panel.getCode(), panel.getMac(), panel.getName(), panel.getDescription());

        jdbcTemplate.update(sql);

    }

    @Override
    public void updatePanelById(long id, Panel panel) {
        final String sql = String.format("Update c_panel  Set company_id = '%s',code ='%s' ,mac='%s', name='%s', description='%s' Where id = '" + id + "'",
                panel.getCompanyId(), panel.getCode(), panel.getMac(), panel.getName(), panel.getDescription());

        jdbcTemplate.update(sql);

    }
}
