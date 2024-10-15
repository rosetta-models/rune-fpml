package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NovationRolesModel;
import fpml.confirmation.validation.NovationRolesModelTypeFormatValidator;
import fpml.confirmation.validation.NovationRolesModelValidator;
import fpml.confirmation.validation.exists.NovationRolesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NovationRolesModel.class)
public class NovationRolesModelMeta implements RosettaMetaData<NovationRolesModel> {

	@Override
	public List<Validator<? super NovationRolesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NovationRolesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NovationRolesModel> validator() {
		return new NovationRolesModelValidator();
	}

	@Override
	public Validator<? super NovationRolesModel> typeFormatValidator() {
		return new NovationRolesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NovationRolesModel, Set<String>> onlyExistsValidator() {
		return new NovationRolesModelOnlyExistsValidator();
	}
}
