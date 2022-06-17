package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ParentChildRequest;
import za.co.sfy.sams.lucid.schema.ParentChild;

/**
 * @author muzim
 */
@Component
public class ParentChildMapper {

	public ParentChild ParentChildRequestToParentChild(ParentChildRequest parentChildRequest) {

		ParentChild parentChild = new ParentChild();

		parentChild.setAccPayer(parentChildRequest.isAccPayer());

		Integer childId = parentChildRequest.getChildId();
		if (null != childId) {
			parentChild.setChildId(Integer.valueOf(childId));
		} else {
			parentChild.setChildId(Integer.valueOf(0));
		}

		String familyCode = parentChildRequest.getFamilyCode();
		if (null != familyCode) {
			parentChild.setFamilyCode(parentChildRequest.getFamilyCode());

		}

		String learnerid = parentChildRequest.getLearnerid();
		if (null != learnerid) {
			parentChild.setLearnerid(parentChildRequest.getLearnerid());
		}

		Integer parentId = parentChildRequest.getParentId();
		if (null != parentId) {
			parentChild.setParentId(Integer.valueOf(parentId));
		} else {
			parentChild.setParentId(Integer.valueOf(0));
		}

		String pastelContact = parentChildRequest.getPastelContact();
		if (null != pastelContact) {
			parentChild.setPastelContact(parentChildRequest.getPastelContact());
		}

		String pastelCustomerAccountDescription = parentChildRequest.getPastelCustomerAccountDescription();
		if (null != pastelCustomerAccountDescription) {
			parentChild.setPastelCustomerAccountDescription(parentChildRequest.getPastelCustomerAccountDescription());

		}

		Integer pastelCustomerCategoryCode = parentChildRequest.getPastelCustomerCategoryCode();
		if (null != pastelCustomerCategoryCode) {
			parentChild.setPastelCustomerCategoryCode(Integer.valueOf(pastelCustomerCategoryCode));

		} else {
			parentChild.setPastelCustomerCategoryCode(Integer.valueOf(0));
		}

		String relation = parentChildRequest.getRelation();
		if (null != relation) {
			parentChild.setRelation(parentChildRequest.getRelation());

		}

		String resides = parentChildRequest.getResides();
		if (null != resides) {
			parentChild.setResides(parentChildRequest.getResides());
		}

		String SGBReg = parentChildRequest.getRelation();
		if (null != SGBReg) {
			parentChild.setSGBReg(parentChildRequest.getRelation());

		}

		String status = parentChildRequest.getStatus();
		if (null != status) {
			parentChild.setStatus(parentChildRequest.getStatus());
		}

		return parentChild;
	}
}
