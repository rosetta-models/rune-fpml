package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityRolesModel;
import fpml.confirmation.validation.FacilityRolesModelTypeFormatValidator;
import fpml.confirmation.validation.FacilityRolesModelValidator;
import fpml.confirmation.validation.exists.FacilityRolesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityRolesModel.class)
public class FacilityRolesModelMeta implements RosettaMetaData<FacilityRolesModel> {

	@Override
	public List<Validator<? super FacilityRolesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityRolesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityRolesModel> validator() {
		return new FacilityRolesModelValidator();
	}

	@Override
	public Validator<? super FacilityRolesModel> typeFormatValidator() {
		return new FacilityRolesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityRolesModel, Set<String>> onlyExistsValidator() {
		return new FacilityRolesModelOnlyExistsValidator();
	}
}
