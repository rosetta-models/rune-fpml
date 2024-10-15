package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MandatoryEarlyTerminationModelSequence;
import fpml.confirmation.validation.MandatoryEarlyTerminationModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.MandatoryEarlyTerminationModelSequenceValidator;
import fpml.confirmation.validation.exists.MandatoryEarlyTerminationModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MandatoryEarlyTerminationModelSequence.class)
public class MandatoryEarlyTerminationModelSequenceMeta implements RosettaMetaData<MandatoryEarlyTerminationModelSequence> {

	@Override
	public List<Validator<? super MandatoryEarlyTerminationModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MandatoryEarlyTerminationModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MandatoryEarlyTerminationModelSequence> validator() {
		return new MandatoryEarlyTerminationModelSequenceValidator();
	}

	@Override
	public Validator<? super MandatoryEarlyTerminationModelSequence> typeFormatValidator() {
		return new MandatoryEarlyTerminationModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MandatoryEarlyTerminationModelSequence, Set<String>> onlyExistsValidator() {
		return new MandatoryEarlyTerminationModelSequenceOnlyExistsValidator();
	}
}
