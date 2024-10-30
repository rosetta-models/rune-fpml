package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.validation.EquityValuationTypeFormatValidator;
import fpml.confirmation.validation.EquityValuationValidator;
import fpml.confirmation.validation.exists.EquityValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquityValuation.class)
public class EquityValuationMeta implements RosettaMetaData<EquityValuation> {

	@Override
	public List<Validator<? super EquityValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.EquityValuation>create(fpml.confirmation.validation.datarule.EquityValuationChoice0.class),
			factory.<fpml.confirmation.EquityValuation>create(fpml.confirmation.validation.datarule.EquityValuationChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super EquityValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityValuation> validator() {
		return new EquityValuationValidator();
	}

	@Override
	public Validator<? super EquityValuation> typeFormatValidator() {
		return new EquityValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityValuation, Set<String>> onlyExistsValidator() {
		return new EquityValuationOnlyExistsValidator();
	}
}
