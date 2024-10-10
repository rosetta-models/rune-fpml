package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RelativeDateSequence;
import fpml.confirmation.validation.RelativeDateSequenceTypeFormatValidator;
import fpml.confirmation.validation.RelativeDateSequenceValidator;
import fpml.confirmation.validation.exists.RelativeDateSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RelativeDateSequence.class)
public class RelativeDateSequenceMeta implements RosettaMetaData<RelativeDateSequence> {

	@Override
	public List<Validator<? super RelativeDateSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RelativeDateSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RelativeDateSequence> validator() {
		return new RelativeDateSequenceValidator();
	}

	@Override
	public Validator<? super RelativeDateSequence> typeFormatValidator() {
		return new RelativeDateSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelativeDateSequence, Set<String>> onlyExistsValidator() {
		return new RelativeDateSequenceOnlyExistsValidator();
	}
}
