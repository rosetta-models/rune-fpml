package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.validation.FacilityDetailsModelTypeFormatValidator;
import fpml.confirmation.validation.FacilityDetailsModelValidator;
import fpml.confirmation.validation.exists.FacilityDetailsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityDetailsModel.class)
public class FacilityDetailsModelMeta implements RosettaMetaData<FacilityDetailsModel> {

	@Override
	public List<Validator<? super FacilityDetailsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FacilityDetailsModel>create(fpml.confirmation.validation.datarule.FacilityDetailsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityDetailsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityDetailsModel> validator() {
		return new FacilityDetailsModelValidator();
	}

	@Override
	public Validator<? super FacilityDetailsModel> typeFormatValidator() {
		return new FacilityDetailsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityDetailsModel, Set<String>> onlyExistsValidator() {
		return new FacilityDetailsModelOnlyExistsValidator();
	}
}
