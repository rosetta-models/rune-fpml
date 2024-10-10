package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LetterOfCreditFeaturesModel;
import fpml.confirmation.validation.LetterOfCreditFeaturesModelTypeFormatValidator;
import fpml.confirmation.validation.LetterOfCreditFeaturesModelValidator;
import fpml.confirmation.validation.exists.LetterOfCreditFeaturesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LetterOfCreditFeaturesModel.class)
public class LetterOfCreditFeaturesModelMeta implements RosettaMetaData<LetterOfCreditFeaturesModel> {

	@Override
	public List<Validator<? super LetterOfCreditFeaturesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LetterOfCreditFeaturesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LetterOfCreditFeaturesModel> validator() {
		return new LetterOfCreditFeaturesModelValidator();
	}

	@Override
	public Validator<? super LetterOfCreditFeaturesModel> typeFormatValidator() {
		return new LetterOfCreditFeaturesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LetterOfCreditFeaturesModel, Set<String>> onlyExistsValidator() {
		return new LetterOfCreditFeaturesModelOnlyExistsValidator();
	}
}
