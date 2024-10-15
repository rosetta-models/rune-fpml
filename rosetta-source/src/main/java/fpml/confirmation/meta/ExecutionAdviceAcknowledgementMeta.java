package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExecutionAdviceAcknowledgement;
import fpml.confirmation.validation.ExecutionAdviceAcknowledgementTypeFormatValidator;
import fpml.confirmation.validation.ExecutionAdviceAcknowledgementValidator;
import fpml.confirmation.validation.exists.ExecutionAdviceAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExecutionAdviceAcknowledgement.class)
public class ExecutionAdviceAcknowledgementMeta implements RosettaMetaData<ExecutionAdviceAcknowledgement> {

	@Override
	public List<Validator<? super ExecutionAdviceAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionAdviceAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExecutionAdviceAcknowledgement> validator() {
		return new ExecutionAdviceAcknowledgementValidator();
	}

	@Override
	public Validator<? super ExecutionAdviceAcknowledgement> typeFormatValidator() {
		return new ExecutionAdviceAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionAdviceAcknowledgement, Set<String>> onlyExistsValidator() {
		return new ExecutionAdviceAcknowledgementOnlyExistsValidator();
	}
}
