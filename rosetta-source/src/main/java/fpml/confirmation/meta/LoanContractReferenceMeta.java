package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.validation.LoanContractReferenceTypeFormatValidator;
import fpml.confirmation.validation.LoanContractReferenceValidator;
import fpml.confirmation.validation.exists.LoanContractReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanContractReference.class)
public class LoanContractReferenceMeta implements RosettaMetaData<LoanContractReference> {

	@Override
	public List<Validator<? super LoanContractReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanContractReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanContractReference> validator() {
		return new LoanContractReferenceValidator();
	}

	@Override
	public Validator<? super LoanContractReference> typeFormatValidator() {
		return new LoanContractReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractReference, Set<String>> onlyExistsValidator() {
		return new LoanContractReferenceOnlyExistsValidator();
	}
}
