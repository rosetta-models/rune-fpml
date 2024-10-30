package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeOrInfoModel;
import fpml.confirmation.validation.TradeOrInfoModelTypeFormatValidator;
import fpml.confirmation.validation.TradeOrInfoModelValidator;
import fpml.confirmation.validation.exists.TradeOrInfoModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeOrInfoModel.class)
public class TradeOrInfoModelMeta implements RosettaMetaData<TradeOrInfoModel> {

	@Override
	public List<Validator<? super TradeOrInfoModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeOrInfoModel>create(fpml.confirmation.validation.datarule.TradeOrInfoModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeOrInfoModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeOrInfoModel> validator() {
		return new TradeOrInfoModelValidator();
	}

	@Override
	public Validator<? super TradeOrInfoModel> typeFormatValidator() {
		return new TradeOrInfoModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeOrInfoModel, Set<String>> onlyExistsValidator() {
		return new TradeOrInfoModelOnlyExistsValidator();
	}
}
