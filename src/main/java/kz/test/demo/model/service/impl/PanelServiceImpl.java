package kz.test.demo.model.service.impl;

import kz.test.demo.dao.CompanyDao;
import kz.test.demo.dao.PanelDao;
import kz.test.demo.model.entity.Company;
import kz.test.demo.model.entity.Panel;
import kz.test.demo.model.service.PanelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanelServiceImpl implements PanelService {

    private final PanelDao panelDao;
    private final CompanyDao companyDao;

    public PanelServiceImpl(PanelDao panelDao, CompanyDao companyDao) {
        this.panelDao = panelDao;
        this.companyDao = companyDao;
    }

    @Override
    public ResponseEntity<List<Panel>> readAllPanels() {
        return ResponseEntity.ok(panelDao.selectAllPanels());
    }


    @Override
    public ResponseEntity<List<Panel>> readAllPanelsByCompanyId(long companyId) {
        final Company company = companyDao.selectCompanyById(companyId);
        if(company == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(panelDao.selectAllPanelsByCompanyId(companyId));
    }



    @Override
    public ResponseEntity<String> updatePanelById(long id, Panel panel) {

        final Panel checkPanel = panelDao.selectPanelById(id);

        if(checkPanel == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        panelDao.updatePanelById(id, panel);

        return  ResponseEntity.ok("");

    }

    @Override
    public ResponseEntity<String> createPanel(Panel panel) {

        if(panel.getMac() == null || panel.getName() == null  )
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        panelDao.insertNewPanel(panel);

        return  ResponseEntity.ok("");
    }
}
