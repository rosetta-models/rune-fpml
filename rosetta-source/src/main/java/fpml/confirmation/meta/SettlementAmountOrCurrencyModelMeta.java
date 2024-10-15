package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementAmountOrCurrencyModel;
import fpml.confirmation.validation.SettlementAmountOrCurrencyModelTypeFormatValidator;
import fpml.confirmation.validation.SettlementAmountOrCurrencyModelValidator;
import fpml.confirmation.validation.exists.SettlementAmountOrCurrencyModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SettlementAmountOrCurrencyModel.class)
public class SettlementAmountOrCurrencyModelMeta implements RosettaMetaData<SettlementAmountOrCurrencyModel> {

	@Override
	public List<Validator<? super SettlementAmountOrCurrencyModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.SettlementAmountOrCurrencyModel>create(fpml.confirmation.validation.datarule.SettlementAmountOrCurrencyModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementAmountOrCurrencyModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementAmountOrCurrencyModel> validator() {
		return new SettlementAmountOrCurrencyModelValidator();
	}

	@Override
	public Validator<? super SettlementAmountOrCurrencyModel> typeFormatValidator() {
		return new SettlementAmountOrCurrencyModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementAmountOrCurrencyModel, Set<String>> onlyExistsValidator() {
		return new SettlementAmountOrCurrencyModelOnlyExistsValidator();
	}
}
