package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradingInstructionOverride;
import fpml.confirmation.validation.TradingInstructionOverrideTypeFormatValidator;
import fpml.confirmation.validation.TradingInstructionOverrideValidator;
import fpml.confirmation.validation.exists.TradingInstructionOverrideOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradingInstructionOverride.class)
public class TradingInstructionOverrideMeta implements RosettaMetaData<TradingInstructionOverride> {

	@Override
	public List<Validator<? super TradingInstructionOverride>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradingInstructionOverride>create(fpml.confirmation.validation.datarule.TradingInstructionOverrideChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradingInstructionOverride, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradingInstructionOverride> validator() {
		return new TradingInstructionOverrideValidator();
	}

	@Override
	public Validator<? super TradingInstructionOverride> typeFormatValidator() {
		return new TradingInstructionOverrideTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradingInstructionOverride, Set<String>> onlyExistsValidator() {
		return new TradingInstructionOverrideOnlyExistsValidator();
	}
}
