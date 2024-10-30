package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NewTradeModel;
import fpml.confirmation.validation.NewTradeModelTypeFormatValidator;
import fpml.confirmation.validation.NewTradeModelValidator;
import fpml.confirmation.validation.exists.NewTradeModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NewTradeModel.class)
public class NewTradeModelMeta implements RosettaMetaData<NewTradeModel> {

	@Override
	public List<Validator<? super NewTradeModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.NewTradeModel>create(fpml.confirmation.validation.datarule.NewTradeModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NewTradeModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NewTradeModel> validator() {
		return new NewTradeModelValidator();
	}

	@Override
	public Validator<? super NewTradeModel> typeFormatValidator() {
		return new NewTradeModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NewTradeModel, Set<String>> onlyExistsValidator() {
		return new NewTradeModelOnlyExistsValidator();
	}
}
