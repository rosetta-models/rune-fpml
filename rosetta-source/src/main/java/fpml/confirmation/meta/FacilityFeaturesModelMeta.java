package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityFeaturesModel;
import fpml.confirmation.validation.FacilityFeaturesModelTypeFormatValidator;
import fpml.confirmation.validation.FacilityFeaturesModelValidator;
import fpml.confirmation.validation.exists.FacilityFeaturesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityFeaturesModel.class)
public class FacilityFeaturesModelMeta implements RosettaMetaData<FacilityFeaturesModel> {

	@Override
	public List<Validator<? super FacilityFeaturesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityFeaturesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityFeaturesModel> validator() {
		return new FacilityFeaturesModelValidator();
	}

	@Override
	public Validator<? super FacilityFeaturesModel> typeFormatValidator() {
		return new FacilityFeaturesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityFeaturesModel, Set<String>> onlyExistsValidator() {
		return new FacilityFeaturesModelOnlyExistsValidator();
	}
}
