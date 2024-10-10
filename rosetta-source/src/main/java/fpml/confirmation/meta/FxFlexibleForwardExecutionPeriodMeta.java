package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFlexibleForwardExecutionPeriod;
import fpml.confirmation.validation.FxFlexibleForwardExecutionPeriodTypeFormatValidator;
import fpml.confirmation.validation.FxFlexibleForwardExecutionPeriodValidator;
import fpml.confirmation.validation.exists.FxFlexibleForwardExecutionPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxFlexibleForwardExecutionPeriod.class)
public class FxFlexibleForwardExecutionPeriodMeta implements RosettaMetaData<FxFlexibleForwardExecutionPeriod> {

	@Override
	public List<Validator<? super FxFlexibleForwardExecutionPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFlexibleForwardExecutionPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFlexibleForwardExecutionPeriod> validator() {
		return new FxFlexibleForwardExecutionPeriodValidator();
	}

	@Override
	public Validator<? super FxFlexibleForwardExecutionPeriod> typeFormatValidator() {
		return new FxFlexibleForwardExecutionPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFlexibleForwardExecutionPeriod, Set<String>> onlyExistsValidator() {
		return new FxFlexibleForwardExecutionPeriodOnlyExistsValidator();
	}
}
