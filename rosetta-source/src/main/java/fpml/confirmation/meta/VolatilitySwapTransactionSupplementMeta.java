package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VolatilitySwapTransactionSupplement;
import fpml.confirmation.validation.VolatilitySwapTransactionSupplementTypeFormatValidator;
import fpml.confirmation.validation.VolatilitySwapTransactionSupplementValidator;
import fpml.confirmation.validation.exists.VolatilitySwapTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=VolatilitySwapTransactionSupplement.class)
public class VolatilitySwapTransactionSupplementMeta implements RosettaMetaData<VolatilitySwapTransactionSupplement> {

	@Override
	public List<Validator<? super VolatilitySwapTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilitySwapTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VolatilitySwapTransactionSupplement> validator() {
		return new VolatilitySwapTransactionSupplementValidator();
	}

	@Override
	public Validator<? super VolatilitySwapTransactionSupplement> typeFormatValidator() {
		return new VolatilitySwapTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilitySwapTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new VolatilitySwapTransactionSupplementOnlyExistsValidator();
	}
}
