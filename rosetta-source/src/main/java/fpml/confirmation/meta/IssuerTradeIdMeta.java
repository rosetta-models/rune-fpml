package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IssuerTradeId;
import fpml.confirmation.validation.IssuerTradeIdTypeFormatValidator;
import fpml.confirmation.validation.IssuerTradeIdValidator;
import fpml.confirmation.validation.exists.IssuerTradeIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=IssuerTradeId.class)
public class IssuerTradeIdMeta implements RosettaMetaData<IssuerTradeId> {

	@Override
	public List<Validator<? super IssuerTradeId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IssuerTradeId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IssuerTradeId> validator() {
		return new IssuerTradeIdValidator();
	}

	@Override
	public Validator<? super IssuerTradeId> typeFormatValidator() {
		return new IssuerTradeIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IssuerTradeId, Set<String>> onlyExistsValidator() {
		return new IssuerTradeIdOnlyExistsValidator();
	}
}
