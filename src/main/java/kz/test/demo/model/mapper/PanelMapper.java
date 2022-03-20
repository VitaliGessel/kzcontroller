package kz.test.demo.model.mapper;

import kz.test.demo.model.entity.Panel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PanelMapper implements RowMapper<Panel> {

    @Override
    public Panel mapRow(ResultSet rs, int rowNum) throws SQLException {

        final Panel panel = new Panel();

        panel.setId(rs.getLong("id"));
        panel.setCompanyId(rs.getLong("company_id"));
        panel.setCode(rs.getLong("code"));

        panel.setMac(rs.getString("mac"));
        panel.setName(rs.getString("name"));
        panel.setDescription(rs.getString("description"));

        return panel;
    }
}
