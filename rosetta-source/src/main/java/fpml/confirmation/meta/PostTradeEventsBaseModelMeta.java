package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.validation.PostTradeEventsBaseModelTypeFormatValidator;
import fpml.confirmation.validation.PostTradeEventsBaseModelValidator;
import fpml.confirmation.validation.exists.PostTradeEventsBaseModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PostTradeEventsBaseModel.class)
public class PostTradeEventsBaseModelMeta implements RosettaMetaData<PostTradeEventsBaseModel> {

	@Override
	public List<Validator<? super PostTradeEventsBaseModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PostTradeEventsBaseModel>create(fpml.confirmation.validation.datarule.PostTradeEventsBaseModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PostTradeEventsBaseModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PostTradeEventsBaseModel> validator() {
		return new PostTradeEventsBaseModelValidator();
	}

	@Override
	public Validator<? super PostTradeEventsBaseModel> typeFormatValidator() {
		return new PostTradeEventsBaseModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostTradeEventsBaseModel, Set<String>> onlyExistsValidator() {
		return new PostTradeEventsBaseModelOnlyExistsValidator();
	}
}
