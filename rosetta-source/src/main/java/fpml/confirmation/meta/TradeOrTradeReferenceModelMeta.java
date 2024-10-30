package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeOrTradeReferenceModel;
import fpml.confirmation.validation.TradeOrTradeReferenceModelTypeFormatValidator;
import fpml.confirmation.validation.TradeOrTradeReferenceModelValidator;
import fpml.confirmation.validation.exists.TradeOrTradeReferenceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeOrTradeReferenceModel.class)
public class TradeOrTradeReferenceModelMeta implements RosettaMetaData<TradeOrTradeReferenceModel> {

	@Override
	public List<Validator<? super TradeOrTradeReferenceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeOrTradeReferenceModel>create(fpml.confirmation.validation.datarule.TradeOrTradeReferenceModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeOrTradeReferenceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeOrTradeReferenceModel> validator() {
		return new TradeOrTradeReferenceModelValidator();
	}

	@Override
	public Validator<? super TradeOrTradeReferenceModel> typeFormatValidator() {
		return new TradeOrTradeReferenceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeOrTradeReferenceModel, Set<String>> onlyExistsValidator() {
		return new TradeOrTradeReferenceModelOnlyExistsValidator();
	}
}
