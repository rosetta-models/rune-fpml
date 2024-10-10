package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DealRulesModel;
import fpml.confirmation.validation.DealRulesModelTypeFormatValidator;
import fpml.confirmation.validation.DealRulesModelValidator;
import fpml.confirmation.validation.exists.DealRulesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DealRulesModel.class)
public class DealRulesModelMeta implements RosettaMetaData<DealRulesModel> {

	@Override
	public List<Validator<? super DealRulesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DealRulesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DealRulesModel> validator() {
		return new DealRulesModelValidator();
	}

	@Override
	public Validator<? super DealRulesModel> typeFormatValidator() {
		return new DealRulesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealRulesModel, Set<String>> onlyExistsValidator() {
		return new DealRulesModelOnlyExistsValidator();
	}
}
