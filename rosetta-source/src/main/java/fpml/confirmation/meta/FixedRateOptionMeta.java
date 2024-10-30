package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedRateOption;
import fpml.confirmation.validation.FixedRateOptionTypeFormatValidator;
import fpml.confirmation.validation.FixedRateOptionValidator;
import fpml.confirmation.validation.exists.FixedRateOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FixedRateOption.class)
public class FixedRateOptionMeta implements RosettaMetaData<FixedRateOption> {

	@Override
	public List<Validator<? super FixedRateOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedRateOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedRateOption> validator() {
		return new FixedRateOptionValidator();
	}

	@Override
	public Validator<? super FixedRateOption> typeFormatValidator() {
		return new FixedRateOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedRateOption, Set<String>> onlyExistsValidator() {
		return new FixedRateOptionOnlyExistsValidator();
	}
}
