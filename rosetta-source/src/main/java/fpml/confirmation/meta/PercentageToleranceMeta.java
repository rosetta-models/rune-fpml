package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PercentageTolerance;
import fpml.confirmation.validation.PercentageToleranceTypeFormatValidator;
import fpml.confirmation.validation.PercentageToleranceValidator;
import fpml.confirmation.validation.exists.PercentageToleranceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PercentageTolerance.class)
public class PercentageToleranceMeta implements RosettaMetaData<PercentageTolerance> {

	@Override
	public List<Validator<? super PercentageTolerance>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PercentageTolerance, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PercentageTolerance> validator() {
		return new PercentageToleranceValidator();
	}

	@Override
	public Validator<? super PercentageTolerance> typeFormatValidator() {
		return new PercentageToleranceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PercentageTolerance, Set<String>> onlyExistsValidator() {
		return new PercentageToleranceOnlyExistsValidator();
	}
}
