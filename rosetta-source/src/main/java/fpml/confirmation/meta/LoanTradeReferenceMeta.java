package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.validation.LoanTradeReferenceTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeReferenceValidator;
import fpml.confirmation.validation.exists.LoanTradeReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTradeReference.class)
public class LoanTradeReferenceMeta implements RosettaMetaData<LoanTradeReference> {

	@Override
	public List<Validator<? super LoanTradeReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradeReference> validator() {
		return new LoanTradeReferenceValidator();
	}

	@Override
	public Validator<? super LoanTradeReference> typeFormatValidator() {
		return new LoanTradeReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeReference, Set<String>> onlyExistsValidator() {
		return new LoanTradeReferenceOnlyExistsValidator();
	}
}
