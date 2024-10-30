package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionsEventsBaseModel;
import fpml.confirmation.validation.OptionsEventsBaseModelTypeFormatValidator;
import fpml.confirmation.validation.OptionsEventsBaseModelValidator;
import fpml.confirmation.validation.exists.OptionsEventsBaseModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionsEventsBaseModel.class)
public class OptionsEventsBaseModelMeta implements RosettaMetaData<OptionsEventsBaseModel> {

	@Override
	public List<Validator<? super OptionsEventsBaseModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionsEventsBaseModel>create(fpml.confirmation.validation.datarule.OptionsEventsBaseModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionsEventsBaseModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionsEventsBaseModel> validator() {
		return new OptionsEventsBaseModelValidator();
	}

	@Override
	public Validator<? super OptionsEventsBaseModel> typeFormatValidator() {
		return new OptionsEventsBaseModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionsEventsBaseModel, Set<String>> onlyExistsValidator() {
		return new OptionsEventsBaseModelOnlyExistsValidator();
	}
}
