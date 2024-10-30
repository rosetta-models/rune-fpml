package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AnyAssetReference;
import fpml.confirmation.validation.AnyAssetReferenceTypeFormatValidator;
import fpml.confirmation.validation.AnyAssetReferenceValidator;
import fpml.confirmation.validation.exists.AnyAssetReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AnyAssetReference.class)
public class AnyAssetReferenceMeta implements RosettaMetaData<AnyAssetReference> {

	@Override
	public List<Validator<? super AnyAssetReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnyAssetReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AnyAssetReference> validator() {
		return new AnyAssetReferenceValidator();
	}

	@Override
	public Validator<? super AnyAssetReference> typeFormatValidator() {
		return new AnyAssetReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnyAssetReference, Set<String>> onlyExistsValidator() {
		return new AnyAssetReferenceOnlyExistsValidator();
	}
}
