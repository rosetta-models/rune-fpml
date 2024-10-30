package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.validation.LoanAllocationIdentifierTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationIdentifierValidator;
import fpml.confirmation.validation.exists.LoanAllocationIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanAllocationIdentifier.class)
public class LoanAllocationIdentifierMeta implements RosettaMetaData<LoanAllocationIdentifier> {

	@Override
	public List<Validator<? super LoanAllocationIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeIdentifier>create(fpml.confirmation.validation.datarule.TradeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationIdentifier> validator() {
		return new LoanAllocationIdentifierValidator();
	}

	@Override
	public Validator<? super LoanAllocationIdentifier> typeFormatValidator() {
		return new LoanAllocationIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationIdentifier, Set<String>> onlyExistsValidator() {
		return new LoanAllocationIdentifierOnlyExistsValidator();
	}
}
