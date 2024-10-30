package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.validation.IssuerTradeIdModelTypeFormatValidator;
import fpml.confirmation.validation.IssuerTradeIdModelValidator;
import fpml.confirmation.validation.exists.IssuerTradeIdModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=IssuerTradeIdModel.class)
public class IssuerTradeIdModelMeta implements RosettaMetaData<IssuerTradeIdModel> {

	@Override
	public List<Validator<? super IssuerTradeIdModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IssuerTradeIdModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IssuerTradeIdModel> validator() {
		return new IssuerTradeIdModelValidator();
	}

	@Override
	public Validator<? super IssuerTradeIdModel> typeFormatValidator() {
		return new IssuerTradeIdModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IssuerTradeIdModel, Set<String>> onlyExistsValidator() {
		return new IssuerTradeIdModelOnlyExistsValidator();
	}
}
