package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquitySwapTransactionSupplement;
import fpml.confirmation.validation.EquitySwapTransactionSupplementTypeFormatValidator;
import fpml.confirmation.validation.EquitySwapTransactionSupplementValidator;
import fpml.confirmation.validation.exists.EquitySwapTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquitySwapTransactionSupplement.class)
public class EquitySwapTransactionSupplementMeta implements RosettaMetaData<EquitySwapTransactionSupplement> {

	@Override
	public List<Validator<? super EquitySwapTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquitySwapTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquitySwapTransactionSupplement> validator() {
		return new EquitySwapTransactionSupplementValidator();
	}

	@Override
	public Validator<? super EquitySwapTransactionSupplement> typeFormatValidator() {
		return new EquitySwapTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquitySwapTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new EquitySwapTransactionSupplementOnlyExistsValidator();
	}
}
