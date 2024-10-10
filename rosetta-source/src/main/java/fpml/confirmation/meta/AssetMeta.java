package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Asset;
import fpml.confirmation.validation.AssetTypeFormatValidator;
import fpml.confirmation.validation.AssetValidator;
import fpml.confirmation.validation.exists.AssetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Asset.class)
public class AssetMeta implements RosettaMetaData<Asset> {

	@Override
	public List<Validator<? super Asset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Asset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Asset> validator() {
		return new AssetValidator();
	}

	@Override
	public Validator<? super Asset> typeFormatValidator() {
		return new AssetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Asset, Set<String>> onlyExistsValidator() {
		return new AssetOnlyExistsValidator();
	}
}
