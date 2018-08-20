package com.myorg.vehicleinventory.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myorg.vehicleinventory.entity.Vehicle;

@Service
public class SearchService {
	
	@Autowired
    private final SessionFactory sessionFactory;
	
	@Autowired
	public SearchService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    public void initializeSearch() {
        try {
        	Session session = sessionFactory.openSession();
        	FullTextSession fullTextSession = Search.getFullTextSession(session);
        	fullTextSession.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
	@Transactional
    public List<Vehicle> fuzzySearch(String query) {
    	List<Vehicle> vehicleList = null;
    	try {
    		FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());
            QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Vehicle.class).get();
            Query luceneQuery = queryBuilder.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("type","manufacturer","model","makeYear","transportMode").matching(query).createQuery();
            javax.persistence.Query jpaQuery = fullTextSession.createFullTextQuery(luceneQuery, Vehicle.class);
            vehicleList = jpaQuery.getResultList();
    	} catch (NoResultException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        return vehicleList;
    }

}
