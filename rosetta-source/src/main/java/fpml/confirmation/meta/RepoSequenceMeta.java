package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RepoSequence;
import fpml.confirmation.validation.RepoSequenceTypeFormatValidator;
import fpml.confirmation.validation.RepoSequenceValidator;
import fpml.confirmation.validation.exists.RepoSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RepoSequence.class)
public class RepoSequenceMeta implements RosettaMetaData<RepoSequence> {

	@Override
	public List<Validator<? super RepoSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RepoSequence>create(fpml.confirmation.validation.datarule.RepoSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RepoSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RepoSequence> validator() {
		return new RepoSequenceValidator();
	}

	@Override
	public Validator<? super RepoSequence> typeFormatValidator() {
		return new RepoSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepoSequence, Set<String>> onlyExistsValidator() {
		return new RepoSequenceOnlyExistsValidator();
	}
}
