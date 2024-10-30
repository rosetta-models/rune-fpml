package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RepoNearLegSequence;
import fpml.confirmation.validation.RepoNearLegSequenceTypeFormatValidator;
import fpml.confirmation.validation.RepoNearLegSequenceValidator;
import fpml.confirmation.validation.exists.RepoNearLegSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RepoNearLegSequence.class)
public class RepoNearLegSequenceMeta implements RosettaMetaData<RepoNearLegSequence> {

	@Override
	public List<Validator<? super RepoNearLegSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RepoNearLegSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RepoNearLegSequence> validator() {
		return new RepoNearLegSequenceValidator();
	}

	@Override
	public Validator<? super RepoNearLegSequence> typeFormatValidator() {
		return new RepoNearLegSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepoNearLegSequence, Set<String>> onlyExistsValidator() {
		return new RepoNearLegSequenceOnlyExistsValidator();
	}
}
