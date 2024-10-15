package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionDenominationModel;
import fpml.confirmation.validation.OptionDenominationModelTypeFormatValidator;
import fpml.confirmation.validation.OptionDenominationModelValidator;
import fpml.confirmation.validation.exists.OptionDenominationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionDenominationModel.class)
public class OptionDenominationModelMeta implements RosettaMetaData<OptionDenominationModel> {

	@Override
	public List<Validator<? super OptionDenominationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionDenominationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionDenominationModel> validator() {
		return new OptionDenominationModelValidator();
	}

	@Override
	public Validator<? super OptionDenominationModel> typeFormatValidator() {
		return new OptionDenominationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionDenominationModel, Set<String>> onlyExistsValidator() {
		return new OptionDenominationModelOnlyExistsValidator();
	}
}
