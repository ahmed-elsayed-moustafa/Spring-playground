package com.pareva.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pareva.model.MobileClubBillingPlan;


@Repository
@ComponentScan(basePackages = {"com.pareva.config"})
public class OutputMobileBillingDaoImpl implements CrudRepository<MobileClubBillingPlan, String> {
	
	/**
	 * Gets all items in the list for the JDBCtemplate(output table)
	 * @author Ahmed
	 *
	 */
	  class MobileClubBillingPlanRowMapper implements RowMapper
		{
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MobileClubBillingPlan plan = new MobileClubBillingPlan();
				plan.setUnique(rs.getString("aUnique"));
				plan.setSubUnique(rs.getString("aSubUnique"));
				plan.setExternalId(rs.getString("aExternalId"));
				plan.setClubUnique(rs.getString("aClubUnique"));
				plan.setParsedMobile(rs.getString("aParsedMobile"));
				plan.setActiveForBilling(rs.getInt("aActiveForBilling"));
				plan.setActiveForAdvancement(rs.getInt("aActiveForAdvancement"));
				plan.setSubscribed(rs.getDate("aSubscribed"));
				plan.setTariffClass(rs.getDouble("aTariffClass"));
				plan.setLastPaid(rs.getDate("aLastPaid"));
				plan.setBillingEnd(rs.getDate("aBillingEnd"));
				plan.setPartialsRequired(rs.getDouble("aPartialsRequired"));
				plan.setPartialsPaid(rs.getDouble("aPartialsPaid"));
				plan.setAdhocsRemaining(rs.getDouble("aAdhocsRemaining"));
				plan.setLastPush(rs.getDate("aLastPush"));
				plan.setPushCount(rs.getDouble("aPushCount"));
				plan.setLastSuccess(rs.getDate("aLastSuccess"));
				plan.setNextPush(rs.getDate("aNextPush"));
				plan.setNetworkCode(rs.getString("aNetworkCode"));
				plan.setContractType(rs.getString("aContractType"));
				plan.setServiceDate(rs.getDate("aServiceDate"));
				plan.setServiceDateBillsRemaining(rs.getDouble("aServiceDateBillsRemaining"));
				plan.setBillingEnd(rs.getDate("aDynamicBillingEnds"));
				plan.setBillingState(rs.getString("aBillingState"));
				plan.setPreviousSuccess(rs.getDate("aPreviousSuccess"));
				plan.setPreviousPush(rs.getDate("aPreviousPush"));
				plan.setaParam1(rs.getString("aParam1"));
				plan.setParam2(rs.getString("aParam2"));
				plan.setPublisherId(rs.getString("aPubId"));
				plan.setaCampaign(rs.getString("aCampaign"));
				plan.setaRegionCode(rs.getString("aRegionCode"));
				plan.setaRejectedCount(rs.getInt("aRejectedCount"));
				return plan;
			}
		
		}
	
	
	@Autowired
	@Qualifier("destinationJdbcTemplate")
	private JdbcTemplate destinationJdbcTemplate;
	
	@Override
	public <S extends MobileClubBillingPlan> S save(S entity) {
		return null;
	}

	public JdbcTemplate getDestinationJdbcTemplate() {
		return destinationJdbcTemplate;
	}

	@Override
	public <S extends MobileClubBillingPlan> Iterable<S> save(Iterable<S> entities) {
		return null;
	}

	@Override
	public MobileClubBillingPlan findOne(String id) {
		return null;
	}

	@Override
	public boolean exists(String id) {
		return false;
	}

	@Override
	public Iterable<MobileClubBillingPlan> findAll() {
		String sql = "SELECT * FROM mobileClubBillingPlans";
		List<MobileClubBillingPlan> list=getDestinationJdbcTemplate().query(sql, new MobileClubBillingPlanRowMapper());
		return list;
	}

	@Override
	public Iterable<MobileClubBillingPlan> findAll(Iterable<String> ids) {
		
		return null;
	}

	@Override
	public long count() {
		return destinationJdbcTemplate.queryForObject("select count(*) from mobileClubBillingPlans", Long.class);
	}

	@Override
	public void delete(String id) {
		
	}

	@Override
	public void delete(MobileClubBillingPlan entity) {
	
	}

	@Override
	public void delete(Iterable<? extends MobileClubBillingPlan> entities) {
	
	}

	@Override
	public void deleteAll() {

	}

	public void update(String query, Object[] arguments) {
		getDestinationJdbcTemplate().update(query, arguments);
	}
	
}
