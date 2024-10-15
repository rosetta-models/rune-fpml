package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityRelativePaymentDates;
import fpml.confirmation.validation.CommodityRelativePaymentDatesTypeFormatValidator;
import fpml.confirmation.validation.CommodityRelativePaymentDatesValidator;
import fpml.confirmation.validation.exists.CommodityRelativePaymentDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityRelativePaymentDates.class)
public class CommodityRelativePaymentDatesMeta implements RosettaMetaData<CommodityRelativePaymentDates> {

	@Override
	public List<Validator<? super CommodityRelativePaymentDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityRelativePaymentDates>create(fpml.confirmation.validation.datarule.CommodityRelativePaymentDatesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityRelativePaymentDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityRelativePaymentDates> validator() {
		return new CommodityRelativePaymentDatesValidator();
	}

	@Override
	public Validator<? super CommodityRelativePaymentDates> typeFormatValidator() {
		return new CommodityRelativePaymentDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityRelativePaymentDates, Set<String>> onlyExistsValidator() {
		return new CommodityRelativePaymentDatesOnlyExistsValidator();
	}
}
