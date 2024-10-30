package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetReference;
import fpml.confirmation.validation.AssetReferenceTypeFormatValidator;
import fpml.confirmation.validation.AssetReferenceValidator;
import fpml.confirmation.validation.exists.AssetReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AssetReference.class)
public class AssetReferenceMeta implements RosettaMetaData<AssetReference> {

	@Override
	public List<Validator<? super AssetReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AssetReference> validator() {
		return new AssetReferenceValidator();
	}

	@Override
	public Validator<? super AssetReference> typeFormatValidator() {
		return new AssetReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetReference, Set<String>> onlyExistsValidator() {
		return new AssetReferenceOnlyExistsValidator();
	}
}
