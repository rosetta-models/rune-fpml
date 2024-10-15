package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanContractBaseRateSet;
import fpml.confirmation.validation.LoanContractBaseRateSetTypeFormatValidator;
import fpml.confirmation.validation.LoanContractBaseRateSetValidator;
import fpml.confirmation.validation.exists.LoanContractBaseRateSetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanContractBaseRateSet.class)
public class LoanContractBaseRateSetMeta implements RosettaMetaData<LoanContractBaseRateSet> {

	@Override
	public List<Validator<? super LoanContractBaseRateSet>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanContractBaseRateSet, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanContractBaseRateSet> validator() {
		return new LoanContractBaseRateSetValidator();
	}

	@Override
	public Validator<? super LoanContractBaseRateSet> typeFormatValidator() {
		return new LoanContractBaseRateSetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractBaseRateSet, Set<String>> onlyExistsValidator() {
		return new LoanContractBaseRateSetOnlyExistsValidator();
	}
}
