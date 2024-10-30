package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditLimitUtilization;
import fpml.confirmation.validation.CreditLimitUtilizationTypeFormatValidator;
import fpml.confirmation.validation.CreditLimitUtilizationValidator;
import fpml.confirmation.validation.exists.CreditLimitUtilizationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CreditLimitUtilization.class)
public class CreditLimitUtilizationMeta implements RosettaMetaData<CreditLimitUtilization> {

	@Override
	public List<Validator<? super CreditLimitUtilization>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditLimitUtilization, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditLimitUtilization> validator() {
		return new CreditLimitUtilizationValidator();
	}

	@Override
	public Validator<? super CreditLimitUtilization> typeFormatValidator() {
		return new CreditLimitUtilizationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditLimitUtilization, Set<String>> onlyExistsValidator() {
		return new CreditLimitUtilizationOnlyExistsValidator();
	}
}
