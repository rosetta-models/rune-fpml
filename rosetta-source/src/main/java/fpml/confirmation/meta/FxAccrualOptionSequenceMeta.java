package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualOptionSequence;
import fpml.confirmation.validation.FxAccrualOptionSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualOptionSequenceValidator;
import fpml.confirmation.validation.exists.FxAccrualOptionSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualOptionSequence.class)
public class FxAccrualOptionSequenceMeta implements RosettaMetaData<FxAccrualOptionSequence> {

	@Override
	public List<Validator<? super FxAccrualOptionSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualOptionSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualOptionSequence> validator() {
		return new FxAccrualOptionSequenceValidator();
	}

	@Override
	public Validator<? super FxAccrualOptionSequence> typeFormatValidator() {
		return new FxAccrualOptionSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualOptionSequence, Set<String>> onlyExistsValidator() {
		return new FxAccrualOptionSequenceOnlyExistsValidator();
	}
}
