package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendSwapOptionTransactionSupplement;
import fpml.confirmation.validation.DividendSwapOptionTransactionSupplementTypeFormatValidator;
import fpml.confirmation.validation.DividendSwapOptionTransactionSupplementValidator;
import fpml.confirmation.validation.exists.DividendSwapOptionTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DividendSwapOptionTransactionSupplement.class)
public class DividendSwapOptionTransactionSupplementMeta implements RosettaMetaData<DividendSwapOptionTransactionSupplement> {

	@Override
	public List<Validator<? super DividendSwapOptionTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.DividendSwapOptionTransactionSupplement>create(fpml.confirmation.validation.datarule.DividendSwapOptionTransactionSupplementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DividendSwapOptionTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendSwapOptionTransactionSupplement> validator() {
		return new DividendSwapOptionTransactionSupplementValidator();
	}

	@Override
	public Validator<? super DividendSwapOptionTransactionSupplement> typeFormatValidator() {
		return new DividendSwapOptionTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendSwapOptionTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new DividendSwapOptionTransactionSupplementOnlyExistsValidator();
	}
}
