package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LetterOfCreditDetailsModel;
import fpml.confirmation.validation.LetterOfCreditDetailsModelTypeFormatValidator;
import fpml.confirmation.validation.LetterOfCreditDetailsModelValidator;
import fpml.confirmation.validation.exists.LetterOfCreditDetailsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LetterOfCreditDetailsModel.class)
public class LetterOfCreditDetailsModelMeta implements RosettaMetaData<LetterOfCreditDetailsModel> {

	@Override
	public List<Validator<? super LetterOfCreditDetailsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LetterOfCreditDetailsModel>create(fpml.confirmation.validation.datarule.LetterOfCreditDetailsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LetterOfCreditDetailsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LetterOfCreditDetailsModel> validator() {
		return new LetterOfCreditDetailsModelValidator();
	}

	@Override
	public Validator<? super LetterOfCreditDetailsModel> typeFormatValidator() {
		return new LetterOfCreditDetailsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LetterOfCreditDetailsModel, Set<String>> onlyExistsValidator() {
		return new LetterOfCreditDetailsModelOnlyExistsValidator();
	}
}
