package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DirectionalLegUnderlyerValuation;
import fpml.confirmation.validation.DirectionalLegUnderlyerValuationTypeFormatValidator;
import fpml.confirmation.validation.DirectionalLegUnderlyerValuationValidator;
import fpml.confirmation.validation.exists.DirectionalLegUnderlyerValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DirectionalLegUnderlyerValuation.class)
public class DirectionalLegUnderlyerValuationMeta implements RosettaMetaData<DirectionalLegUnderlyerValuation> {

	@Override
	public List<Validator<? super DirectionalLegUnderlyerValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DirectionalLegUnderlyerValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DirectionalLegUnderlyerValuation> validator() {
		return new DirectionalLegUnderlyerValuationValidator();
	}

	@Override
	public Validator<? super DirectionalLegUnderlyerValuation> typeFormatValidator() {
		return new DirectionalLegUnderlyerValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DirectionalLegUnderlyerValuation, Set<String>> onlyExistsValidator() {
		return new DirectionalLegUnderlyerValuationOnlyExistsValidator();
	}
}
