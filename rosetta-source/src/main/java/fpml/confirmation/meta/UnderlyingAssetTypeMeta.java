package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UnderlyingAssetType;
import fpml.confirmation.validation.UnderlyingAssetTypeTypeFormatValidator;
import fpml.confirmation.validation.UnderlyingAssetTypeValidator;
import fpml.confirmation.validation.exists.UnderlyingAssetTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UnderlyingAssetType.class)
public class UnderlyingAssetTypeMeta implements RosettaMetaData<UnderlyingAssetType> {

	@Override
	public List<Validator<? super UnderlyingAssetType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnderlyingAssetType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UnderlyingAssetType> validator() {
		return new UnderlyingAssetTypeValidator();
	}

	@Override
	public Validator<? super UnderlyingAssetType> typeFormatValidator() {
		return new UnderlyingAssetTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyingAssetType, Set<String>> onlyExistsValidator() {
		return new UnderlyingAssetTypeOnlyExistsValidator();
	}
}
