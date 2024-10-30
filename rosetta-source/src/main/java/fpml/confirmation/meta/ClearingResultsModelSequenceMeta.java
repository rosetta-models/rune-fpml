package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingResultsModelSequence;
import fpml.confirmation.validation.ClearingResultsModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.ClearingResultsModelSequenceValidator;
import fpml.confirmation.validation.exists.ClearingResultsModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ClearingResultsModelSequence.class)
public class ClearingResultsModelSequenceMeta implements RosettaMetaData<ClearingResultsModelSequence> {

	@Override
	public List<Validator<? super ClearingResultsModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingResultsModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingResultsModelSequence> validator() {
		return new ClearingResultsModelSequenceValidator();
	}

	@Override
	public Validator<? super ClearingResultsModelSequence> typeFormatValidator() {
		return new ClearingResultsModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingResultsModelSequence, Set<String>> onlyExistsValidator() {
		return new ClearingResultsModelSequenceOnlyExistsValidator();
	}
}
