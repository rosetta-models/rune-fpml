package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualLinearPayoffRegionSequence;
import fpml.confirmation.validation.FxAccrualLinearPayoffRegionSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualLinearPayoffRegionSequenceValidator;
import fpml.confirmation.validation.exists.FxAccrualLinearPayoffRegionSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualLinearPayoffRegionSequence.class)
public class FxAccrualLinearPayoffRegionSequenceMeta implements RosettaMetaData<FxAccrualLinearPayoffRegionSequence> {

	@Override
	public List<Validator<? super FxAccrualLinearPayoffRegionSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualLinearPayoffRegionSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualLinearPayoffRegionSequence> validator() {
		return new FxAccrualLinearPayoffRegionSequenceValidator();
	}

	@Override
	public Validator<? super FxAccrualLinearPayoffRegionSequence> typeFormatValidator() {
		return new FxAccrualLinearPayoffRegionSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualLinearPayoffRegionSequence, Set<String>> onlyExistsValidator() {
		return new FxAccrualLinearPayoffRegionSequenceOnlyExistsValidator();
	}
}
