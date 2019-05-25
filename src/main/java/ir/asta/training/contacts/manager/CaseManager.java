package ir.asta.training.contacts.manager;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ir.asta.training.contacts.dao.CaseDao;
import ir.asta.training.contacts.entities.CaseEntity;
import org.springframework.transaction.annotation.Transactional;


@Named("caseManager")
public class CaseManager {

    @Inject
    CaseDao dao;

    @Transactional
    public void save(CaseEntity entity) {
        dao.save(entity);
    }

}
