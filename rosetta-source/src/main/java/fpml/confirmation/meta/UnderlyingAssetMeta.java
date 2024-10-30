package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UnderlyingAsset;
import fpml.confirmation.validation.UnderlyingAssetTypeFormatValidator;
import fpml.confirmation.validation.UnderlyingAssetValidator;
import fpml.confirmation.validation.exists.UnderlyingAssetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=UnderlyingAsset.class)
public class UnderlyingAssetMeta implements RosettaMetaData<UnderlyingAsset> {

	@Override
	public List<Validator<? super UnderlyingAsset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnderlyingAsset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UnderlyingAsset> validator() {
		return new UnderlyingAssetValidator();
	}

	@Override
	public Validator<? super UnderlyingAsset> typeFormatValidator() {
		return new UnderlyingAssetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyingAsset, Set<String>> onlyExistsValidator() {
		return new UnderlyingAssetOnlyExistsValidator();
	}
}
