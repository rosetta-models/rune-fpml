package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualSettlementPeriodPayoffSequence;
import fpml.confirmation.validation.FxAccrualSettlementPeriodPayoffSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualSettlementPeriodPayoffSequenceValidator;
import fpml.confirmation.validation.exists.FxAccrualSettlementPeriodPayoffSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualSettlementPeriodPayoffSequence.class)
public class FxAccrualSettlementPeriodPayoffSequenceMeta implements RosettaMetaData<FxAccrualSettlementPeriodPayoffSequence> {

	@Override
	public List<Validator<? super FxAccrualSettlementPeriodPayoffSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualSettlementPeriodPayoffSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualSettlementPeriodPayoffSequence> validator() {
		return new FxAccrualSettlementPeriodPayoffSequenceValidator();
	}

	@Override
	public Validator<? super FxAccrualSettlementPeriodPayoffSequence> typeFormatValidator() {
		return new FxAccrualSettlementPeriodPayoffSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualSettlementPeriodPayoffSequence, Set<String>> onlyExistsValidator() {
		return new FxAccrualSettlementPeriodPayoffSequenceOnlyExistsValidator();
	}
}
