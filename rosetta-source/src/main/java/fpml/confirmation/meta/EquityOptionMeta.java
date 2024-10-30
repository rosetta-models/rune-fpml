package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityOption;
import fpml.confirmation.validation.EquityOptionTypeFormatValidator;
import fpml.confirmation.validation.EquityOptionValidator;
import fpml.confirmation.validation.exists.EquityOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquityOption.class)
public class EquityOptionMeta implements RosettaMetaData<EquityOption> {

	@Override
	public List<Validator<? super EquityOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityOption> validator() {
		return new EquityOptionValidator();
	}

	@Override
	public Validator<? super EquityOption> typeFormatValidator() {
		return new EquityOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityOption, Set<String>> onlyExistsValidator() {
		return new EquityOptionOnlyExistsValidator();
	}
}
