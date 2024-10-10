package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryPointsModel;
import fpml.confirmation.validation.CommodityDeliveryPointsModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityDeliveryPointsModelValidator;
import fpml.confirmation.validation.exists.CommodityDeliveryPointsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityDeliveryPointsModel.class)
public class CommodityDeliveryPointsModelMeta implements RosettaMetaData<CommodityDeliveryPointsModel> {

	@Override
	public List<Validator<? super CommodityDeliveryPointsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityDeliveryPointsModel>create(fpml.confirmation.validation.datarule.CommodityDeliveryPointsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityDeliveryPointsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityDeliveryPointsModel> validator() {
		return new CommodityDeliveryPointsModelValidator();
	}

	@Override
	public Validator<? super CommodityDeliveryPointsModel> typeFormatValidator() {
		return new CommodityDeliveryPointsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDeliveryPointsModel, Set<String>> onlyExistsValidator() {
		return new CommodityDeliveryPointsModelOnlyExistsValidator();
	}
}
