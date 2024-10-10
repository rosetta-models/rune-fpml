package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventsOrInfoModel;
import fpml.confirmation.validation.EventsOrInfoModelTypeFormatValidator;
import fpml.confirmation.validation.EventsOrInfoModelValidator;
import fpml.confirmation.validation.exists.EventsOrInfoModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EventsOrInfoModel.class)
public class EventsOrInfoModelMeta implements RosettaMetaData<EventsOrInfoModel> {

	@Override
	public List<Validator<? super EventsOrInfoModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.EventsOrInfoModel>create(fpml.confirmation.validation.datarule.EventsOrInfoModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EventsOrInfoModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EventsOrInfoModel> validator() {
		return new EventsOrInfoModelValidator();
	}

	@Override
	public Validator<? super EventsOrInfoModel> typeFormatValidator() {
		return new EventsOrInfoModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventsOrInfoModel, Set<String>> onlyExistsValidator() {
		return new EventsOrInfoModelOnlyExistsValidator();
	}
}
