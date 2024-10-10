package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DealRolesModel;
import fpml.confirmation.validation.DealRolesModelTypeFormatValidator;
import fpml.confirmation.validation.DealRolesModelValidator;
import fpml.confirmation.validation.exists.DealRolesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DealRolesModel.class)
public class DealRolesModelMeta implements RosettaMetaData<DealRolesModel> {

	@Override
	public List<Validator<? super DealRolesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DealRolesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DealRolesModel> validator() {
		return new DealRolesModelValidator();
	}

	@Override
	public Validator<? super DealRolesModel> typeFormatValidator() {
		return new DealRolesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealRolesModel, Set<String>> onlyExistsValidator() {
		return new DealRolesModelOnlyExistsValidator();
	}
}
