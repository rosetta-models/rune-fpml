package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel;
import fpml.confirmation.validation.CommodityDeliveryPeriodsPointerModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityDeliveryPeriodsPointerModelValidator;
import fpml.confirmation.validation.exists.CommodityDeliveryPeriodsPointerModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityDeliveryPeriodsPointerModel.class)
public class CommodityDeliveryPeriodsPointerModelMeta implements RosettaMetaData<CommodityDeliveryPeriodsPointerModel> {

	@Override
	public List<Validator<? super CommodityDeliveryPeriodsPointerModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityDeliveryPeriodsPointerModel>create(fpml.confirmation.validation.datarule.CommodityDeliveryPeriodsPointerModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityDeliveryPeriodsPointerModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityDeliveryPeriodsPointerModel> validator() {
		return new CommodityDeliveryPeriodsPointerModelValidator();
	}

	@Override
	public Validator<? super CommodityDeliveryPeriodsPointerModel> typeFormatValidator() {
		return new CommodityDeliveryPeriodsPointerModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDeliveryPeriodsPointerModel, Set<String>> onlyExistsValidator() {
		return new CommodityDeliveryPeriodsPointerModelOnlyExistsValidator();
	}
}
