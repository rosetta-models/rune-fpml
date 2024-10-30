package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CrossRateSequence;
import fpml.confirmation.validation.CrossRateSequenceTypeFormatValidator;
import fpml.confirmation.validation.CrossRateSequenceValidator;
import fpml.confirmation.validation.exists.CrossRateSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CrossRateSequence.class)
public class CrossRateSequenceMeta implements RosettaMetaData<CrossRateSequence> {

	@Override
	public List<Validator<? super CrossRateSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CrossRateSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CrossRateSequence> validator() {
		return new CrossRateSequenceValidator();
	}

	@Override
	public Validator<? super CrossRateSequence> typeFormatValidator() {
		return new CrossRateSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CrossRateSequence, Set<String>> onlyExistsValidator() {
		return new CrossRateSequenceOnlyExistsValidator();
	}
}
