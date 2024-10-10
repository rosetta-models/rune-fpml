package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityAsset;
import fpml.confirmation.validation.EquityAssetTypeFormatValidator;
import fpml.confirmation.validation.EquityAssetValidator;
import fpml.confirmation.validation.exists.EquityAssetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EquityAsset.class)
public class EquityAssetMeta implements RosettaMetaData<EquityAsset> {

	@Override
	public List<Validator<? super EquityAsset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityAsset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityAsset> validator() {
		return new EquityAssetValidator();
	}

	@Override
	public Validator<? super EquityAsset> typeFormatValidator() {
		return new EquityAssetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityAsset, Set<String>> onlyExistsValidator() {
		return new EquityAssetOnlyExistsValidator();
	}
}
