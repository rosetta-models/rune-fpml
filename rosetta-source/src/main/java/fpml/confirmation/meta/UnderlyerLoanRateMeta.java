package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UnderlyerLoanRate;
import fpml.confirmation.validation.UnderlyerLoanRateTypeFormatValidator;
import fpml.confirmation.validation.UnderlyerLoanRateValidator;
import fpml.confirmation.validation.exists.UnderlyerLoanRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=UnderlyerLoanRate.class)
public class UnderlyerLoanRateMeta implements RosettaMetaData<UnderlyerLoanRate> {

	@Override
	public List<Validator<? super UnderlyerLoanRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnderlyerLoanRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UnderlyerLoanRate> validator() {
		return new UnderlyerLoanRateValidator();
	}

	@Override
	public Validator<? super UnderlyerLoanRate> typeFormatValidator() {
		return new UnderlyerLoanRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyerLoanRate, Set<String>> onlyExistsValidator() {
		return new UnderlyerLoanRateOnlyExistsValidator();
	}
}
