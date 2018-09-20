package com.crud.library.domain.dao;

import com.crud.library.domain.Copy;
import com.crud.library.domain.Rents;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Service
public class CopyRepositoryCustomImpl implements CopyRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void updateCopyStatus(final Rents rent, String status) {
        entityManager.joinTransaction();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Copy> criteria = builder.createCriteriaUpdate(Copy.class);
        Root<Copy> root = criteria.from(Copy.class);
        criteria.set(root.get("status"), status);
        criteria.where(builder.equal(root.get("id"), rent.getCopyId().getId()));
        entityManager.createQuery(criteria).executeUpdate();
    }
}