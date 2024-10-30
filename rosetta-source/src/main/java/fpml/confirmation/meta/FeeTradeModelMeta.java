package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeeTradeModel;
import fpml.confirmation.validation.FeeTradeModelTypeFormatValidator;
import fpml.confirmation.validation.FeeTradeModelValidator;
import fpml.confirmation.validation.exists.FeeTradeModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FeeTradeModel.class)
public class FeeTradeModelMeta implements RosettaMetaData<FeeTradeModel> {

	@Override
	public List<Validator<? super FeeTradeModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FeeTradeModel>create(fpml.confirmation.validation.datarule.FeeTradeModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FeeTradeModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FeeTradeModel> validator() {
		return new FeeTradeModelValidator();
	}

	@Override
	public Validator<? super FeeTradeModel> typeFormatValidator() {
		return new FeeTradeModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FeeTradeModel, Set<String>> onlyExistsValidator() {
		return new FeeTradeModelOnlyExistsValidator();
	}
}
