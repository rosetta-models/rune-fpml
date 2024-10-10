package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApplicableAssets;
import fpml.confirmation.validation.ApplicableAssetsTypeFormatValidator;
import fpml.confirmation.validation.ApplicableAssetsValidator;
import fpml.confirmation.validation.exists.ApplicableAssetsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ApplicableAssets.class)
public class ApplicableAssetsMeta implements RosettaMetaData<ApplicableAssets> {

	@Override
	public List<Validator<? super ApplicableAssets>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ApplicableAssets>create(fpml.confirmation.validation.datarule.ApplicableAssetsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ApplicableAssets, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ApplicableAssets> validator() {
		return new ApplicableAssetsValidator();
	}

	@Override
	public Validator<? super ApplicableAssets> typeFormatValidator() {
		return new ApplicableAssetsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableAssets, Set<String>> onlyExistsValidator() {
		return new ApplicableAssetsOnlyExistsValidator();
	}
}
