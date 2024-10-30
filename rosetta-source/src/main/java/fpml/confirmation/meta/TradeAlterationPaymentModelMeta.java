package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeAlterationPaymentModel;
import fpml.confirmation.validation.TradeAlterationPaymentModelTypeFormatValidator;
import fpml.confirmation.validation.TradeAlterationPaymentModelValidator;
import fpml.confirmation.validation.exists.TradeAlterationPaymentModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeAlterationPaymentModel.class)
public class TradeAlterationPaymentModelMeta implements RosettaMetaData<TradeAlterationPaymentModel> {

	@Override
	public List<Validator<? super TradeAlterationPaymentModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeAlterationPaymentModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeAlterationPaymentModel> validator() {
		return new TradeAlterationPaymentModelValidator();
	}

	@Override
	public Validator<? super TradeAlterationPaymentModel> typeFormatValidator() {
		return new TradeAlterationPaymentModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeAlterationPaymentModel, Set<String>> onlyExistsValidator() {
		return new TradeAlterationPaymentModelOnlyExistsValidator();
	}
}
