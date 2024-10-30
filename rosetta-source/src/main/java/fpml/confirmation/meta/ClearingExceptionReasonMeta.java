package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingExceptionReason;
import fpml.confirmation.validation.ClearingExceptionReasonTypeFormatValidator;
import fpml.confirmation.validation.ClearingExceptionReasonValidator;
import fpml.confirmation.validation.exists.ClearingExceptionReasonOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ClearingExceptionReason.class)
public class ClearingExceptionReasonMeta implements RosettaMetaData<ClearingExceptionReason> {

	@Override
	public List<Validator<? super ClearingExceptionReason>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingExceptionReason, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingExceptionReason> validator() {
		return new ClearingExceptionReasonValidator();
	}

	@Override
	public Validator<? super ClearingExceptionReason> typeFormatValidator() {
		return new ClearingExceptionReasonTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingExceptionReason, Set<String>> onlyExistsValidator() {
		return new ClearingExceptionReasonOnlyExistsValidator();
	}
}
