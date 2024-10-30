package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityDerivativeBase;
import fpml.confirmation.validation.EquityDerivativeBaseTypeFormatValidator;
import fpml.confirmation.validation.EquityDerivativeBaseValidator;
import fpml.confirmation.validation.exists.EquityDerivativeBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquityDerivativeBase.class)
public class EquityDerivativeBaseMeta implements RosettaMetaData<EquityDerivativeBase> {

	@Override
	public List<Validator<? super EquityDerivativeBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityDerivativeBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityDerivativeBase> validator() {
		return new EquityDerivativeBaseValidator();
	}

	@Override
	public Validator<? super EquityDerivativeBase> typeFormatValidator() {
		return new EquityDerivativeBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityDerivativeBase, Set<String>> onlyExistsValidator() {
		return new EquityDerivativeBaseOnlyExistsValidator();
	}
}
