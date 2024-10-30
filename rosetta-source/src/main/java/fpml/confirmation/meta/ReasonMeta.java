package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Reason;
import fpml.confirmation.validation.ReasonTypeFormatValidator;
import fpml.confirmation.validation.ReasonValidator;
import fpml.confirmation.validation.exists.ReasonOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Reason.class)
public class ReasonMeta implements RosettaMetaData<Reason> {

	@Override
	public List<Validator<? super Reason>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Reason, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Reason> validator() {
		return new ReasonValidator();
	}

	@Override
	public Validator<? super Reason> typeFormatValidator() {
		return new ReasonTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Reason, Set<String>> onlyExistsValidator() {
		return new ReasonOnlyExistsValidator();
	}
}
