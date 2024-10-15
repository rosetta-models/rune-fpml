package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VolatilityCapSequence;
import fpml.confirmation.validation.VolatilityCapSequenceTypeFormatValidator;
import fpml.confirmation.validation.VolatilityCapSequenceValidator;
import fpml.confirmation.validation.exists.VolatilityCapSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=VolatilityCapSequence.class)
public class VolatilityCapSequenceMeta implements RosettaMetaData<VolatilityCapSequence> {

	@Override
	public List<Validator<? super VolatilityCapSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilityCapSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VolatilityCapSequence> validator() {
		return new VolatilityCapSequenceValidator();
	}

	@Override
	public Validator<? super VolatilityCapSequence> typeFormatValidator() {
		return new VolatilityCapSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityCapSequence, Set<String>> onlyExistsValidator() {
		return new VolatilityCapSequenceOnlyExistsValidator();
	}
}
