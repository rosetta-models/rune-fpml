package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryRisk;
import fpml.confirmation.validation.CommodityDeliveryRiskTypeFormatValidator;
import fpml.confirmation.validation.CommodityDeliveryRiskValidator;
import fpml.confirmation.validation.exists.CommodityDeliveryRiskOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityDeliveryRisk.class)
public class CommodityDeliveryRiskMeta implements RosettaMetaData<CommodityDeliveryRisk> {

	@Override
	public List<Validator<? super CommodityDeliveryRisk>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityDeliveryRisk, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityDeliveryRisk> validator() {
		return new CommodityDeliveryRiskValidator();
	}

	@Override
	public Validator<? super CommodityDeliveryRisk> typeFormatValidator() {
		return new CommodityDeliveryRiskTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDeliveryRisk, Set<String>> onlyExistsValidator() {
		return new CommodityDeliveryRiskOnlyExistsValidator();
	}
}
