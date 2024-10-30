package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.validation.OnBehalfOfModelTypeFormatValidator;
import fpml.confirmation.validation.OnBehalfOfModelValidator;
import fpml.confirmation.validation.exists.OnBehalfOfModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OnBehalfOfModel.class)
public class OnBehalfOfModelMeta implements RosettaMetaData<OnBehalfOfModel> {

	@Override
	public List<Validator<? super OnBehalfOfModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OnBehalfOfModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OnBehalfOfModel> validator() {
		return new OnBehalfOfModelValidator();
	}

	@Override
	public Validator<? super OnBehalfOfModel> typeFormatValidator() {
		return new OnBehalfOfModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OnBehalfOfModel, Set<String>> onlyExistsValidator() {
		return new OnBehalfOfModelOnlyExistsValidator();
	}
}
