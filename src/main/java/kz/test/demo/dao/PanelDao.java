package kz.test.demo.dao;

import kz.test.demo.model.entity.Panel;

import java.util.List;

public interface PanelDao {

    List<Panel> selectAllPanels();
    List<Panel> selectAllPanelsByCompanyId(long company_id);
    Panel selectPanelById(long id);

    void insertNewPanel(Panel panel);
    void updatePanelById(long id,Panel panel);

}

