package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonPeriodicFixedPriceLeg;
import fpml.confirmation.validation.NonPeriodicFixedPriceLegTypeFormatValidator;
import fpml.confirmation.validation.NonPeriodicFixedPriceLegValidator;
import fpml.confirmation.validation.exists.NonPeriodicFixedPriceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NonPeriodicFixedPriceLeg.class)
public class NonPeriodicFixedPriceLegMeta implements RosettaMetaData<NonPeriodicFixedPriceLeg> {

	@Override
	public List<Validator<? super NonPeriodicFixedPriceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonPeriodicFixedPriceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NonPeriodicFixedPriceLeg> validator() {
		return new NonPeriodicFixedPriceLegValidator();
	}

	@Override
	public Validator<? super NonPeriodicFixedPriceLeg> typeFormatValidator() {
		return new NonPeriodicFixedPriceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonPeriodicFixedPriceLeg, Set<String>> onlyExistsValidator() {
		return new NonPeriodicFixedPriceLegOnlyExistsValidator();
	}
}
