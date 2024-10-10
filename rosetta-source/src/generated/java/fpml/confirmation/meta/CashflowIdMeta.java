package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CashflowId;
import fpml.confirmation.validation.CashflowIdTypeFormatValidator;
import fpml.confirmation.validation.CashflowIdValidator;
import fpml.confirmation.validation.exists.CashflowIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CashflowId.class)
public class CashflowIdMeta implements RosettaMetaData<CashflowId> {

	@Override
	public List<Validator<? super CashflowId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashflowId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CashflowId> validator() {
		return new CashflowIdValidator();
	}

	@Override
	public Validator<? super CashflowId> typeFormatValidator() {
		return new CashflowIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashflowId, Set<String>> onlyExistsValidator() {
		return new CashflowIdOnlyExistsValidator();
	}
}
