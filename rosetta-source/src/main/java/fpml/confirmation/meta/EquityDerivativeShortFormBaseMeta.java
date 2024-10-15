package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityDerivativeShortFormBase;
import fpml.confirmation.validation.EquityDerivativeShortFormBaseTypeFormatValidator;
import fpml.confirmation.validation.EquityDerivativeShortFormBaseValidator;
import fpml.confirmation.validation.exists.EquityDerivativeShortFormBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EquityDerivativeShortFormBase.class)
public class EquityDerivativeShortFormBaseMeta implements RosettaMetaData<EquityDerivativeShortFormBase> {

	@Override
	public List<Validator<? super EquityDerivativeShortFormBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityDerivativeShortFormBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityDerivativeShortFormBase> validator() {
		return new EquityDerivativeShortFormBaseValidator();
	}

	@Override
	public Validator<? super EquityDerivativeShortFormBase> typeFormatValidator() {
		return new EquityDerivativeShortFormBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityDerivativeShortFormBase, Set<String>> onlyExistsValidator() {
		return new EquityDerivativeShortFormBaseOnlyExistsValidator();
	}
}
