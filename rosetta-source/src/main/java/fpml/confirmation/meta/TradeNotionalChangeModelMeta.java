package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeNotionalChangeModel;
import fpml.confirmation.validation.TradeNotionalChangeModelTypeFormatValidator;
import fpml.confirmation.validation.TradeNotionalChangeModelValidator;
import fpml.confirmation.validation.exists.TradeNotionalChangeModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeNotionalChangeModel.class)
public class TradeNotionalChangeModelMeta implements RosettaMetaData<TradeNotionalChangeModel> {

	@Override
	public List<Validator<? super TradeNotionalChangeModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeNotionalChangeModel>create(fpml.confirmation.validation.datarule.TradeNotionalChangeModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeNotionalChangeModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeNotionalChangeModel> validator() {
		return new TradeNotionalChangeModelValidator();
	}

	@Override
	public Validator<? super TradeNotionalChangeModel> typeFormatValidator() {
		return new TradeNotionalChangeModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeNotionalChangeModel, Set<String>> onlyExistsValidator() {
		return new TradeNotionalChangeModelOnlyExistsValidator();
	}
}
