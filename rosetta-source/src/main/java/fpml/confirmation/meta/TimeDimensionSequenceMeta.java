package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TimeDimensionSequence;
import fpml.confirmation.validation.TimeDimensionSequenceTypeFormatValidator;
import fpml.confirmation.validation.TimeDimensionSequenceValidator;
import fpml.confirmation.validation.exists.TimeDimensionSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TimeDimensionSequence.class)
public class TimeDimensionSequenceMeta implements RosettaMetaData<TimeDimensionSequence> {

	@Override
	public List<Validator<? super TimeDimensionSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TimeDimensionSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TimeDimensionSequence> validator() {
		return new TimeDimensionSequenceValidator();
	}

	@Override
	public Validator<? super TimeDimensionSequence> typeFormatValidator() {
		return new TimeDimensionSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TimeDimensionSequence, Set<String>> onlyExistsValidator() {
		return new TimeDimensionSequenceOnlyExistsValidator();
	}
}
