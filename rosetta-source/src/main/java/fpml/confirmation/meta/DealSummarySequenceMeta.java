package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DealSummarySequence;
import fpml.confirmation.validation.DealSummarySequenceTypeFormatValidator;
import fpml.confirmation.validation.DealSummarySequenceValidator;
import fpml.confirmation.validation.exists.DealSummarySequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DealSummarySequence.class)
public class DealSummarySequenceMeta implements RosettaMetaData<DealSummarySequence> {

	@Override
	public List<Validator<? super DealSummarySequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DealSummarySequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DealSummarySequence> validator() {
		return new DealSummarySequenceValidator();
	}

	@Override
	public Validator<? super DealSummarySequence> typeFormatValidator() {
		return new DealSummarySequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealSummarySequence, Set<String>> onlyExistsValidator() {
		return new DealSummarySequenceOnlyExistsValidator();
	}
}
