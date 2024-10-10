package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NovationDatesModel;
import fpml.confirmation.validation.NovationDatesModelTypeFormatValidator;
import fpml.confirmation.validation.NovationDatesModelValidator;
import fpml.confirmation.validation.exists.NovationDatesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NovationDatesModel.class)
public class NovationDatesModelMeta implements RosettaMetaData<NovationDatesModel> {

	@Override
	public List<Validator<? super NovationDatesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NovationDatesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NovationDatesModel> validator() {
		return new NovationDatesModelValidator();
	}

	@Override
	public Validator<? super NovationDatesModel> typeFormatValidator() {
		return new NovationDatesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NovationDatesModel, Set<String>> onlyExistsValidator() {
		return new NovationDatesModelOnlyExistsValidator();
	}
}
