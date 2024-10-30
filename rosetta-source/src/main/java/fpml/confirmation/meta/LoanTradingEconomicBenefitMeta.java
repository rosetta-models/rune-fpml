package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingEconomicBenefit;
import fpml.confirmation.validation.LoanTradingEconomicBenefitTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingEconomicBenefitValidator;
import fpml.confirmation.validation.exists.LoanTradingEconomicBenefitOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTradingEconomicBenefit.class)
public class LoanTradingEconomicBenefitMeta implements RosettaMetaData<LoanTradingEconomicBenefit> {

	@Override
	public List<Validator<? super LoanTradingEconomicBenefit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanTradingEconomicBenefit>create(fpml.confirmation.validation.datarule.LoanTradingEconomicBenefitChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanTradingEconomicBenefit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingEconomicBenefit> validator() {
		return new LoanTradingEconomicBenefitValidator();
	}

	@Override
	public Validator<? super LoanTradingEconomicBenefit> typeFormatValidator() {
		return new LoanTradingEconomicBenefitTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingEconomicBenefit, Set<String>> onlyExistsValidator() {
		return new LoanTradingEconomicBenefitOnlyExistsValidator();
	}
}
