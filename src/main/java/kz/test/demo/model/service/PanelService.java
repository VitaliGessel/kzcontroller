package kz.test.demo.model.service;

import kz.test.demo.model.entity.Panel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PanelService {

    ResponseEntity<List<Panel>> readAllPanels();
    ResponseEntity<List<Panel>> readAllPanelsByCompanyId(long companyId);

    ResponseEntity<String> updatePanelById(long id, Panel panel);
    ResponseEntity<String> createPanel(Panel panel);

}
