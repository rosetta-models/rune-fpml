package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityRelativeExpirationDates;
import fpml.confirmation.validation.CommodityRelativeExpirationDatesTypeFormatValidator;
import fpml.confirmation.validation.CommodityRelativeExpirationDatesValidator;
import fpml.confirmation.validation.exists.CommodityRelativeExpirationDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityRelativeExpirationDates.class)
public class CommodityRelativeExpirationDatesMeta implements RosettaMetaData<CommodityRelativeExpirationDates> {

	@Override
	public List<Validator<? super CommodityRelativeExpirationDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityRelativeExpirationDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityRelativeExpirationDates> validator() {
		return new CommodityRelativeExpirationDatesValidator();
	}

	@Override
	public Validator<? super CommodityRelativeExpirationDates> typeFormatValidator() {
		return new CommodityRelativeExpirationDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityRelativeExpirationDates, Set<String>> onlyExistsValidator() {
		return new CommodityRelativeExpirationDatesOnlyExistsValidator();
	}
}
