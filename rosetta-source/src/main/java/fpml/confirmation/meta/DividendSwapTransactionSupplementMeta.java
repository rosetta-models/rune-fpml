package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendSwapTransactionSupplement;
import fpml.confirmation.validation.DividendSwapTransactionSupplementTypeFormatValidator;
import fpml.confirmation.validation.DividendSwapTransactionSupplementValidator;
import fpml.confirmation.validation.exists.DividendSwapTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DividendSwapTransactionSupplement.class)
public class DividendSwapTransactionSupplementMeta implements RosettaMetaData<DividendSwapTransactionSupplement> {

	@Override
	public List<Validator<? super DividendSwapTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendSwapTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendSwapTransactionSupplement> validator() {
		return new DividendSwapTransactionSupplementValidator();
	}

	@Override
	public Validator<? super DividendSwapTransactionSupplement> typeFormatValidator() {
		return new DividendSwapTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendSwapTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new DividendSwapTransactionSupplementOnlyExistsValidator();
	}
}
