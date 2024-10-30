package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FinancialSwapLeg;
import fpml.confirmation.validation.FinancialSwapLegTypeFormatValidator;
import fpml.confirmation.validation.FinancialSwapLegValidator;
import fpml.confirmation.validation.exists.FinancialSwapLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FinancialSwapLeg.class)
public class FinancialSwapLegMeta implements RosettaMetaData<FinancialSwapLeg> {

	@Override
	public List<Validator<? super FinancialSwapLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FinancialSwapLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FinancialSwapLeg> validator() {
		return new FinancialSwapLegValidator();
	}

	@Override
	public Validator<? super FinancialSwapLeg> typeFormatValidator() {
		return new FinancialSwapLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FinancialSwapLeg, Set<String>> onlyExistsValidator() {
		return new FinancialSwapLegOnlyExistsValidator();
	}
}
