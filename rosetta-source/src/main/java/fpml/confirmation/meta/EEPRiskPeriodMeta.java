package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EEPRiskPeriod;
import fpml.confirmation.validation.EEPRiskPeriodTypeFormatValidator;
import fpml.confirmation.validation.EEPRiskPeriodValidator;
import fpml.confirmation.validation.exists.EEPRiskPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EEPRiskPeriod.class)
public class EEPRiskPeriodMeta implements RosettaMetaData<EEPRiskPeriod> {

	@Override
	public List<Validator<? super EEPRiskPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EEPRiskPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EEPRiskPeriod> validator() {
		return new EEPRiskPeriodValidator();
	}

	@Override
	public Validator<? super EEPRiskPeriod> typeFormatValidator() {
		return new EEPRiskPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EEPRiskPeriod, Set<String>> onlyExistsValidator() {
		return new EEPRiskPeriodOnlyExistsValidator();
	}
}
