package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityOptionTransactionSupplement;
import fpml.confirmation.validation.EquityOptionTransactionSupplementTypeFormatValidator;
import fpml.confirmation.validation.EquityOptionTransactionSupplementValidator;
import fpml.confirmation.validation.exists.EquityOptionTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquityOptionTransactionSupplement.class)
public class EquityOptionTransactionSupplementMeta implements RosettaMetaData<EquityOptionTransactionSupplement> {

	@Override
	public List<Validator<? super EquityOptionTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.EquityOptionTransactionSupplement>create(fpml.confirmation.validation.datarule.EquityOptionTransactionSupplementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EquityOptionTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityOptionTransactionSupplement> validator() {
		return new EquityOptionTransactionSupplementValidator();
	}

	@Override
	public Validator<? super EquityOptionTransactionSupplement> typeFormatValidator() {
		return new EquityOptionTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityOptionTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new EquityOptionTransactionSupplementOnlyExistsValidator();
	}
}
