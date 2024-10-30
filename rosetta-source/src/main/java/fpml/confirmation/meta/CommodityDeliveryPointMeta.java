package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.validation.CommodityDeliveryPointTypeFormatValidator;
import fpml.confirmation.validation.CommodityDeliveryPointValidator;
import fpml.confirmation.validation.exists.CommodityDeliveryPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityDeliveryPoint.class)
public class CommodityDeliveryPointMeta implements RosettaMetaData<CommodityDeliveryPoint> {

	@Override
	public List<Validator<? super CommodityDeliveryPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityDeliveryPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityDeliveryPoint> validator() {
		return new CommodityDeliveryPointValidator();
	}

	@Override
	public Validator<? super CommodityDeliveryPoint> typeFormatValidator() {
		return new CommodityDeliveryPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDeliveryPoint, Set<String>> onlyExistsValidator() {
		return new CommodityDeliveryPointOnlyExistsValidator();
	}
}
