package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementPeriodFixingDatesSequence;
import fpml.confirmation.validation.SettlementPeriodFixingDatesSequenceTypeFormatValidator;
import fpml.confirmation.validation.SettlementPeriodFixingDatesSequenceValidator;
import fpml.confirmation.validation.exists.SettlementPeriodFixingDatesSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SettlementPeriodFixingDatesSequence.class)
public class SettlementPeriodFixingDatesSequenceMeta implements RosettaMetaData<SettlementPeriodFixingDatesSequence> {

	@Override
	public List<Validator<? super SettlementPeriodFixingDatesSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriodFixingDatesSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementPeriodFixingDatesSequence> validator() {
		return new SettlementPeriodFixingDatesSequenceValidator();
	}

	@Override
	public Validator<? super SettlementPeriodFixingDatesSequence> typeFormatValidator() {
		return new SettlementPeriodFixingDatesSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriodFixingDatesSequence, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodFixingDatesSequenceOnlyExistsValidator();
	}
}
