package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementTermsReference;
import fpml.confirmation.validation.SettlementTermsReferenceTypeFormatValidator;
import fpml.confirmation.validation.SettlementTermsReferenceValidator;
import fpml.confirmation.validation.exists.SettlementTermsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SettlementTermsReference.class)
public class SettlementTermsReferenceMeta implements RosettaMetaData<SettlementTermsReference> {

	@Override
	public List<Validator<? super SettlementTermsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementTermsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementTermsReference> validator() {
		return new SettlementTermsReferenceValidator();
	}

	@Override
	public Validator<? super SettlementTermsReference> typeFormatValidator() {
		return new SettlementTermsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementTermsReference, Set<String>> onlyExistsValidator() {
		return new SettlementTermsReferenceOnlyExistsValidator();
	}
}
