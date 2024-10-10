package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PutCallCurrencyModel;
import fpml.confirmation.validation.PutCallCurrencyModelTypeFormatValidator;
import fpml.confirmation.validation.PutCallCurrencyModelValidator;
import fpml.confirmation.validation.exists.PutCallCurrencyModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PutCallCurrencyModel.class)
public class PutCallCurrencyModelMeta implements RosettaMetaData<PutCallCurrencyModel> {

	@Override
	public List<Validator<? super PutCallCurrencyModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PutCallCurrencyModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PutCallCurrencyModel> validator() {
		return new PutCallCurrencyModelValidator();
	}

	@Override
	public Validator<? super PutCallCurrencyModel> typeFormatValidator() {
		return new PutCallCurrencyModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PutCallCurrencyModel, Set<String>> onlyExistsValidator() {
		return new PutCallCurrencyModelOnlyExistsValidator();
	}
}
