package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UnderlyingAssetOrReferenceModel;
import fpml.confirmation.validation.UnderlyingAssetOrReferenceModelTypeFormatValidator;
import fpml.confirmation.validation.UnderlyingAssetOrReferenceModelValidator;
import fpml.confirmation.validation.exists.UnderlyingAssetOrReferenceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=UnderlyingAssetOrReferenceModel.class)
public class UnderlyingAssetOrReferenceModelMeta implements RosettaMetaData<UnderlyingAssetOrReferenceModel> {

	@Override
	public List<Validator<? super UnderlyingAssetOrReferenceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.UnderlyingAssetOrReferenceModel>create(fpml.confirmation.validation.datarule.UnderlyingAssetOrReferenceModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super UnderlyingAssetOrReferenceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UnderlyingAssetOrReferenceModel> validator() {
		return new UnderlyingAssetOrReferenceModelValidator();
	}

	@Override
	public Validator<? super UnderlyingAssetOrReferenceModel> typeFormatValidator() {
		return new UnderlyingAssetOrReferenceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyingAssetOrReferenceModel, Set<String>> onlyExistsValidator() {
		return new UnderlyingAssetOrReferenceModelOnlyExistsValidator();
	}
}
