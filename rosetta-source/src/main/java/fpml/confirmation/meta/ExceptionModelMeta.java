package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExceptionModel;
import fpml.confirmation.validation.ExceptionModelTypeFormatValidator;
import fpml.confirmation.validation.ExceptionModelValidator;
import fpml.confirmation.validation.exists.ExceptionModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExceptionModel.class)
public class ExceptionModelMeta implements RosettaMetaData<ExceptionModel> {

	@Override
	public List<Validator<? super ExceptionModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExceptionModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExceptionModel> validator() {
		return new ExceptionModelValidator();
	}

	@Override
	public Validator<? super ExceptionModel> typeFormatValidator() {
		return new ExceptionModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExceptionModel, Set<String>> onlyExistsValidator() {
		return new ExceptionModelOnlyExistsValidator();
	}
}
