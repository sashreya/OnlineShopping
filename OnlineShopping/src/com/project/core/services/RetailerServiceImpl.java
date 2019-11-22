package com.project.core.services;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.project.core.daos.RetailerDao;
import com.project.core.entities.Retailer;
import com.project.core.exception.OsException;

@Service("productRetailer")
@Transactional
public class RetailerServiceImpl implements RetailerService {
		
	public RetailerServiceImpl() {
		super();
	}

	@Resource(name="retailerDao")
	private RetailerDao rdao;
	
	@Override
	@Transactional(propagation = Propagation.NEVER)
	public List<Retailer> showAllRetailer() throws OsException {
		return rdao.getAllRetailer();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addRetailer(Retailer ret) throws OsException {
		int result =rdao.insertNewRetailer(ret);
		if(result==1)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public Retailer loginRetailer(String username) {
		Retailer ret1 = new Retailer();
		ret1=rdao.getRetailerByMail(username);
		return ret1;
	}

}
