package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CashSettlementTerms;
import fpml.confirmation.validation.CashSettlementTermsTypeFormatValidator;
import fpml.confirmation.validation.CashSettlementTermsValidator;
import fpml.confirmation.validation.exists.CashSettlementTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CashSettlementTerms.class)
public class CashSettlementTermsMeta implements RosettaMetaData<CashSettlementTerms> {

	@Override
	public List<Validator<? super CashSettlementTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashSettlementTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CashSettlementTerms> validator() {
		return new CashSettlementTermsValidator();
	}

	@Override
	public Validator<? super CashSettlementTerms> typeFormatValidator() {
		return new CashSettlementTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashSettlementTerms, Set<String>> onlyExistsValidator() {
		return new CashSettlementTermsOnlyExistsValidator();
	}
}
