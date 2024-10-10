package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcAccrualSequence;
import fpml.confirmation.validation.LcAccrualSequenceTypeFormatValidator;
import fpml.confirmation.validation.LcAccrualSequenceValidator;
import fpml.confirmation.validation.exists.LcAccrualSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LcAccrualSequence.class)
public class LcAccrualSequenceMeta implements RosettaMetaData<LcAccrualSequence> {

	@Override
	public List<Validator<? super LcAccrualSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcAccrualSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcAccrualSequence> validator() {
		return new LcAccrualSequenceValidator();
	}

	@Override
	public Validator<? super LcAccrualSequence> typeFormatValidator() {
		return new LcAccrualSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcAccrualSequence, Set<String>> onlyExistsValidator() {
		return new LcAccrualSequenceOnlyExistsValidator();
	}
}
