package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementPeriodFixingDates;
import fpml.confirmation.validation.SettlementPeriodFixingDatesTypeFormatValidator;
import fpml.confirmation.validation.SettlementPeriodFixingDatesValidator;
import fpml.confirmation.validation.exists.SettlementPeriodFixingDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SettlementPeriodFixingDates.class)
public class SettlementPeriodFixingDatesMeta implements RosettaMetaData<SettlementPeriodFixingDates> {

	@Override
	public List<Validator<? super SettlementPeriodFixingDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.SettlementPeriodFixingDates>create(fpml.confirmation.validation.datarule.SettlementPeriodFixingDatesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriodFixingDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementPeriodFixingDates> validator() {
		return new SettlementPeriodFixingDatesValidator();
	}

	@Override
	public Validator<? super SettlementPeriodFixingDates> typeFormatValidator() {
		return new SettlementPeriodFixingDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriodFixingDates, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodFixingDatesOnlyExistsValidator();
	}
}
