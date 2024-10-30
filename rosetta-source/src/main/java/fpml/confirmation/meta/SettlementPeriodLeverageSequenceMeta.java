package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementPeriodLeverageSequence;
import fpml.confirmation.validation.SettlementPeriodLeverageSequenceTypeFormatValidator;
import fpml.confirmation.validation.SettlementPeriodLeverageSequenceValidator;
import fpml.confirmation.validation.exists.SettlementPeriodLeverageSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SettlementPeriodLeverageSequence.class)
public class SettlementPeriodLeverageSequenceMeta implements RosettaMetaData<SettlementPeriodLeverageSequence> {

	@Override
	public List<Validator<? super SettlementPeriodLeverageSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriodLeverageSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementPeriodLeverageSequence> validator() {
		return new SettlementPeriodLeverageSequenceValidator();
	}

	@Override
	public Validator<? super SettlementPeriodLeverageSequence> typeFormatValidator() {
		return new SettlementPeriodLeverageSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriodLeverageSequence, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodLeverageSequenceOnlyExistsValidator();
	}
}
