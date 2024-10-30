package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VolatilityAmount;
import fpml.confirmation.validation.VolatilityAmountTypeFormatValidator;
import fpml.confirmation.validation.VolatilityAmountValidator;
import fpml.confirmation.validation.exists.VolatilityAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=VolatilityAmount.class)
public class VolatilityAmountMeta implements RosettaMetaData<VolatilityAmount> {

	@Override
	public List<Validator<? super VolatilityAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilityAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VolatilityAmount> validator() {
		return new VolatilityAmountValidator();
	}

	@Override
	public Validator<? super VolatilityAmount> typeFormatValidator() {
		return new VolatilityAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityAmount, Set<String>> onlyExistsValidator() {
		return new VolatilityAmountOnlyExistsValidator();
	}
}
