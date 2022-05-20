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
        parentChild.setChildId(parentChildRequest.getChildId());
        parentChild.setFamilyCode(parentChildRequest.getFamilyCode());
        parentChild.setLearnerid(parentChildRequest.getLearnerid());
        parentChild.setParentId(parentChildRequest.getParentId());
        parentChild.setPastelContact(parentChildRequest.getPastelContact());
        parentChild.setPastelCustomerAccountDescription(parentChildRequest.getPastelCustomerAccountDescription());
        parentChild.setPastelCustomerCategoryCode(parentChildRequest.getPastelCustomerCategoryCode());
        parentChild.setRelation(parentChildRequest.getRelation());
        parentChild.setResides(parentChildRequest.getResides());
        parentChild.setSGBReg(parentChildRequest.getRelation());
        parentChild.setStatus(parentChildRequest.getStatus());

        return parentChild;
    }
}
