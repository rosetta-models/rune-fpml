package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RepoFarLegSequence;
import fpml.confirmation.validation.RepoFarLegSequenceTypeFormatValidator;
import fpml.confirmation.validation.RepoFarLegSequenceValidator;
import fpml.confirmation.validation.exists.RepoFarLegSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RepoFarLegSequence.class)
public class RepoFarLegSequenceMeta implements RosettaMetaData<RepoFarLegSequence> {

	@Override
	public List<Validator<? super RepoFarLegSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RepoFarLegSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RepoFarLegSequence> validator() {
		return new RepoFarLegSequenceValidator();
	}

	@Override
	public Validator<? super RepoFarLegSequence> typeFormatValidator() {
		return new RepoFarLegSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepoFarLegSequence, Set<String>> onlyExistsValidator() {
		return new RepoFarLegSequenceOnlyExistsValidator();
	}
}
