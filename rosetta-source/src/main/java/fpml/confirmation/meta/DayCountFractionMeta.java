package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.validation.DayCountFractionTypeFormatValidator;
import fpml.confirmation.validation.DayCountFractionValidator;
import fpml.confirmation.validation.exists.DayCountFractionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DayCountFraction.class)
public class DayCountFractionMeta implements RosettaMetaData<DayCountFraction> {

	@Override
	public List<Validator<? super DayCountFraction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DayCountFraction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DayCountFraction> validator() {
		return new DayCountFractionValidator();
	}

	@Override
	public Validator<? super DayCountFraction> typeFormatValidator() {
		return new DayCountFractionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DayCountFraction, Set<String>> onlyExistsValidator() {
		return new DayCountFractionOnlyExistsValidator();
	}
}
