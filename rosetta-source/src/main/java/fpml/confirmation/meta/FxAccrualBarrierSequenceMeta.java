package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualBarrierSequence;
import fpml.confirmation.validation.FxAccrualBarrierSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualBarrierSequenceValidator;
import fpml.confirmation.validation.exists.FxAccrualBarrierSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAccrualBarrierSequence.class)
public class FxAccrualBarrierSequenceMeta implements RosettaMetaData<FxAccrualBarrierSequence> {

	@Override
	public List<Validator<? super FxAccrualBarrierSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualBarrierSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualBarrierSequence> validator() {
		return new FxAccrualBarrierSequenceValidator();
	}

	@Override
	public Validator<? super FxAccrualBarrierSequence> typeFormatValidator() {
		return new FxAccrualBarrierSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualBarrierSequence, Set<String>> onlyExistsValidator() {
		return new FxAccrualBarrierSequenceOnlyExistsValidator();
	}
}
