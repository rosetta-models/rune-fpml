package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendLeg;
import fpml.confirmation.validation.DividendLegTypeFormatValidator;
import fpml.confirmation.validation.DividendLegValidator;
import fpml.confirmation.validation.exists.DividendLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DividendLeg.class)
public class DividendLegMeta implements RosettaMetaData<DividendLeg> {

	@Override
	public List<Validator<? super DividendLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendLeg> validator() {
		return new DividendLegValidator();
	}

	@Override
	public Validator<? super DividendLeg> typeFormatValidator() {
		return new DividendLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendLeg, Set<String>> onlyExistsValidator() {
		return new DividendLegOnlyExistsValidator();
	}
}
