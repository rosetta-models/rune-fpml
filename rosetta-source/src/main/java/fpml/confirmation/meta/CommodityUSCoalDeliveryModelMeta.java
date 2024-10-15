package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityUSCoalDeliveryModel;
import fpml.confirmation.validation.CommodityUSCoalDeliveryModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityUSCoalDeliveryModelValidator;
import fpml.confirmation.validation.exists.CommodityUSCoalDeliveryModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityUSCoalDeliveryModel.class)
public class CommodityUSCoalDeliveryModelMeta implements RosettaMetaData<CommodityUSCoalDeliveryModel> {

	@Override
	public List<Validator<? super CommodityUSCoalDeliveryModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityUSCoalDeliveryModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityUSCoalDeliveryModel> validator() {
		return new CommodityUSCoalDeliveryModelValidator();
	}

	@Override
	public Validator<? super CommodityUSCoalDeliveryModel> typeFormatValidator() {
		return new CommodityUSCoalDeliveryModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityUSCoalDeliveryModel, Set<String>> onlyExistsValidator() {
		return new CommodityUSCoalDeliveryModelOnlyExistsValidator();
	}
}
