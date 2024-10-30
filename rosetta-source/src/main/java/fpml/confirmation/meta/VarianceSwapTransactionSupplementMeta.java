package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VarianceSwapTransactionSupplement;
import fpml.confirmation.validation.VarianceSwapTransactionSupplementTypeFormatValidator;
import fpml.confirmation.validation.VarianceSwapTransactionSupplementValidator;
import fpml.confirmation.validation.exists.VarianceSwapTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=VarianceSwapTransactionSupplement.class)
public class VarianceSwapTransactionSupplementMeta implements RosettaMetaData<VarianceSwapTransactionSupplement> {

	@Override
	public List<Validator<? super VarianceSwapTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VarianceSwapTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VarianceSwapTransactionSupplement> validator() {
		return new VarianceSwapTransactionSupplementValidator();
	}

	@Override
	public Validator<? super VarianceSwapTransactionSupplement> typeFormatValidator() {
		return new VarianceSwapTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VarianceSwapTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new VarianceSwapTransactionSupplementOnlyExistsValidator();
	}
}
