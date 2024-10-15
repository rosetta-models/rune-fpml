package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendPayout;
import fpml.confirmation.validation.DividendPayoutTypeFormatValidator;
import fpml.confirmation.validation.DividendPayoutValidator;
import fpml.confirmation.validation.exists.DividendPayoutOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DividendPayout.class)
public class DividendPayoutMeta implements RosettaMetaData<DividendPayout> {

	@Override
	public List<Validator<? super DividendPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.DividendPayout>create(fpml.confirmation.validation.datarule.DividendPayoutChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DividendPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendPayout> validator() {
		return new DividendPayoutValidator();
	}

	@Override
	public Validator<? super DividendPayout> typeFormatValidator() {
		return new DividendPayoutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendPayout, Set<String>> onlyExistsValidator() {
		return new DividendPayoutOnlyExistsValidator();
	}
}
