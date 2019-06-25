package ir.asta.training.contacts.manager;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;

import ir.asta.training.contacts.dao.CaseDao;
import ir.asta.training.contacts.dao.UserDao;
import ir.asta.training.contacts.entities.Case;
import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.wise.core.datamanagement.ActionResult;
import org.springframework.transaction.annotation.Transactional;


@Named("caseManager")
public class CaseManager {

    @Inject
    CaseDao dao;


    @Transactional
    public ActionResult<Case> save(String topic, String refer, String description, String username) {


        return new ActionResult<Case>(true, "مورد با موفقیت ثبت شد. .", dao.save(topic, refer, description, username));
    }


    public ActionResult<List<Case>> getUserCases(String username) {
        return dao.getUserCases(username);
    }

    public ActionResult<Case> getCase(String id) {
        return dao.getCase(id);
    }

    public ActionResult<List<Case>> filterCases(String username, boolean userType) {
        return dao.filterCases(username, userType);
    }

    public ActionResult<List<Case>> filtering(String status, String submitter, String responsible) {
        return dao.filtering(status, submitter, responsible);
    }

    public ActionResult<Case> updateRefer(String id, String refer) {
        return dao.updateRefer(id, refer);
    }

    public ActionResult<Case> action( String id, String status){
        return dao.action(id,status);
    }
}
