package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericCommodityDeliveryPeriod;
import fpml.confirmation.validation.GenericCommodityDeliveryPeriodTypeFormatValidator;
import fpml.confirmation.validation.GenericCommodityDeliveryPeriodValidator;
import fpml.confirmation.validation.exists.GenericCommodityDeliveryPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GenericCommodityDeliveryPeriod.class)
public class GenericCommodityDeliveryPeriodMeta implements RosettaMetaData<GenericCommodityDeliveryPeriod> {

	@Override
	public List<Validator<? super GenericCommodityDeliveryPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericCommodityDeliveryPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericCommodityDeliveryPeriod> validator() {
		return new GenericCommodityDeliveryPeriodValidator();
	}

	@Override
	public Validator<? super GenericCommodityDeliveryPeriod> typeFormatValidator() {
		return new GenericCommodityDeliveryPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericCommodityDeliveryPeriod, Set<String>> onlyExistsValidator() {
		return new GenericCommodityDeliveryPeriodOnlyExistsValidator();
	}
}
