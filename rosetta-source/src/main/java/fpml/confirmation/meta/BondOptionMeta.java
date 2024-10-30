package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BondOption;
import fpml.confirmation.validation.BondOptionTypeFormatValidator;
import fpml.confirmation.validation.BondOptionValidator;
import fpml.confirmation.validation.exists.BondOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BondOption.class)
public class BondOptionMeta implements RosettaMetaData<BondOption> {

	@Override
	public List<Validator<? super BondOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionBaseExtended>create(fpml.confirmation.validation.datarule.OptionBaseExtendedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BondOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BondOption> validator() {
		return new BondOptionValidator();
	}

	@Override
	public Validator<? super BondOption> typeFormatValidator() {
		return new BondOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondOption, Set<String>> onlyExistsValidator() {
		return new BondOptionOnlyExistsValidator();
	}
}
