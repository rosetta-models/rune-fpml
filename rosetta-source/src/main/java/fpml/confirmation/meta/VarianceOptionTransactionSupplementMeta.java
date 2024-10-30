package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VarianceOptionTransactionSupplement;
import fpml.confirmation.validation.VarianceOptionTransactionSupplementTypeFormatValidator;
import fpml.confirmation.validation.VarianceOptionTransactionSupplementValidator;
import fpml.confirmation.validation.exists.VarianceOptionTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=VarianceOptionTransactionSupplement.class)
public class VarianceOptionTransactionSupplementMeta implements RosettaMetaData<VarianceOptionTransactionSupplement> {

	@Override
	public List<Validator<? super VarianceOptionTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.VarianceOptionTransactionSupplement>create(fpml.confirmation.validation.datarule.VarianceOptionTransactionSupplementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super VarianceOptionTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VarianceOptionTransactionSupplement> validator() {
		return new VarianceOptionTransactionSupplementValidator();
	}

	@Override
	public Validator<? super VarianceOptionTransactionSupplement> typeFormatValidator() {
		return new VarianceOptionTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VarianceOptionTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new VarianceOptionTransactionSupplementOnlyExistsValidator();
	}
}
