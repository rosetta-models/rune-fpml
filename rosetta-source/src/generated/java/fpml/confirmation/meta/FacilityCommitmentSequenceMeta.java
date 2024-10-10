package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityCommitmentSequence;
import fpml.confirmation.validation.FacilityCommitmentSequenceTypeFormatValidator;
import fpml.confirmation.validation.FacilityCommitmentSequenceValidator;
import fpml.confirmation.validation.exists.FacilityCommitmentSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityCommitmentSequence.class)
public class FacilityCommitmentSequenceMeta implements RosettaMetaData<FacilityCommitmentSequence> {

	@Override
	public List<Validator<? super FacilityCommitmentSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityCommitmentSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityCommitmentSequence> validator() {
		return new FacilityCommitmentSequenceValidator();
	}

	@Override
	public Validator<? super FacilityCommitmentSequence> typeFormatValidator() {
		return new FacilityCommitmentSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityCommitmentSequence, Set<String>> onlyExistsValidator() {
		return new FacilityCommitmentSequenceOnlyExistsValidator();
	}
}
