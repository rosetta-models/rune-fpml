package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcTermination;
import fpml.confirmation.validation.LcTerminationTypeFormatValidator;
import fpml.confirmation.validation.LcTerminationValidator;
import fpml.confirmation.validation.exists.LcTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LcTermination.class)
public class LcTerminationMeta implements RosettaMetaData<LcTermination> {

	@Override
	public List<Validator<? super LcTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcTermination> validator() {
		return new LcTerminationValidator();
	}

	@Override
	public Validator<? super LcTermination> typeFormatValidator() {
		return new LcTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcTermination, Set<String>> onlyExistsValidator() {
		return new LcTerminationOnlyExistsValidator();
	}
}
