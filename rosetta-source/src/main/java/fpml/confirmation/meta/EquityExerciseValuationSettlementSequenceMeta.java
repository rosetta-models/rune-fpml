package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityExerciseValuationSettlementSequence;
import fpml.confirmation.validation.EquityExerciseValuationSettlementSequenceTypeFormatValidator;
import fpml.confirmation.validation.EquityExerciseValuationSettlementSequenceValidator;
import fpml.confirmation.validation.exists.EquityExerciseValuationSettlementSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquityExerciseValuationSettlementSequence.class)
public class EquityExerciseValuationSettlementSequenceMeta implements RosettaMetaData<EquityExerciseValuationSettlementSequence> {

	@Override
	public List<Validator<? super EquityExerciseValuationSettlementSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityExerciseValuationSettlementSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityExerciseValuationSettlementSequence> validator() {
		return new EquityExerciseValuationSettlementSequenceValidator();
	}

	@Override
	public Validator<? super EquityExerciseValuationSettlementSequence> typeFormatValidator() {
		return new EquityExerciseValuationSettlementSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityExerciseValuationSettlementSequence, Set<String>> onlyExistsValidator() {
		return new EquityExerciseValuationSettlementSequenceOnlyExistsValidator();
	}
}
