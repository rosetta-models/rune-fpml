package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualLeverageSequence;
import fpml.confirmation.validation.FxAccrualLeverageSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualLeverageSequenceValidator;
import fpml.confirmation.validation.exists.FxAccrualLeverageSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAccrualLeverageSequence.class)
public class FxAccrualLeverageSequenceMeta implements RosettaMetaData<FxAccrualLeverageSequence> {

	@Override
	public List<Validator<? super FxAccrualLeverageSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualLeverageSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualLeverageSequence> validator() {
		return new FxAccrualLeverageSequenceValidator();
	}

	@Override
	public Validator<? super FxAccrualLeverageSequence> typeFormatValidator() {
		return new FxAccrualLeverageSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualLeverageSequence, Set<String>> onlyExistsValidator() {
		return new FxAccrualLeverageSequenceOnlyExistsValidator();
	}
}
