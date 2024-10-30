package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionFeatureModel;
import fpml.confirmation.validation.OptionFeatureModelTypeFormatValidator;
import fpml.confirmation.validation.OptionFeatureModelValidator;
import fpml.confirmation.validation.exists.OptionFeatureModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionFeatureModel.class)
public class OptionFeatureModelMeta implements RosettaMetaData<OptionFeatureModel> {

	@Override
	public List<Validator<? super OptionFeatureModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionFeatureModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionFeatureModel> validator() {
		return new OptionFeatureModelValidator();
	}

	@Override
	public Validator<? super OptionFeatureModel> typeFormatValidator() {
		return new OptionFeatureModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionFeatureModel, Set<String>> onlyExistsValidator() {
		return new OptionFeatureModelOnlyExistsValidator();
	}
}
