package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PayerModel;
import fpml.confirmation.validation.PayerModelTypeFormatValidator;
import fpml.confirmation.validation.PayerModelValidator;
import fpml.confirmation.validation.exists.PayerModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PayerModel.class)
public class PayerModelMeta implements RosettaMetaData<PayerModel> {

	@Override
	public List<Validator<? super PayerModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PayerModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PayerModel> validator() {
		return new PayerModelValidator();
	}

	@Override
	public Validator<? super PayerModel> typeFormatValidator() {
		return new PayerModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PayerModel, Set<String>> onlyExistsValidator() {
		return new PayerModelOnlyExistsValidator();
	}
}
