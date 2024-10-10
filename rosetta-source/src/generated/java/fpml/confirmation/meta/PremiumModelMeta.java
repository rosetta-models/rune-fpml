package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PremiumModel;
import fpml.confirmation.validation.PremiumModelTypeFormatValidator;
import fpml.confirmation.validation.PremiumModelValidator;
import fpml.confirmation.validation.exists.PremiumModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PremiumModel.class)
public class PremiumModelMeta implements RosettaMetaData<PremiumModel> {

	@Override
	public List<Validator<? super PremiumModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PremiumModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PremiumModel> validator() {
		return new PremiumModelValidator();
	}

	@Override
	public Validator<? super PremiumModel> typeFormatValidator() {
		return new PremiumModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PremiumModel, Set<String>> onlyExistsValidator() {
		return new PremiumModelOnlyExistsValidator();
	}
}
