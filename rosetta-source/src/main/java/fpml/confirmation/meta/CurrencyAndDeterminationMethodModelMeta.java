package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CurrencyAndDeterminationMethodModel;
import fpml.confirmation.validation.CurrencyAndDeterminationMethodModelTypeFormatValidator;
import fpml.confirmation.validation.CurrencyAndDeterminationMethodModelValidator;
import fpml.confirmation.validation.exists.CurrencyAndDeterminationMethodModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CurrencyAndDeterminationMethodModel.class)
public class CurrencyAndDeterminationMethodModelMeta implements RosettaMetaData<CurrencyAndDeterminationMethodModel> {

	@Override
	public List<Validator<? super CurrencyAndDeterminationMethodModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CurrencyAndDeterminationMethodModel>create(fpml.confirmation.validation.datarule.CurrencyAndDeterminationMethodModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CurrencyAndDeterminationMethodModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CurrencyAndDeterminationMethodModel> validator() {
		return new CurrencyAndDeterminationMethodModelValidator();
	}

	@Override
	public Validator<? super CurrencyAndDeterminationMethodModel> typeFormatValidator() {
		return new CurrencyAndDeterminationMethodModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CurrencyAndDeterminationMethodModel, Set<String>> onlyExistsValidator() {
		return new CurrencyAndDeterminationMethodModelOnlyExistsValidator();
	}
}
