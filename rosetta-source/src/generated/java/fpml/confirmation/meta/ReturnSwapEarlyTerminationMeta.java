package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReturnSwapEarlyTermination;
import fpml.confirmation.validation.ReturnSwapEarlyTerminationTypeFormatValidator;
import fpml.confirmation.validation.ReturnSwapEarlyTerminationValidator;
import fpml.confirmation.validation.exists.ReturnSwapEarlyTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReturnSwapEarlyTermination.class)
public class ReturnSwapEarlyTerminationMeta implements RosettaMetaData<ReturnSwapEarlyTermination> {

	@Override
	public List<Validator<? super ReturnSwapEarlyTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapEarlyTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReturnSwapEarlyTermination> validator() {
		return new ReturnSwapEarlyTerminationValidator();
	}

	@Override
	public Validator<? super ReturnSwapEarlyTermination> typeFormatValidator() {
		return new ReturnSwapEarlyTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapEarlyTermination, Set<String>> onlyExistsValidator() {
		return new ReturnSwapEarlyTerminationOnlyExistsValidator();
	}
}
