package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LetterOfCreditRolesModel;
import fpml.confirmation.validation.LetterOfCreditRolesModelTypeFormatValidator;
import fpml.confirmation.validation.LetterOfCreditRolesModelValidator;
import fpml.confirmation.validation.exists.LetterOfCreditRolesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LetterOfCreditRolesModel.class)
public class LetterOfCreditRolesModelMeta implements RosettaMetaData<LetterOfCreditRolesModel> {

	@Override
	public List<Validator<? super LetterOfCreditRolesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LetterOfCreditRolesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LetterOfCreditRolesModel> validator() {
		return new LetterOfCreditRolesModelValidator();
	}

	@Override
	public Validator<? super LetterOfCreditRolesModel> typeFormatValidator() {
		return new LetterOfCreditRolesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LetterOfCreditRolesModel, Set<String>> onlyExistsValidator() {
		return new LetterOfCreditRolesModelOnlyExistsValidator();
	}
}
