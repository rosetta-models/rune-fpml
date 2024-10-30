package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ProtectionTermsReference;
import fpml.confirmation.validation.ProtectionTermsReferenceTypeFormatValidator;
import fpml.confirmation.validation.ProtectionTermsReferenceValidator;
import fpml.confirmation.validation.exists.ProtectionTermsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ProtectionTermsReference.class)
public class ProtectionTermsReferenceMeta implements RosettaMetaData<ProtectionTermsReference> {

	@Override
	public List<Validator<? super ProtectionTermsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProtectionTermsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ProtectionTermsReference> validator() {
		return new ProtectionTermsReferenceValidator();
	}

	@Override
	public Validator<? super ProtectionTermsReference> typeFormatValidator() {
		return new ProtectionTermsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProtectionTermsReference, Set<String>> onlyExistsValidator() {
		return new ProtectionTermsReferenceOnlyExistsValidator();
	}
}
